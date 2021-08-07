package springboot.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proposal")
public class Proposal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "title")
    public String title;

	@Column(name = "isepUser")
    public String isepUser;
    
    @Column(name = "problem")
    public String problem;
    
    @Column(name = "objective")
    public String objective;
    
    @ElementCollection
    public List<String> keyWords;
    
    @ElementCollection
    public List<String> approaches;
    
    @ElementCollection
    public List<String> techs;
    
    @Column(name = "state")
    public State state;

    public Proposal() {}

    public Proposal(long id, String title,String user, String problem, String objective, List<String> keyWords, List<String> approaches, List<String> techs, String state) {
    	this.id = id;
    	this.title = title;
		this.isepUser = user;
    	this.problem = problem;
    	this.objective = objective;
    	this.keyWords = keyWords;
    	this.approaches = approaches;
    	this.techs = techs;
    	this.state = State.valueOf(state);
    }
    
    public Proposal(String title, String problem, String user, String objective, List<String> keyWords, List<String> approaches, List<String> techs, String state) {
    	this.title = title;
    	this.problem = problem;
		this.isepUser = user;
    	this.objective = objective;
    	this.keyWords = keyWords;
    	this.approaches = approaches;
    	this.techs = techs;
    	this.state = State.valueOf(state);
    }
    
    public Proposal(JsonObject obj){
    	this.title = obj.get("title").getAsString();
    	this.problem = obj.get("problem").getAsString();
    	this.objective = obj.get("objective").getAsString();
		this.isepUser = obj.get("isepUser").getAsString();
		JsonArray a = obj.getAsJsonArray("keyWords");
		this.keyWords = new ArrayList<String>();
		for (JsonElement m : a) {
			this.keyWords.add(m.toString());
		}
		JsonArray b = obj.getAsJsonArray("approaches");
		this.approaches = new ArrayList<String>();
		for (JsonElement m : b) {
			this.approaches.add(m.toString());
		}
		JsonArray c = obj.getAsJsonArray("techs");
		this.techs = new ArrayList<String>();
		for (JsonElement m : c) {
			this.techs.add(m.toString());
		}
    	this.state = State.valueOf(obj.get("state").getAsString().toUpperCase());
    }

	@Override
	public String toString() {
		return super.toString();
	}
}
