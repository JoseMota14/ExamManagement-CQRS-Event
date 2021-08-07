package springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.Configuration.dto.ReservationDTO;
import springboot.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping(path = "/reservations")
@Api(value = "Reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<ReservationDTO> getAll() {
        return reservationService.findAll();
    }

    @GetMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ReservationDTO getConfig(@PathVariable long id) {
        return reservationService.findById(id);
    }
}
