package safariJpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client")
//@SequenceGenerator(name = "seqCompte", sequenceName = "seq_client", allocationSize = 1, initialValue = 500)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "client_id")),
		@AttributeOverride(name = "login", column = @Column(name = "client_login", unique = true, length = 150, nullable = false)),
		@AttributeOverride(name = "password", column = @Column(name = "client_password", length = 150, nullable = false)),
		@AttributeOverride(name = "mail", column = @Column(name = "client_mail", length = 200, nullable = false)) })
public class Client extends Compte {

	@Column(name = "client_telephone")
	private String telephone;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "client_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "client_rue", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "client_code_postal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "client_ville", length = 100)) })
	private Adresse adresse;

	public Client() {

	}

	public Client(String login, String password, String mail) {
		super(login, password, mail);
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
