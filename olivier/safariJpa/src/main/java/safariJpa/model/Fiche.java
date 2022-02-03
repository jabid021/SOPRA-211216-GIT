package safariJpa.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import safariJpa.model.singleTable.Animal;

@Entity
@Table(name = "fiche")
@SequenceGenerator(name = "seqFiche", sequenceName = "seq_fiche", initialValue = 100, allocationSize = 1)
public class Fiche {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFiche")
	@Column(name = "fiche_id")
	private Long id;
	@Column(name = "fiche_description", columnDefinition = "TEXT")
	// @Column(name="fiche_description")
	// @Lob
	private String description;
	@Column(name = "fiche_dt_creation")
	private LocalDate creation;
	@Column(name = "fiche_nom", length = 200, nullable = false)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "fiche_sexe", length = 8)
	private Sexe sexe;
	@Column(name = "fiche_age")
	private int age;
	@Column(name = "fiche_puce", length = 15)
	private String puce;
	@Column(name = "fiche_poids")
	private double poids;
	@Column(name = "fiche_couleur", length = 100)
	private String couleur;
	@Column(name = "fiche_sociable")
	private boolean sociable;
	@OneToOne
	@JoinColumn(name = "fiche_animal_id", foreignKey = @ForeignKey(name = "fiche_animal_id_fk"),nullable = false)
	private Animal animal;
	@ManyToOne
	@JoinColumn(name = "fiche_vendeur_id", foreignKey = @ForeignKey(name = "fiche_vendeur_id_fk"),nullable = false)
	private Vendeur vendeur;
//	@OneToMany(mappedBy = "fiche")
//	private List<Match> matchs;
//	@ManyToMany
//	@JoinTable(name="match",joinColumns = @JoinColumn(name="match_fiche_id",foreignKey = @ForeignKey(name="match_fiche_id_fk")),
//	inverseJoinColumns = @JoinColumn(name="match_client_id",foreignKey = @ForeignKey(name="match_client_id_fk")))
//	private Set<Client> clientsQuiOntMatchesLaFiche;
	@OneToMany(mappedBy = "id.fiche")
	private List<Match> matchs;

	public Fiche() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreation() {
		return creation;
	}

	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPuce() {
		return puce;
	}

	public void setPuce(String puce) {
		this.puce = puce;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public boolean isSociable() {
		return sociable;
	}

	public void setSociable(boolean sociable) {
		this.sociable = sociable;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

//	public Set<Client> getClientsQuiOntMatchesLaFiche() {
//		return clientsQuiOntMatchesLaFiche;
//	}
//
//	public void setClientsQuiOntMatchesLaFiche(Set<Client> clientsQuiOntMatchesLaFiche) {
//		this.clientsQuiOntMatchesLaFiche = clientsQuiOntMatchesLaFiche;
//	}

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
		Fiche other = (Fiche) obj;
		return Objects.equals(id, other.id);
	}

}
