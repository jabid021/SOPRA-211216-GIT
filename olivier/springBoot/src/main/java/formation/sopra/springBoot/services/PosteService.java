package formation.sopra.springBoot.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.exceptions.PosteException;
import formation.sopra.springBoot.model.Poste;
import formation.sopra.springBoot.repositories.EmployeRepository;
import formation.sopra.springBoot.repositories.PosteRepository;

@Service
public class PosteService {

	@Autowired
	PosteRepository posteRepository;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	Validator validator;

	public List<Poste> getAll() {
		return posteRepository.findAll();
	}

	public Poste getByCode(String code) {
		return posteRepository.findById(code).orElseThrow(PosteException::new);
	}

	public Poste save(Poste poste) {
		Poste posteEnBase = null;
		checkData(poste);

		try {
			posteEnBase = getByCode(poste.getCode());
			posteEnBase.setLibelle(poste.getLibelle());
			posteEnBase.setSalaireMax(poste.getSalaireMax());
			posteEnBase.setSalaireMin(poste.getSalaireMin());
			posteEnBase = posteRepository.save(posteEnBase);
		} catch (PosteException e) {
			posteEnBase = posteRepository.save(poste);
		}

		return posteEnBase;

	}

	private void checkData(Poste poste) {
		Set<ConstraintViolation<Poste>> constraints = validator.validate(poste);
		if (!constraints.isEmpty()) {
			System.out.println(constraints);
			throw new PosteException();
		}
	}

	public boolean exist(String code) {
		return posteRepository.existsById(code);
	}

	public void delete(Poste poste) {
		employeRepository.setPosteToNull(poste);
		posteRepository.delete(poste);
	}

	public void delete(String code) {
		delete(getByCode(code));
	}
}
