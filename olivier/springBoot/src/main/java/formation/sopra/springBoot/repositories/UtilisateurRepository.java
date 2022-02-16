package formation.sopra.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.springBoot.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByUsername(String username);

	@Query("select u from Utilisateur u left join fetch u.roles where u.username=:username")
	Optional<Utilisateur> findByUsernameWithRoles(@Param("username") String username);
}
