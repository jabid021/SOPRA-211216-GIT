package formation.sopra.exerciceBootSecurite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UtilisateurController {

	@GetMapping("")
	public String home() {
		return "user/home";
	}
}
