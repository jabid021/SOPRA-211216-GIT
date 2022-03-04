package formation.sopra.springBoot.restcontroller;

import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.exceptions.UtilisateurException;
import formation.sopra.springBoot.model.Role;
import formation.sopra.springBoot.model.Utilisateur;
import formation.sopra.springBoot.model.Views;
import formation.sopra.springBoot.repositories.UtilisateurRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	public void auth(@AuthenticationPrincipal Utilisateur user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getRoles());
	}

	@PreAuthorize("isAnonymous()")
	@JsonView(Views.Common.class)
	@PostMapping("/inscription")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	public Utilisateur inscription(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new UtilisateurException();
		}
		if (utilisateurRepo.findByUsername(utilisateur.getUsername()).isPresent()) {
			throw new UtilisateurException();
		}
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateur.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_USER)));
		return utilisateurRepo.save(utilisateur);
	}
	
	@GetMapping("/search/{username}")
	public boolean usernameDejaUtilise(@PathVariable String username) {
		return utilisateurRepo.findByUsername(username).isPresent();
	}
	
	
}
