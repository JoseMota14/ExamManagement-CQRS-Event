package springboot.model;

import javax.persistence.Column;
import com.google.gson.JsonObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    public Room() {}

    public Room(String name) {
        this.name = name;
    }

    public Room(JsonObject obj){
        this.name = obj.get("name").getAsString();
    }
}

