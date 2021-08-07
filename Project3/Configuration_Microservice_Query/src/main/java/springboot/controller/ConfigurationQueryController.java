package springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import springboot.Configuration.dto.ConfigDTO;
import springboot.service.ConfigQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController()
@RequestMapping("/configuration")
@Api(value = "Configs Queries", description = "Configs Query Events API")
public class ConfigurationQueryController {

    @Autowired
    ConfigQueryService configQueryService;

    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<ConfigDTO> getAll() {
        return configQueryService.findAll();
    }
    
    @GetMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ConfigDTO getConfig(@PathVariable long id) {
        return configQueryService.findById(id);
    }

    @GetMapping(value = "type/keyword", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<ConfigDTO> getCofigsTypeK() {
        return configQueryService.findByTypeK();
    }
    @GetMapping(value = "type/approach", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<ConfigDTO> getCofigsTypeA() {
        return configQueryService.findByTypeA();
    }
    @GetMapping(value = "type/tech", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public List<ConfigDTO> getCofigsType() {
        return configQueryService.findByTypeT();
    }
    
    @GetMapping(value = "name/{name}", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ConfigDTO getCofigsName(@PathVariable String name) {
        return configQueryService.findByName(name);
    }

}
