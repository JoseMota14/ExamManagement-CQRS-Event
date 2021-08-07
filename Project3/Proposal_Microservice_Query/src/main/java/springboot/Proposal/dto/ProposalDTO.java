package springboot.Proposal.dto;

import java.util.List;
import java.util.Collection;
import javax.persistence.Column;

public class ProposalDTO {
	
	public String title;
    public String problem;
    public String objective;
	public String user;
    public Collection<String> keyWords;
    public Collection<String> approaches;
    public Collection<String> techs;
    public String state;

	public ProposalDTO() {
		
	}
	
	public ProposalDTO(String title, String problem,String user, String objective, Collection<String> keyWords, Collection<String> approaches, Collection<String> techs, String state) {
		this.title = title;
    	this.problem = problem;
		this.user = user;
    	this.objective = objective;
    	this.keyWords = keyWords;
    	this.approaches = approaches;
    	this.techs = techs;
    	this.state = state;
	}
}
