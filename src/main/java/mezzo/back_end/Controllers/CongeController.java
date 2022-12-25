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

import mezzo.back_end.Request.CongeRequest;
import mezzo.back_end.Response.CongeResponse;
import mezzo.back_end.entities.Challenge;
import mezzo.back_end.entities.Conge;
import mezzo.back_end.services.CongeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Conge")
public class CongeController {

	
	@Autowired
	private CongeService cr;

	@GetMapping
	public List<CongeResponse> getConge() {
		return cr.getAllConge();
	}

	@PostMapping
	public Conge createConge(@RequestBody Conge c) {
		return cr.createConge(c);
	}
	
	@PutMapping(path = "/{id}")
	public CongeResponse updateConge(@PathVariable Long id ,@RequestBody CongeRequest c) {
		return cr.UpdateConge(id,c);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteConge(@PathVariable Long id) {
		cr.DeleteConge(id);
	}

	

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

