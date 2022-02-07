package formationJpa.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationJpa.model.Departement;
import formationJpa.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	Optional<Employe> findByIdWithSubordonnes(Long id);

	@Transactional
	@Modifying
	@Query("update Employe e set e.departement=null where e.departement=:departement")
	void setDepartementToNull(@Param("departement") Departement departement);

	@Transactional
	@Modifying
	@Query("delete from Employe e where e.departement=:departement")
	void deleteByDepartement(@Param("departement") Departement departement);
}
