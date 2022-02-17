package formation.sopra.exerciceBootSecurite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.exerciceBootSecurite.model.CustomUserDetails;
import formation.sopra.exerciceBootSecurite.repository.CompteRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new CustomUserDetails(compteRepo.findByEmail(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("email inconnu");
		}));

	}

}
