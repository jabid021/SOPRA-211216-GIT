package exoSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exoSpringMvc.model.Personne;

@Controller
public class HomeController {
	@RequestMapping({ "", "/home" })
	public String home() {
		return "home";
	}

	@RequestMapping(path = "/page1", method = RequestMethod.GET)
	public String page1(@RequestParam(value = "prenom", required = false, defaultValue = "world") String param,
			@RequestParam Integer n, Model model) {
		System.out.println(n);
		System.out.println(param);
		model.addAttribute("prenom", param);
		return "page1";
	}

	@GetMapping("/bonjour")
	public String bonjour() {
		return "bonjour";
	}

	@PostMapping("/bonjour")
	public String afficherInfo(@ModelAttribute Personne personne, Model model) {
		if (personne.getNom().isEmpty() || personne.getPrenom().isEmpty()) {
			model.addAttribute("error", true);
			model.addAttribute("personne", personne);
			return "bonjour";
		}
		model.addAttribute("personne", personne);
		return "page1";
	}

}
