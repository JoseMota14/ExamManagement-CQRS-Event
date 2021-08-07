package springboot.Proposal.dto;

import java.util.List;

public class PayloadDTO {
	
	public String title;
    public String problem;
    public String objective;
	public String user;
    public List<String> keyWords;
    public List<String> approaches;
    public List<String> techs;
    public String state;
    public String isepUser;

	public PayloadDTO() {
		
	}
	
	public PayloadDTO(String title, String problem,String user, String objective, List<String> keyWords, List<String> approaches, List<String> techs, String state, String isepUser) {
		this.title = title;
    	this.problem = problem;
		this.user = user;
    	this.objective = objective;
    	this.keyWords = keyWords;
    	this.approaches = approaches;
    	this.techs = techs;
    	this.state = state;
    	this.isepUser = isepUser;
	}
}
