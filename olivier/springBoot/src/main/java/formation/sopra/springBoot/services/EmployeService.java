package formation.sopra.springBoot.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.exceptions.EmployeException;
import formation.sopra.springBoot.model.Employe;
import formation.sopra.springBoot.repositories.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepo;
	@Autowired
	private Validator validator;

	public List<Employe> getAll() {
		return employeRepo.findAll();
	}

	public Employe getById(Long id) {
		return employeRepo.findById(id).orElseThrow(EmployeException::new);
	}

	public void delete(Employe employe) {
		employeRepo.delete(employe);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public Employe save(Employe employe) {
		check(employe);
		if (employe.getId() == null) {
			return employeRepo.save(employe);
		} else {
			Employe employeEnBase = getById(employe.getId());
			employeEnBase.setNom(employe.getNom());
			employeEnBase.setAdresse(employe.getAdresse());
			employeEnBase.setCivilite(employe.getCivilite());
			employeEnBase.setCommission(employe.getCommission());
			employeEnBase.setDateEmbauche(employe.getDateEmbauche());
			employeEnBase.setPoste(employe.getPoste());
			employeEnBase.setSalaire(employe.getSalaire());
			employeEnBase.setDepartement(employe.getDepartement());
			employeEnBase.setManager(employe.getManager());
			return employeRepo.save(employeEnBase);
		}
	}

	private void check(Employe employe) {
		if (!validator.validate(employe).isEmpty()) {
			throw new EmployeException();
		}
	}

	public Employe getByIdWithSubordonnes(Long id) {
		return employeRepo.findByIdWithSubordonnes(id).orElseThrow(EmployeException::new);
	}

	public boolean exist(Long id) {
		return employeRepo.existsById(id);
	}
}
