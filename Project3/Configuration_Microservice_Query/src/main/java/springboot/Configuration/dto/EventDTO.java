package springboot.Configuration.dto;

import java.util.Date;

public class EventDTO {
	
	public String description;

    public String receivedJson;

    public Date createdAt;
    
    public EventDTO(String description, String receivedJson, Date date) {
        this.description = description;
        this.receivedJson = receivedJson;
        this.createdAt = date;
    }
}
