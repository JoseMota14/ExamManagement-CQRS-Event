package springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import springboot.Proposal.dto.ProposalDTO;
import springboot.service.ProposalQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController()
@RequestMapping("/proposal")
@Api(value = "Proposal Queries", description = "Proposal Query Events API")
public class ProposalQueryController {

    @Autowired
    ProposalQueryService proposalQueryService;

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<ProposalDTO> getAll() {
        return proposalQueryService.findAll();
    }
    
    @GetMapping("{id}")
    public ProposalDTO getProposal(@PathVariable long id) {
        return proposalQueryService.findById(id);
    }

}
