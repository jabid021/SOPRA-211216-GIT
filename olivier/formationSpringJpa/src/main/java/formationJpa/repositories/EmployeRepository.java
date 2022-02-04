package formationJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formationJpa.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long>{
	
}
