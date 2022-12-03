package mezzo.back_end.services;

import java.util.List;

import mezzo.back_end.entities.User;

public interface UserService {

	public User createuser(User u);
	public List<User> getAllUsers();
	public User findUserById(Long id);
	public User UpdateUser(User u);
	public void DeleteUser(Long u);
	
	public List<User> findByFirstname(String firstname);
	public User findByEmailAndPassword(String email,String password);
}
