package formationJpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formationJpa.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	List<Departement> findByNom(String nom);

	List<Departement> findByNomLike(String nom);

	List<Departement> findByNomStartingWith(String nom);

	List<Departement> findByNomContaining(String nom);

	Optional<Departement> findByIdAndNom(Long id, String nom);

	List<Departement> findByIdOrNom(Long id, String nom);
}
