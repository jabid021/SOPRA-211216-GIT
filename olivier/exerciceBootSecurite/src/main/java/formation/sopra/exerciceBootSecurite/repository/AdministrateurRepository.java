package formation.sopra.exerciceBootSecurite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.exerciceBootSecurite.model.Administrateur;
import formation.sopra.exerciceBootSecurite.model.Utilisateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
	Optional<Administrateur> findByEmail(String email);
}
