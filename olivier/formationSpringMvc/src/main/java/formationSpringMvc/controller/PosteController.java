package formationSpringMvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationJpa.exceptions.PosteException;
import formationJpa.model.Poste;
import formationJpa.services.PosteService;

@Controller
@RequestMapping("/poste")
public class PosteController {
	@Autowired
	private PosteService posteService;

	@GetMapping("")
	public String getAll(Model model) {
		model.addAttribute("postes", posteService.getAll());
		return "poste/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam String code, Model model) {
		return goEdit(posteService.getByCode(code), model);
	}

	private String goEdit(Poste poste, Model model) {
		model.addAttribute("poste", poste);
		return "poste/edit";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Poste(), model);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam String code) {
		posteService.delete(code);
		return "redirect:/poste";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Poste poste, Model model) {
		//controle
		posteService.save(poste);
		return "redirect:/poste";
	}
}
