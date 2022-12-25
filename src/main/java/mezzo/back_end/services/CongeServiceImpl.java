package mezzo.back_end.services;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mezzo.back_end.Repositories.CongeRepository;
import mezzo.back_end.Repositories.UserRepository;
import mezzo.back_end.Request.CongeRequest;
import mezzo.back_end.Response.CongeResponse;
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
	public List<CongeResponse> getAllConge() {
		Type listType = new TypeToken<List<CongeResponse>>() {}.getType();
			
		List<CongeResponse> congeResponse = new ModelMapper().map(cr.findAll(), listType);
		return congeResponse;
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
	public CongeResponse UpdateConge(Long id,CongeRequest c) {
	Conge conge = cr.findById(id).get();
	
	conge.setStatus(c.getStatus());
	
	 cr.save(conge);
	 CongeResponse congeResponse = new CongeResponse();
	 BeanUtils.copyProperties(conge,congeResponse);
		return congeResponse;
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
