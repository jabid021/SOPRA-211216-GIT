package formation.sopra.springBoot.services;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.model.Role;
import formation.sopra.springBoot.model.Utilisateur;
import formation.sopra.springBoot.repositories.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);

	@Override
	public void run(String... args) throws Exception {
	//	initDataBase();
	}

	private void initDataBase() {
		Utilisateur olivier = new Utilisateur();
		olivier.setUsername("toto");
		olivier.setPassword(passwordEncoder.encode("toto"));
		olivier.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_EMPLOYE,Role.ROLE_DEPT)));
		utilisateurRepo.save(olivier);

	}

}
