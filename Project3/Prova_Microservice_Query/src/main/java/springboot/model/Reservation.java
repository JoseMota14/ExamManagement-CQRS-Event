package springboot.model;

import com.google.gson.JsonObject;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    public Long proposalId;

    public Long roomId;

    public Long studentId;

    public Long arguenteId;

    public int score;

    public Date date;

    public Reservation() {}

    public Reservation(Long id, Long proposalId, Date date, Long studentId, Long arguenteId) {
        this.roomId = id;
        this.proposalId = proposalId;
        this.date = date;
        this.studentId = studentId;
        this.arguenteId = arguenteId;
        this.score = -1;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
