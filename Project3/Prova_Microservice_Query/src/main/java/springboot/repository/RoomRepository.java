package springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
