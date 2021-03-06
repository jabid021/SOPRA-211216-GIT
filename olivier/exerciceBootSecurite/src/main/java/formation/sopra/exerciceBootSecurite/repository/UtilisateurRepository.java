package formation.sopra.exerciceBootSecurite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.exerciceBootSecurite.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByEmail(String email);
}
