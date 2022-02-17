package formation.sopra.exerciceBootSecurite.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("utilisateur")
public class Utilisateur extends Compte {

}
