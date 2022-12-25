package mezzo.back_end.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mezzo.back_end.entities.Conge;
import mezzo.back_end.entities.User;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long>{
	  List<Conge> findByUser(User user);
}
