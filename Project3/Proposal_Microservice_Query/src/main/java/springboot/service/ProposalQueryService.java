package springboot.service;

import java.util.List;

import springboot.Proposal.dto.ProposalDTO;

public interface ProposalQueryService {
	
    List<ProposalDTO> findAll();
    ProposalDTO findById(long id);
    void insertFromQueue(String message);
    void deleteFromQueue(String message);
    
}
