package formationJpa.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	@Column(name = "num", length = 50)
	@JsonView(Views.Common.class)
	// pas vide
	// des chiffres
	// numero bis ter ou 1 lettre
	@NotEmpty
	private String numero;
	// pas vide
	@NotEmpty
	@JsonView(Views.Common.class)
	private String rue;
	// pas vide
	@NotEmpty
	@JsonView(Views.Common.class)
	private String codePostal;
	// pas vide
	@NotEmpty
	@JsonView(Views.Common.class)
	private String ville;

	public Adresse() {

	}

	public Adresse(String numero, String rue, String codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codePostal, numero, rue, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(codePostal, other.codePostal) && Objects.equals(numero, other.numero)
				&& Objects.equals(rue, other.rue) && Objects.equals(ville, other.ville);
	}

}
