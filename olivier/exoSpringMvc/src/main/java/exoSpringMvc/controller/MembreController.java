package exoSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/membre")
public class MembreController {
	@GetMapping("/home")
	public String home() {
		return "membre/home";
	}

	@GetMapping("/page")
	public String page() {
		return "membre/home";
	}
}
