package safariJpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vendeur")
//@SequenceGenerator(name = "seqCompte", sequenceName = "seq_vendeur", initialValue = 100, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "vendeur_id")),
		@AttributeOverride(name = "login", column = @Column(name = "vendeur_login", unique = true, length = 150, nullable = false)),
		@AttributeOverride(name = "password", column = @Column(name = "vendeur_password", length = 150, nullable = false)),
		@AttributeOverride(name = "mail", column = @Column(name = "vendeur_mail", length = 200, nullable = false)) })
public class Vendeur extends Compte {
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "vendeur_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "vendeur_rue", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "vendeur_code_postal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "vendeur_ville", length = 100)) })
	private Adresse adresse;

	public Vendeur() {

	}

	public Vendeur(String login, String password, String mail) {
		super(login, password, mail);
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
