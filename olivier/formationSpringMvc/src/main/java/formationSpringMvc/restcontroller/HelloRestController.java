package formationSpringMvc.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import formationSpringMvc.model.Personne;

@RestController
public class HelloRestController {

	@GetMapping("/api/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/api/olivier")
	public Personne getOlivier() {
		return new Personne("olivier", "gozlan");
	}

	@PostMapping("/api/personne")
	public void sendPersonne(@RequestBody Personne personne) {
		System.out.println(personne.getPrenom());
		System.out.println(personne.getNom());
	}
}
