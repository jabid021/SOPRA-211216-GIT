package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fiche {

	private Integer id;
	private String description;
	private LocalDate creation;
	private String nom;
	private String sexe;
	private int age;
	private int puce;
	private double poids;
	private String couleur;
	private boolean sociable;
	private Animal animal;
	private Vendeur vendeur;
	private List<Match> matchs=new ArrayList();
	
	
	public Fiche(Integer id,String description, LocalDate creation, String nom, String sexe, int age, int puce, double poids,
			String couleur, boolean sociable, Animal animal,Vendeur vendeur) {
		this.id=id;
		this.description = description;
		this.creation = creation;
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
		this.puce = puce;
		this.poids = poids;
		this.couleur = couleur;
		this.sociable = sociable;
		this.animal = animal;
		this.vendeur=vendeur;
	}


	public String getDescription() {
		return description;
	}


	public LocalDate getCreation() {
		return creation;
	}


	public String getNom() {
		return nom;
	}


	public String getSexe() {
		return sexe;
	}


	public int getAge() {
		return age;
	}


	public int getPuce() {
		return puce;
	}


	public double getPoids() {
		return poids;
	}


	public String getCouleur() {
		return couleur;
	}


	public boolean isSociable() {
		return sociable;
	}


	public Animal getAnimal() {
		return animal;
	}


	public List<Match> getMatchs() {
		return matchs;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setPuce(int puce) {
		this.puce = puce;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public void setSociable(boolean sociable) {
		this.sociable = sociable;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Vendeur getVendeur() {
		return vendeur;
	}


	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}


	@Override
	public String toString() {
		return "Fiche [id=" + id + ", description=" + description + ", creation=" + creation + ", nom=" + nom
				+ ", sexe=" + sexe + ", age=" + age + ", puce=" + puce + ", poids=" + poids + ", couleur=" + couleur
				+ ", sociable=" + sociable + ", animal=" + animal + ", vendeur=" + vendeur + ", matchs=" + matchs + "]";
	}


	

	

	
	
	
	
	
	
}
