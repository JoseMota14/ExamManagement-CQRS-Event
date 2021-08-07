package springboot.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Configuration.dto.RoomDTO;
import springboot.model.Room;
import springboot.rabbit.Sender;
import springboot.repository.RoomRepository;
import springboot.service.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;

    @Autowired
    private Sender sender;

    public RoomDTO entityToDto(Room e) {
        return new RoomDTO(e.name, e.id);
    }

    public List<RoomDTO> findAll(){
        Iterable<Room> configs = repository.findAll();
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room c : configs) {
            roomsDTO.add(entityToDto(c));
        }
        return roomsDTO;
    }

    @Override
    public RoomDTO findById(long id) {
        Optional<Room> c = repository.findById(id);
        if(c.isPresent()) {
            return entityToDto(c.get());
        } else {
            return new RoomDTO();
        }
    }

    @Override
    public void insertFromQueue(String message){
        try{
            JsonObject obj = new Gson().fromJson(message, JsonObject.class);
            repository.save(new Room(obj));
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
}
