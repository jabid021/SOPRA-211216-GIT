package formationJpa.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "emp")
@SequenceGenerator(name = "seqEmploye", sequenceName = "seq_emp", initialValue = 100, allocationSize = 1)
@NamedQueries({ @NamedQuery(query = "select e from Employe e", name = "Employe.findAll"),
		@NamedQuery(query = "select e from Employe e where e.nom=:nom", name = "Employe.findByNom"),
		@NamedQuery(query = "select e from Employe e where e.nom=:nom and e.poste=:poste", name = "Employe.findByNomAndPoste"),
		@NamedQuery(query = "select e from Employe e left join fetch e.subordonnes where e.id=:id", name = "Employe.findByIdWithSubordonnes") })
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	@Column(name = "empno")
	private Long id;
	@Column(name = "ename", length = 50, nullable = false)
	private String nom;
	@ManyToOne
	@JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "emp_job_id_fk"))
	private Poste poste;
	@ManyToOne
	@JoinColumn(name = "mgr", foreignKey = @ForeignKey(name = "emp_mgr_fk"))
	private Employe manager;
	@Column(name = "sal")
	private double salaire;
	@Column(name = "comm")
	private double commission;
	@Column(name = "hiredate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	// relation physique
	// ManyToOne
	// OneToOne
	@ManyToOne
	@JoinColumn(name = "deptno", foreignKey = @ForeignKey(name = "emp_edeptno_fk"))
	private Departement departement;
	@OneToMany(mappedBy = "manager")
	private List<Employe> subordonnes;
	@Version
	private int version;

	public Employe() {

	}

	public Employe(String nom, Poste poste, double salaire, LocalDate dateEmbauche, Civilite civilite,
			Adresse adresse) {
		super();
		this.nom = nom;
		this.poste = poste;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
		this.civilite = civilite;
		this.adresse = adresse;
	}

	public Employe(String nom, Poste poste, double salaire, double commission, LocalDate dateEmbauche,
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

	public Employe(String nom, Poste poste, Employe manager, double salaire, double commission, LocalDate dateEmbauche,
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

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Employe> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<Employe> subordonnes) {
		this.subordonnes = subordonnes;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public String getInfos() {
		return id + " " + nom + " " + poste;
	}
}
