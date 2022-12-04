package mezzo.back_end.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mezzo.back_end.entities.User;
import mezzo.back_end.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository utilisateurRepository;

	@Override
	public List<User> getAllUtilisateur() {
		return utilisateurRepository.findAll();
	}

	@Override
	public User createUtilisateur(User utilisateur) {
		return utilisateurRepository.save(utilisateur);

	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);

	}
	@Override
	public User updateUtilisateur(User utilisateur) {
		
		Optional<User> utOptional = utilisateurRepository.findById(utilisateur.getId());
		if (utOptional.isEmpty())
		{
			return null;
		}
		else {
			return utilisateurRepository.save(utilisateur);
		}
		
	}

}

