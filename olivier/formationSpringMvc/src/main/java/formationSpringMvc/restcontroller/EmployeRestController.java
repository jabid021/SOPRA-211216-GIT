package formationSpringMvc.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formationJpa.exceptions.EmployeException;
import formationJpa.model.Employe;
import formationJpa.model.Views;
import formationJpa.services.EmployeService;
import formationSpringMvc.dto.EmployeDto;

@RestController
@RequestMapping("/api/employe")
public class EmployeRestController {
	@Autowired
	private EmployeService employeService;

	@GetMapping("")
	@JsonView(Views.EmployeWithDepartement.class)
	public List<Employe> getAll() {
		return employeService.getAll();
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	public Employe create(@Valid @RequestBody Employe employe, BindingResult br) {
		if (br.hasErrors()) {
			throw new EmployeException();
		}
		return employeService.save(employe);
	}

	@GetMapping("/{id}")
	// @JsonView(Views.EmployeWithDepartement.class)
	public EmployeDto getById(@PathVariable Long id) {
		Employe e = employeService.getById(id);
		return employeEntityToeEmployeDTO(e);
	}

	@GetMapping("/{id}/sub")
	public List<Long> getSubIdById(@PathVariable Long id) {
		return employeService.getByIdWithSubordonnes(id).getSubordonnes().stream().map(e -> e.getId())
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}/subordonnes")
	// @JsonView(Views.EmployeWithSubordonnes.class)
	public EmployeDto getByIdWithSubordonnes(@PathVariable Long id) {
		Employe e = employeService.getByIdWithSubordonnes(id);
		EmployeDto edto = employeEntityToeEmployeDTO(e);
//		List<EmployeDto> sub = new ArrayList<EmployeDto>();
//		e.getSubordonnes().forEach(subordonne -> {
//			sub.add(employeEntityToeEmployeDTO(subordonne));
//		});

		// edto.setSubordonnes(sub);
		edto.setSubordonnes(
				e.getSubordonnes().stream().map(emp -> employeEntityToeEmployeDTO(emp)).collect(Collectors.toList()));

		return edto;
	}

	private EmployeDto employeEntityToeEmployeDTO(Employe e) {
		EmployeDto edto = new EmployeDto();
		edto.setId(e.getId());
		edto.setNom(e.getNom());
		if (e.getManager() != null) {
			EmployeDto mgr = new EmployeDto();
			mgr.setId(e.getManager().getId());
			mgr.setNom(e.getManager().getNom());
			edto.setManager(mgr);
		}
		return edto;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		employeService.delete(id);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Employe update(@Valid @RequestBody Employe employe, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new EmployeException();
		}
		if (!employeService.exist(id)) {
			throw new EmployeException();
		}
		return employeService.save(employe);
	}
}
