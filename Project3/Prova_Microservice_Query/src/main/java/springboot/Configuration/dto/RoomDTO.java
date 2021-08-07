package springboot.Configuration.dto;

public class RoomDTO {

    public Long id;
    public String name;

    public RoomDTO() {}

    public RoomDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }
}
