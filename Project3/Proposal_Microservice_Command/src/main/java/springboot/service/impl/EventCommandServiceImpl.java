package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.Proposal.dto.PayloadDTO;
import springboot.model.*;
import springboot.rabbit.Sender;
import springboot.repository.EventRepository;
import springboot.service.EventCommandService;
import com.google.gson.Gson;

@Service
public class EventCommandServiceImpl implements EventCommandService{

	@Autowired
    private EventRepository repository;
	
	@Autowired
    private Sender sender;
	
	@Override
    public Event insert(PayloadDTO p) {
		String json = new Gson().toJson(p);
		sender.send(json);
        return repository.save(new Event("Create proposal", json));
    }

    @Override
    public boolean delete(long id) {
        try {
            String json = new Gson().toJson(id);
            sender.sendDelete(json);
            repository.save(new Event("Delete proposal by id", json));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Event p) {
        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
