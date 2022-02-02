package formationJpa.dao;

import java.util.List;

import formationJpa.model.Departement;

public interface DaoDepartement extends DaoGeneric<Departement, Long> {
	Departement findByIdWithEmploye(Long id);

	List<Departement> findAllWithEmploye();

	List<Departement> findDepartementAvecLesEmployesQuiGangentPlusDeXEuros(double salaire);
	
	List<Departement> findDepartementOuUnEmployeGagnePlusQueSonManager();

}
