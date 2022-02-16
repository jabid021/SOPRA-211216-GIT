package formation.sopra.springBoot.restcontroller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.exceptions.PosteException;
import formation.sopra.springBoot.model.Poste;
import formation.sopra.springBoot.model.Views;
import formation.sopra.springBoot.services.PosteService;

@RestController
@RequestMapping("/api/poste")
public class PosteRestController {
	@Autowired
	private PosteService posteService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Poste> getAll() {
		return posteService.getAll();
	}

	@GetMapping("/{code}")
	@JsonView(Views.Common.class)
	public Poste getById(@PathVariable String code) {
		return posteService.getByCode(code);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Poste create(@Valid @RequestBody Poste poste, BindingResult br) {
		return save(poste, br);
	}

	@PutMapping("/{code}")
	@JsonView(Views.Common.class)
	public Poste update(@Valid @RequestBody Poste poste, BindingResult br, @PathVariable String code) {
		if (!posteService.exist(code)) {
			throw new PosteException();
		}
		return save(poste, br);
	}

	private Poste save(Poste poste, BindingResult br) {
		if (br.hasErrors()) {
			throw new PosteException();
		}
		return posteService.save(poste);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{code}")
	public void delete(@PathVariable String code) {
		posteService.delete(code);
	}

}
