package springboot.service;

import springboot.Configuration.dto.ConfigDTO;
import java.util.List;

public interface ConfigQueryService {
	
    List<ConfigDTO> findAll();
    ConfigDTO findById(long id);
    void insertFromQueue(String message);
    void deleteFromQueue(String message);
    List<ConfigDTO> findByType(String type);
    List<ConfigDTO> findByTypeK();
    List<ConfigDTO> findByTypeA();
    List<ConfigDTO> findByTypeT();
    ConfigDTO findByName(String name);
}
