package formation.sopra.springBoot.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.sopra.springBoot.model.Utilisateur;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

	@GetMapping("")
	public void auth(@AuthenticationPrincipal Utilisateur user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getRoles());
	}
}
