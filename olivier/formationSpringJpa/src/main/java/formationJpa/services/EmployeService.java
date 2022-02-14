package formationJpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationJpa.exceptions.EmployeException;
import formationJpa.model.Employe;
import formationJpa.repositories.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepo;

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
		if (employe.getNom() == null || employe.getNom().isEmpty()) {
			throw new EmployeException();
		}
	}
}
