package springboot.Configuration.dto;

public class ReservationDTO {

    public String room;
    public String date;
    public String proposal;
    public String student;
    public String arguente;

    public ReservationDTO() {

    }

    public ReservationDTO(String room, String date, String proposal) {
        this.room = room;
        this.date = date;
        this.proposal = proposal;
    }

}
