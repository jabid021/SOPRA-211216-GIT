package formationJpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationJpa.exceptions.DepartementException;
import formationJpa.model.Departement;
import formationJpa.repositories.DepartementRepository;
import formationJpa.repositories.EmployeRepository;

@Service
public class DepartementService {

	@Autowired
	private DepartementRepository departementRepo;
	@Autowired
	private EmployeRepository employeRepo;

	public List<Departement> getAll() {
		return departementRepo.findAll();
	}

	public Departement getById(Long id) {
		return departementRepo.findById(id).orElseThrow(() -> {
			throw new DepartementException("department inconnu");
		});
//		return departementRepo.findById(id).orElseThrow(DepartementException::new);
	}

	public Departement getByIdWithEmployes(Long id) {
		return departementRepo.findByIdWithEmployes(id).orElseThrow(DepartementException::new);
	}

	public Departement createOrUpdate(Departement d) {
		if (d == null) {
			throw new DepartementException();
		}
		Departement departementEnBase = null;
		if (d.getId() == null) {
			// create
			// controle des donnees
			checkData(d);
			return departementRepo.save(d);
		} else {
			// update (gestion de la version)
			departementEnBase = this.getById(d.getId());
			checkData(d);
			departementEnBase.setNom(d.getNom());
			return departementRepo.save(departementEnBase);
		}
	}

	private void checkData(Departement d) {
		if (d.getNom() == null || d.getNom().isEmpty()) {
			throw new DepartementException("données incorrectes");
		}
	}

	public void delete(Departement d) {
		if (d == null || d.getId() == null) {
			throw new DepartementException();
		}
		Departement departementEnBase = departementRepo.findById(d.getId()).orElseThrow(DepartementException::new);
		employeRepo.setDepartementToNull(departementEnBase);
		departementRepo.delete(departementEnBase);
	}

}
