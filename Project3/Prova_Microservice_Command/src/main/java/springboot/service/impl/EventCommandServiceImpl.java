package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.Configuration.dto.ReservationDTO;
import springboot.Configuration.dto.RoomDTO;
import springboot.Configuration.dto.ScoreDTO;
import springboot.model.*;
import springboot.rabbit.Sender;
import springboot.repository.EventRepository;
import springboot.service.EventService;
import com.google.gson.Gson;

@Service
public class EventCommandServiceImpl implements EventService {

	@Autowired
    private EventRepository repository;
	
	@Autowired
    private Sender sender;
	
	@Override
    public Event insertRoom(RoomDTO p) {
		String json = new Gson().toJson(p);
		sender.send(json);
        return repository.save(new Event("Create room", json));
    }

    @Override
    public boolean deleteRoom(long id) {
        try {
            String json = new Gson().toJson(id);
            sender.sendDelete(json);
            repository.save(new Event("Delete room by id", json));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Event p) {
        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Event insertReservation(ReservationDTO p) {
        String json = new Gson().toJson(p);
        sender.sendNewReservation(json);
        return repository.save(new Event("Create reservation", json));
    }

    @Override
    public boolean deleteReservation(long id) {
        try {
            String json = new Gson().toJson(id);
            sender.sendDeleteReservation(json);
            repository.save(new Event("Delete reservation by id", json));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateReservation(ScoreDTO id) {
        try {
            String json = new Gson().toJson(id);
            sender.sendUpdateReservation(json);
            repository.save(new Event("Update reservation by id", json));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
