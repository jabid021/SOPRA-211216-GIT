package formationJpa.dao;

import java.util.List;

import formationJpa.model.Departement;
import formationJpa.model.Employe;

public interface DaoEmploye extends DaoGeneric<Employe, Long> {
	List<Employe> findByNom(String nom);
	List<Employe> findByDepartement(Departement departement);
}
