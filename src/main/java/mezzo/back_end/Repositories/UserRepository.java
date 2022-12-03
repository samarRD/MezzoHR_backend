package mezzo.back_end.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mezzo.back_end.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByFirstname(String firstname);
	public User findByEmailAndPassword(String email,String password);

}
