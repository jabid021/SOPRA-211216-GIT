package formation.sopra.exerciceBootSecurite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.exerciceBootSecurite.model.CustomUserDetails;
import formation.sopra.exerciceBootSecurite.model.Utilisateur;
import formation.sopra.exerciceBootSecurite.repository.AdministrateurRepository;
import formation.sopra.exerciceBootSecurite.repository.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	// @Autowired
	// private CompteRepository compteRepo;

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private AdministrateurRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new CustomUserDetails(compteRepo.findByEmail(username).orElseThrow(() -> {
//			throw new UsernameNotFoundException("email inconnu");
//		}));

		Optional<Utilisateur> opt = utilisateurRepo.findByEmail(username);
		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		} else {
			return new CustomUserDetails(adminRepo.findByEmail(username).orElseThrow(() -> {
				throw new UsernameNotFoundException("not found");
			}));
		}
	}

}
