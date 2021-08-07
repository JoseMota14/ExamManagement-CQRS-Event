package springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.Configuration.dto.ReservationDTO;
import springboot.Configuration.dto.RoomDTO;
import springboot.Configuration.dto.ScoreDTO;
import springboot.service.EventService;

@RestController()
@Api(value = "Reservations")
@RequestMapping(path = "/reservations")
public class ReservationController {

    @Autowired
    EventService eventService;

    @PostMapping("")
    public String addReservation(@RequestBody ReservationDTO room) {

        if(room != null) {
            eventService.insertReservation(room);
            return "Added a reservation";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("{id}")
    public String deleteReservation(@PathVariable("id") long id) {

        if(id > 0) {
            if(eventService.deleteReservation(id)) {
                return "Deleted the reservation.";
            } else {
                return "Cannot delete the reservation.";
            }
        }
        return "The id is invalid for the reservation.";
    }

    @PutMapping("")
    public String updateReservation(@RequestBody ScoreDTO scoredto) {

        if(scoredto != null) {
            if(eventService.updateReservation(scoredto)) {
                return "Updated the reservation.";
            } else {
                return "Cannot update the reservation.";
            }
        }
        return "The id is invalid for the reservation.";
    }
}
