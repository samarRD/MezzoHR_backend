package mezzo.back_end.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mezzo.back_end.Repositories.ChallengeRepository;
import mezzo.back_end.Repositories.CongeRepository;
import mezzo.back_end.Repositories.UserRepository;
import mezzo.back_end.entities.Challenge;
import mezzo.back_end.entities.Conge;
import mezzo.back_end.entities.User;

@Service
public class ChallengeServiceImpl implements ChallengeService{
	@Autowired
	private ChallengeRepository cr;
	@Autowired
	private UserRepository ur;
	
	@Override
	public Challenge createChallenge(Challenge c) {
		return cr.save(c);
	}

	@Override
	public List<Challenge> getAllChallenge() {
		return cr.findAll();
	}

	

	@Override
	public Challenge UpdateChallenge(Challenge c) {
	Optional<Challenge> opt = cr.findById(c.getId());
		
		if(opt.isEmpty())
			return null;
		else
			return cr.save(c);
	}
	
	
	@Override
	public Challenge UpdateUserChallenge(Challenge c,Long id) {
	User user = ur.findById(id).get();
	Challenge challange = cr.findById(c.getId()).get();
	List<User> list = challange.getUsers();
	list.add(user);
	challange.setUsers(list);
	return cr.save(challange);
	}

	@Override
	public void DeleteChallenge(Long id) {
		cr.deleteById(id);
	}

	@Override
	public Challenge findChallengeById(Long id) {
          Optional<Challenge> opt = cr.findById(id);
		
		if(opt.isEmpty())
			return null;
		else
			return opt.get();
	}

}
