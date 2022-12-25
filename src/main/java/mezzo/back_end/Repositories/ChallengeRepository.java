package mezzo.back_end.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mezzo.back_end.entities.Challenge;
import mezzo.back_end.entities.User;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{

}
