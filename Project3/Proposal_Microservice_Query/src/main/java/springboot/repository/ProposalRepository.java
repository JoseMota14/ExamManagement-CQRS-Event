package springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.model.Proposal;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {
	
	//@Query("select c from Config c where c.type like %?1")
	//List<Config> findByType(String type);
}