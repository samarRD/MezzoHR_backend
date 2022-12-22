package mezzo.back_end.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mezzo.back_end.Repositories.CongeRepository;
import mezzo.back_end.entities.Conge;

@Service
public class CongeServiceImpl implements CongeService {

	@Autowired
	private CongeRepository cr;
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

}
