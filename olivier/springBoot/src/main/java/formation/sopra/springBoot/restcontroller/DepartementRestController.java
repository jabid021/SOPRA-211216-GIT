package formation.sopra.springBoot.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.exceptions.DepartementException;
import formation.sopra.springBoot.model.Departement;
import formation.sopra.springBoot.model.Views;
import formation.sopra.springBoot.services.DepartementService;

@RestController
@RequestMapping("/api/departement")
@CrossOrigin(origins = "*")
public class DepartementRestController {

	@Autowired
	private DepartementService departementService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Departement> getAll() {
		List<Departement> list = departementService.getAll();
		System.out.println(list);
		return list;
	}

//	@GetMapping("/get")
//	@JsonView(Views.Common.class)
//	public Departement getById(@RequestParam Long id) {
//		return departementService.getById(id);
//	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Departement getById(@PathVariable Long id) {
		return departementService.getById(id);
	}

	@GetMapping("/{id}/employe")
	@JsonView(Views.DepartementWithEmploye.class)
	public Departement getByIdWithEmploye(@PathVariable Long id) {
		return departementService.getByIdWithEmployes(id);
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Departement create(@Valid @RequestBody Departement departement, BindingResult br) {
		if (br.hasErrors()) {
			throw new DepartementException();
		}
		return departementService.createOrUpdate(departement);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Departement update(@PathVariable Long id, @Valid @RequestBody Departement departement, BindingResult br) {
		if (departement.getId() == null || id != departement.getId() || br.hasErrors()) {
			throw new DepartementException();
		}
		return departementService.createOrUpdate(departement);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		departementService.deleteById(id);
	}

}
