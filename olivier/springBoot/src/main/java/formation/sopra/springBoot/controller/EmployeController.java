package formation.sopra.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.springBoot.model.Civilite;
import formation.sopra.springBoot.model.Employe;
import formation.sopra.springBoot.services.DepartementService;
import formation.sopra.springBoot.services.EmployeService;
import formation.sopra.springBoot.services.PosteService;

@Controller
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	@Autowired
	private DepartementService departementService;
	@Autowired
	private PosteService posteService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("employes", employeService.getAll());
		return "employe/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		employeService.delete(id);
		return "redirect:/employe";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		return goEdition(employeService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdition(new Employe(), model);
	}

	private String goEdition(Employe employe, Model model) {
		model.addAttribute("postes", posteService.getAll());
		model.addAttribute("employe", employe);
		model.addAttribute("civilites", Civilite.values());
		model.addAttribute("departements", departementService.getAll());
		model.addAttribute("employes", employeService.getAll());
		return "employe/edit";
	}

	@PostMapping("/save")
	private String save(@Valid @ModelAttribute Employe employe, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdition(employe, model);
		}
		if (employe.getManager() != null && employe.getManager().getId() == null) {
			employe.setManager(null);
		}
		employeService.save(employe);
		return "redirect:/employe";
	}
}
