package springboot.Configuration.dto;

import java.util.Date;

public class ReservationDTO {

    public Long id;
    public Long room;
    public Date date;
    public Long proposalId;
    public Long studentId;
    public Long arguenteId;
    public int score;

    public ReservationDTO() {}

    public ReservationDTO(Long room, Date date, Long id, Long proposalId, Long studentId, Long arguenteId, int score) {
        this.room = room;
        this.id = id;
        this.date = date;
        this.proposalId = proposalId;
        this.studentId = studentId;
        this.arguenteId = arguenteId;
        this.score = score;
    }
}
