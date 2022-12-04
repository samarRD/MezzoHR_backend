package mezzo.back_end.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;


import mezzo.back_end.entities.User;



public interface UserService {
	public User createUtilisateur(User utilisateur);

	public List<User> getAllUtilisateur();

	public void deleteUtilisateur(Long id);
	
	public User updateUtilisateur(@RequestBody User utilisateur);
	

}