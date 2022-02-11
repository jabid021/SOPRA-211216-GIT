package formationSpringMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationJpa.model.Civilite;
import formationJpa.model.Employe;
import formationJpa.services.DepartementService;
import formationJpa.services.EmployeService;

@Controller
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	@Autowired
	private DepartementService departementService;

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
		model.addAttribute("employe", employe);
		model.addAttribute("civilites", Civilite.values());
		model.addAttribute("departements", departementService.getAll());
		model.addAttribute("employes", employeService.getAll());
		return "employe/edit";
	}

	@GetMapping("/save")
	private String save(@ModelAttribute Employe employe) {
		if(employe.getManager()!=null&&employe.getManager().getId()==null) {
			employe.setManager(null);
		}
		employeService.save(employe);
		return "redirect:/employe";
	}
}
