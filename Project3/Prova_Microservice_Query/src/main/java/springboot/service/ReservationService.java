package springboot.service;

import springboot.Configuration.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> findAll();
    ReservationDTO findById(long id);
    void updateScoreById(String message);
    void insertFromQueue(String message);
    void deleteFromQueue(String message);
}
