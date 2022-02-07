package formationJpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formationJpa.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	List<Departement> findByNom(String nom);

	List<Departement> findByNomLike(String nom);

	List<Departement> findByNomStartingWith(String nom);

	List<Departement> findByNomContaining(String nom);

	Optional<Departement> findByIdAndNom(Long id, String nom);

	List<Departement> findByIdOrNom(Long id, String nom);

	@Query("select d from Departement d left join fetch d.employes where d.id=:id")
	Optional<Departement> findByIdWithEmployes(@Param("id") Long id);
	
}
