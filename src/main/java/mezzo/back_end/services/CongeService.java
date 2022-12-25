package mezzo.back_end.services;

import java.util.List;

import mezzo.back_end.entities.Conge;

public interface CongeService {

	public Conge createConge(Conge c);
	public List<Conge> getAllConge();
	public List<Conge> findByUserId(Long id);
	public Conge findCongeById(Long id);
	public Conge UpdateConge(Conge c);
	public void DeleteConge(Long c);
}
