package springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String description;

    public String receivedJson;

    public Date createdAt;

    public Event() {}

    public Event(String description, String receivedJson) {
        this.description = description;
        this.receivedJson = receivedJson;
        this.createdAt = new Date();
    }
    
}
