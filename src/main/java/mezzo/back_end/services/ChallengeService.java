package mezzo.back_end.services;

import java.util.List;

import mezzo.back_end.entities.Challenge;
import mezzo.back_end.entities.Conge;
import mezzo.back_end.entities.User;

public interface ChallengeService {
	
	public Challenge createChallenge(Challenge c);
	public List<Challenge> getAllChallenge();
	public Challenge UpdateChallenge(Challenge c);
	public void DeleteChallenge(Long id);
	public Challenge findChallengeById(Long id);
	public Challenge UpdateUserChallenge(Challenge c,Long id);
	public  List<Challenge> GetUserChallenges(Long id);

}
