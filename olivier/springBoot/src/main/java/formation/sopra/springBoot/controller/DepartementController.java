package formation.sopra.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.springBoot.model.Departement;
import formation.sopra.springBoot.services.DepartementService;

@Controller
@RequestMapping("/departement")
public class DepartementController {

	@Autowired
	private DepartementService departementService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("departements", departementService.getAll());
		return "departement/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		return goEdit(departementService.getById(id), model);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		departementService.deleteById(id);
		return "redirect:/departement";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Departement(), model);
	}

	private String goEdit(Departement departement, Model model) {
		model.addAttribute("departement", departement);
		return "departement/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Departement departement) {
		departementService.createOrUpdate(departement);
		return "redirect:/departement";
	}
}
