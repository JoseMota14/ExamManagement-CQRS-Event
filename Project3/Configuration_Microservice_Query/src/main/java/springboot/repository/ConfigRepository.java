package springboot.repository;
import springboot.model.*;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.model.Config;

@Repository
public interface ConfigRepository extends CrudRepository<Config, Long> {
	
	//@Query("select c from Config c where c.type like %?1")
	//@Query("select c from Config c where UPPER(c.type) = UPPER(:type)")
	
	default List<Config> findByTypeKeyword() {
        return findByType(Type.KEYWORD);
    }
	default List<Config> findByTypeApproach() {
        return findByType(Type.APPROACH);
    }
	default List<Config> findByTypeTech() {
        return findByType(Type.TECHNOLOGY);
    }
	List<Config> findByType(Type type);
	
	@Query("select c from Config c where c.name like %?1")
	Optional<Config> findByName(String name);
}