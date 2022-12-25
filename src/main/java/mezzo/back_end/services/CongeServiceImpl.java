package mezzo.back_end.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mezzo.back_end.Repositories.CongeRepository;
import mezzo.back_end.Repositories.UserRepository;
import mezzo.back_end.entities.Conge;
import mezzo.back_end.entities.User;

@Service
public class CongeServiceImpl implements CongeService {

	@Autowired
	private CongeRepository cr;
	@Autowired
	private UserRepository ur;
	@Override
	public Conge createConge(Conge c) {
		return cr.save(c);
	}

	@Override
	public List<Conge> getAllConge() {
		return cr.findAll();
	}

	@Override
	public Conge findCongeById(Long id) {
		Optional<Conge> opt = cr.findById(id);
		
		if(opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Conge UpdateConge(Conge c) {
	Optional<Conge> opt = cr.findById(c.getId());
		
		if(opt.isEmpty())
			return null;
		else
			return cr.save(c);
	}

	@Override
	public void DeleteConge(Long id) {
		cr.deleteById(id);
	}
	
	
	
	@Override
	public List<Conge> findByUserId(Long id) {
		User user = ur.findById(id).get();
		return cr.findByUser(user);
		
	}


}
