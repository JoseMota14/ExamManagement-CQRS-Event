package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import springboot.Configuration.dto.ConfigDTO;
import springboot.model.Config;
import springboot.model.Type;
import springboot.rabbit.Sender;
import springboot.repository.ConfigRepository;
import springboot.service.ConfigQueryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConfigQueryServiceImpl implements ConfigQueryService{

	@Autowired
    private ConfigRepository repository;

	@Autowired
	private Sender sender;
	
	public ConfigDTO entityToDto(Config e) {
		return new ConfigDTO(e.name, e.type.toString());
	}
	
	public List<ConfigDTO> findAll(){
		Iterable<Config> configs = repository.findAll();
		List<ConfigDTO> configsDTO = new ArrayList<>();
		for (Config c : configs) {
			configsDTO.add(entityToDto(c));
		}
		return configsDTO;
	}

	@Override
	public ConfigDTO findById(long id) {
		Optional<Config> c = repository.findById(id);
		if(c.isPresent()) {
			return entityToDto(c.get());
		}
		else {
			return new ConfigDTO();
		}
	}
	
	@Override
    public void insertFromQueue(String message){
		try{
			JsonObject obj = new Gson().fromJson(message, JsonObject.class);
			repository.save(new Config(obj));
		} catch (Exception e) {
			sender.send(e.getMessage());
			System.out.println(e.getMessage());
		}
    }

	@Override
	public void deleteFromQueue(String message) {
		try {
			repository.deleteById(Long.parseLong(message));
		} catch (Exception e) {
			sender.send(e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public List<ConfigDTO> findByType(String type) {
		Iterable<Config> configs = repository.findByType(Type.valueOf(type));
		List<ConfigDTO> configsDTO = new ArrayList<>();
		for (Config c : configs) {
			configsDTO.add(entityToDto(c));
		}
		return configsDTO;
    }
	
	public List<ConfigDTO> findByTypeK() {
		Iterable<Config> configs = repository.findByTypeKeyword();
		List<ConfigDTO> configsDTO = new ArrayList<>();
		for (Config c : configs) {
			configsDTO.add(entityToDto(c));
		}
		return configsDTO;
    }
	
	public List<ConfigDTO> findByTypeA() {
		Iterable<Config> configs = repository.findByTypeApproach();
		List<ConfigDTO> configsDTO = new ArrayList<>();
		for (Config c : configs) {
			configsDTO.add(entityToDto(c));
		}
		return configsDTO;
    }
	
	public List<ConfigDTO> findByTypeT() {
		Iterable<Config> configs = repository.findByTypeTech();
		List<ConfigDTO> configsDTO = new ArrayList<>();
		for (Config c : configs) {
			configsDTO.add(entityToDto(c));
		}
		return configsDTO;
    }

	@Override
	public ConfigDTO findByName(String name) {
		Optional<Config> c = repository.findByName(name);
		if(c.isPresent()) {
			return entityToDto(c.get());
		}
		else {
			return new ConfigDTO();
		}
	}
}
