package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.rabbit.Sender;
import io.swagger.annotations.Api;
import springboot.Proposal.dto.PayloadDTO;
import springboot.model.*;
import springboot.service.EventCommandService;

@RestController()
@RequestMapping("/proposal")
@Api(value = "Proposal Command", description = "Proposal command Events API")
public class ProposalCommandController {
	
	@Autowired
	EventCommandService configCommandService;
	
	@PostMapping("")
    public String addConfig(@RequestBody PayloadDTO config) {
        if(config != null) {
        	configCommandService.insert(config);
            return "Added a proposal";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("{id}")
    public String deleteConfig(@PathVariable("id") long id) {

        if(id > 0) {
            if(configCommandService.delete(id)) {
                return "Deleted the config.";
            } else {
                return "Cannot delete the config.";
            }
        }
        return "The id is invalid for the config.";
    }

    @PutMapping("")
    public String updateCofig(@RequestBody Event config) {
        if(config != null) {
        	configCommandService.update(config);
            return "Updated config.";
        } else {
            return "Request does not contain a body";
        }
    }

}
