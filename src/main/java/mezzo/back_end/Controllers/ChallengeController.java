package mezzo.back_end.Controllers;

import java.util.List;

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


import mezzo.back_end.Repositories.ChallengeRepository;
import mezzo.back_end.entities.Challenge;
import mezzo.back_end.entities.Conge;
import mezzo.back_end.entities.User;
import mezzo.back_end.services.ChallengeService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/challenge")
public class ChallengeController {
	
	@Autowired
	ChallengeService cs;
	@GetMapping
	public List<Challenge> getChallenges() {
		return cs.getAllChallenge();
	}

	@PostMapping
	public Challenge createConge(@RequestBody Challenge c) {
		return cs.createChallenge(c);
	}

	@PutMapping
	public Challenge updateChallenge(@RequestBody Challenge c) {
		return cs.UpdateChallenge(c);
	}
	
	@PutMapping(path = "/{id}")
	public Challenge updateUserChallenge(@PathVariable Long id,@RequestBody Challenge c) {
		return cs.UpdateUserChallenge(c,id);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteChallenge(@PathVariable Long id) {
		cs.DeleteChallenge(id);
	}
	
	@GetMapping(path = "/{id}")
	public Challenge findchallengebyid(@PathVariable Long id) {
		return cs.findChallengeById(id);
	}
	@GetMapping(path = "/getchallenges/{id}")
	public List<Challenge> GetUserChallenges(@PathVariable Long id) {
		return cs.GetUserChallenges(id);
	}
	
	
}
