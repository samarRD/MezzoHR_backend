package mezzo.back_end.services;

import java.util.List;


import mezzo.back_end.Request.CongeRequest;
import mezzo.back_end.Response.CongeResponse;
import mezzo.back_end.entities.Conge;

public interface CongeService {

	public Conge createConge(Conge c);
	public List<CongeResponse> getAllConge();
	public List<Conge> findByUserId(Long id);
	public Conge findCongeById(Long id);
	public CongeResponse UpdateConge(Long id,CongeRequest c);
	public void DeleteConge(Long c);
}
