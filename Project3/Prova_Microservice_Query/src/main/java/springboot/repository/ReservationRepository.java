package springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
