package mezzo.back_end.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mezzo.back_end.Repositories.UserRepository;
import mezzo.back_end.entities.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;
	
	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> opt = ur.findById(id);
		
		if(opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public User createuser(User u) {
		return ur.save(u);
	}

	@Override
	public User UpdateUser(User u) {
		Optional<User> opt = ur.findById(u.getId());
		
		if(opt.isEmpty())
			return null;
		else
			return ur.save(u);
	}

	@Override
	public void DeleteUser(Long i) {
		ur.deleteById(i);
	}

	@Override
	public List<User> findByFirstname(String firstname) {
		return ur.findByFirstname(firstname);
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}
	
	

}
