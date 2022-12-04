package mezzo.back_end.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mezzo.back_end.entities.User;



public interface UserRepository extends JpaRepository<User,Long>{


}
