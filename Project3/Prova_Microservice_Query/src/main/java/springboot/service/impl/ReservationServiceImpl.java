package springboot.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Configuration.dto.ReservationDTO;
import springboot.model.Reservation;
import springboot.model.Room;
import springboot.rabbit.Sender;
import springboot.repository.ReservationRepository;
import springboot.repository.RoomRepository;
import springboot.service.ReservationService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private Sender sender;

    public ReservationDTO entityToDto(Reservation e) {
        return new ReservationDTO(e.roomId, e.date , e.id, e.proposalId, e.studentId, e.arguenteId, e.score);
    }

    @Override
    public List<ReservationDTO> findAll(){
        Iterable<Reservation> reservs = repository.findAll();
        List<ReservationDTO> reservsDTO = new ArrayList<>();
        for (Reservation c : reservs) {
            reservsDTO.add(entityToDto(c));
        }
        return reservsDTO;
    }

    @Override
    public ReservationDTO findById(long id) {
        Optional<Reservation> c = repository.findById(id);
        if(c.isPresent()) {
            return entityToDto(c.get());
        } else {
            return new ReservationDTO();
        }
    }

    @Override
    public void insertFromQueue(String message){
        try{
            JsonObject obj = new Gson().fromJson(message, JsonObject.class);

            Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(obj.get("date").getAsString());
            Date datePast24Hours = getDateWithExtraHours(24);
            Date datePast1Week = getDateWithExtraHours(168);
            if(date.before(datePast24Hours) || date.after(datePast1Week)){
                throw new Exception("Date " + date + "is invalid! You can only book past 24 hours and before 1 week! ");
            }
            Long roomId = Long.parseLong(obj.get("room").getAsString());
            Optional<Room> c = roomRepository.findById(roomId);
            if(!c.isPresent()) {
                throw new Exception("Room " + roomId + " does not exist!");
            }
            Long proposal = Long.parseLong(obj.get("proposal").getAsString());
            Long student = Long.parseLong(obj.get("student").getAsString());
            Long arguente = Long.parseLong(obj.get("arguente").getAsString());
            repository.save(new Reservation(roomId, proposal, date, student, arguente));
        } catch (Exception e) {
            sender.send(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteFromQueue(String message) {
        try {
            repository.deleteById(Long.parseLong(message));
        } catch (Exception e) {
            sender.send(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateScoreById(String message) {
        JsonObject obj = new Gson().fromJson(message, JsonObject.class);
        Long id = Long.parseLong(obj.get("id").getAsString());
        Optional<Reservation> c = repository.findById(id);
        int score = Integer.parseInt(obj.get("score").getAsString());
        if(c.isPresent()) {
            if(score>=0 && score <= 20){
                Reservation r = c.get();
                if(r.date.before(new Date())){
                    r.setScore(score);
                    repository.save(r);
                }else {
                    sender.send("You can only update the date after the reservation day!");
                }
            }else{
                sender.send("Score must be between 0 and 20!");
            }
        } else {
            sender.send("Reservation with id=" + id + " not found!");
        }
    }

    private Date getDateWithExtraHours(int hours){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }
}
