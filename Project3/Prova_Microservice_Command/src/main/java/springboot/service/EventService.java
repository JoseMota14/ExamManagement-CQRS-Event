package springboot.service;

import springboot.Configuration.dto.ReservationDTO;
import springboot.Configuration.dto.RoomDTO;
import springboot.Configuration.dto.ScoreDTO;
import springboot.model.*;

public interface EventService {

	Event insertRoom(RoomDTO p);
    boolean deleteRoom(long id);
    Event insertReservation(ReservationDTO p);
    boolean deleteReservation(long id);
    boolean updateReservation(ScoreDTO id);
    boolean update(Event p);
    
}
