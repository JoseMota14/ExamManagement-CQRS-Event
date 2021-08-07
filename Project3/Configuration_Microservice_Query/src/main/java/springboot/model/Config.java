package springboot.model;

import javax.persistence.Column;
import com.google.gson.JsonObject;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Config")
public class Config{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public Type type;

    public Config() {}

    public Config(long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = Type.valueOf(type);
    }
    
    public Config(String name, String type) {
        this.name = name;
        this.type = Type.valueOf(type);
    }
    
    public Config(JsonObject obj){
        this.name = obj.get("descr").getAsString();
        this.type = Type.valueOf(obj.get("type").getAsString().toUpperCase());
    }

	@Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", name='" + name + "type" + type + '\'' +
                '}';
    }
}
