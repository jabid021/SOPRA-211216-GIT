package formation.sopra.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.springBoot.model.Poste;

public interface PosteRepository extends JpaRepository<Poste, String> {

}
