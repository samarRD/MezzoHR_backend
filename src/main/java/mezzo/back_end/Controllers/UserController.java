package mezzo.back_end.Controllers;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import mezzo.back_end.Repositories.CongeRepository;
import mezzo.back_end.Response.CongeResponse;
import mezzo.back_end.entities.Conge;
import mezzo.back_end.entities.User;
import mezzo.back_end.services.CongeService;
import mezzo.back_end.services.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private CongeService cs;

	// CRUD ADMIN for user

	@GetMapping
	public List<User> getusers() {
		return us.getAllUsers();
	}

	@PostMapping
	public User createuser(@RequestBody User u) {
		return us.createuser(u);
	}

	@PutMapping
	public User updateuser(@RequestBody User u) {
		return us.UpdateUser(u);
	}

	@DeleteMapping(path = "/{i}")
	public void deleteuser(@PathVariable Long i) {
		us.DeleteUser(i);
	}

	// other methodes

	@GetMapping(path = "/{i}")
	public User finduserbyid(@PathVariable Long i) {
		return us.findUserById(i);
	}

	@GetMapping(path = "/l/{firstname}")
	public List<User> finduserbyfirstname(@PathVariable String firstname) {
		return us.findByFirstname(firstname);
	}

	@GetMapping(path = "/m/{email}/{password}")
	public User finduserbyemailandpassword(@PathVariable String email, @PathVariable String password) {
		return us.findByEmailAndPassword(email, password);
	}

	@GetMapping(path = "/findby")
	public User finduserbyemailandpassword(@RequestBody User u) {
		return us.findByEmailAndPassword(u.getEmail(), u.getPassword());
	}

	// Authantification method

	@PostMapping(path = "/findbyep")
	public User finduser(@RequestBody User u) {

		List<User> l;
		l = getusers();
		User u1 = us.findByEmailAndPassword(u.getEmail(), u.getPassword());

		for (int i = 0; i < l.size(); i++) {

			if (l.get(i) == u1)
				return u1;

		}

		return null;

	}
	
	
	@GetMapping("/{userId}/conges")
	  public List<CongeResponse> getAllCommentsByTutorialId(@PathVariable(value = "userId") Long userId) {

		List<Conge> conge = cs.findByUserId(userId);
		Type listType = new TypeToken<List<CongeResponse>>() {}.getType();

		List<CongeResponse> congeResponse = new ModelMapper().map(conge, listType);
		
		return congeResponse;
	  }

	

}
