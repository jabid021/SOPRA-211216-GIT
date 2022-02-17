package formation.sopra.exerciceBootSecurite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.exerciceBootSecurite.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

	Optional<Compte> findByEmail(String email);
}
