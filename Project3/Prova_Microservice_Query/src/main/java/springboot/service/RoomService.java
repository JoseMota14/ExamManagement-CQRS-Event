package springboot.service;

import springboot.Configuration.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> findAll();
    RoomDTO findById(long id);
    void insertFromQueue(String message);
    void deleteFromQueue(String message);
}
