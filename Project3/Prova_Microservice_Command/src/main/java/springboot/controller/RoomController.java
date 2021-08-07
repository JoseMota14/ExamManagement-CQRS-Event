package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import springboot.Configuration.dto.RoomDTO;
import springboot.model.*;
import springboot.service.EventService;

@RestController()
@Api(value = "Rooms")
@RequestMapping(path = "/rooms")
public class RoomController {
	
	@Autowired
    EventService eventService;

	@PostMapping("")
    public String addRoom(@RequestBody RoomDTO room) {

        if(room != null) {
            eventService.insertRoom(room);
            return "Added a room";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("{id}")
    public String deleteRoom(@PathVariable("id") long id) {

        if(id > 0) {
            if(eventService.deleteRoom(id)) {
                return "Deleted the room.";
            } else {
                return "Cannot delete the room.";
            }
        }
        return "The id is invalid for the room.";
    }

    @PutMapping("")
    public String updateCofig(@RequestBody Event config) {
        if(config != null) {
            eventService.update(config);
            return "Updated room.";
        } else {
            return "Request does not contain a body";
        }
    }

}
