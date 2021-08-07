package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import springboot.Proposal.dto.*;
import springboot.model.Proposal;
import springboot.rabbit.Sender;
import springboot.repository.ProposalRepository;
import springboot.service.ProposalQueryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProposalQueryServiceImpl implements ProposalQueryService{

	@Autowired
    private ProposalRepository repository;

	@Autowired
	private Sender sender;
	
	public ProposalDTO entityToDto(Proposal e) {
		return new ProposalDTO(e.title, e.problem, e.isepUser, e.objective, e.keyWords, e.approaches, e.techs, e.state.toString());
	}
	
	public List<ProposalDTO> findAll(){
		Iterable<Proposal> configs = repository.findAll();
		List<ProposalDTO> configsDTO = new ArrayList<>();
		for (Proposal c : configs) {
			configsDTO.add(entityToDto(c));
		}
		return configsDTO;
	}

	@Override
	public ProposalDTO findById(long id) {
		Optional<Proposal> c = repository.findById(id);
		if(c.isPresent()) {
			return entityToDto(c.get());
		}
		else {
			return new ProposalDTO();
		}
	}
	
	@Override
    public void insertFromQueue(String message){
		try{
			JsonObject obj = new Gson().fromJson(message, JsonObject.class);
			repository.save(new Proposal(obj));
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
}
