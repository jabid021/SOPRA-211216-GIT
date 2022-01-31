package formationJpa.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "emp")
@SequenceGenerator(name = "seqEmploye", sequenceName = "seq_emp", initialValue = 100, allocationSize = 1)
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	@Column(name = "empno")
	private Long id;
	@Column(name = "ename", length = 50, nullable = false)
	private String nom;
	@Column(name = "job", length = 50)
	private String poste;
	@Transient
	private Employe manager;
	@Column(name = "sal")
	private double salaire;
	@Column(name = "comm")
	private double commission;
	@Column(name = "hiredate")
	private LocalDate dateEmbauche;
	@Enumerated(EnumType.STRING)
	@Column(name = "civility", length = 4)
	private Civilite civilite;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "enumber", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "estreet", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "ezipcode", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "ecity", length = 100)) })
	private Adresse adresse;

	public Employe() {

	}

	public Employe(String nom, String poste, double salaire, LocalDate dateEmbauche, Civilite civilite,
			Adresse adresse) {
		super();
		this.nom = nom;
		this.poste = poste;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
		this.civilite = civilite;
		this.adresse = adresse;
	}

	public Employe(String nom, String poste, double salaire, double commission, LocalDate dateEmbauche,
			Civilite civilite, Adresse adresse) {
		super();
		this.nom = nom;
		this.poste = poste;
		this.salaire = salaire;
		this.commission = commission;
		this.dateEmbauche = dateEmbauche;
		this.civilite = civilite;
		this.adresse = adresse;
	}

	public Employe(String nom, String poste, Employe manager, double salaire, double commission, LocalDate dateEmbauche,
			Civilite civilite, Adresse adresse) {
		super();
		this.nom = nom;
		this.poste = poste;
		this.manager = manager;
		this.salaire = salaire;
		this.commission = commission;
		this.dateEmbauche = dateEmbauche;
		this.civilite = civilite;
		this.adresse = adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Employe getManager() {
		return manager;
	}

	public void setManager(Employe manager) {
		this.manager = manager;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		return Objects.equals(id, other.id);
	}

}