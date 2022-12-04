package mezzo.back_end.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mezzo.back_end.entities.User;
import mezzo.back_end.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService utilisateurService;

	@GetMapping(path = "/getUsers")
	public List<User> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateur();
	}

	@PostMapping(path = "/register")
	public User createUtilisateur(@RequestBody User utilisateur) {
		return utilisateurService.createUtilisateur(utilisateur);
	}

	@DeleteMapping(path = "/{id}")
	public void deletUtilisateur(@PathVariable Long id) {
		utilisateurService.deleteUtilisateur(id);
	}

	@PutMapping(path = "/update")
	public User updateUtilisateur(@RequestBody User utilisateur) {
		return utilisateurService.updateUtilisateur(utilisateur);
	}

}
