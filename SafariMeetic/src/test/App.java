package test;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
=======
>>>>>>> Toulouse

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.time.LocalDate;
import model.Admin;
import model.Adresse;
import model.Animal;
import model.Client;
import model.Compte;
import model.Fiche;
import model.Refuge;
import model.Vendeur;

public class App {

	//les id pas en int mais en Integer

	//CRUD Compte PARIS------------------------------------- Ajouter id dans compte

	public static Compte ComptefindById(int id) 
	{
		return null;
	}
	public static List<Compte> ComptefindAll()
	{
		return null;
	}
	public static void Compteinsert(Compte c) 
	{

	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Compteupdate(Compte c) 
	{

	}

	public static void Comptedelete (int id) 
	{

	}
	//----------------PARIS-------------------------------------













	//CRUD Animaux--------BORDEAUX----------------------------- Ajouter id dans Animal

	public static Animal AnimalfindById(int id) 
	{
		return null;
	}
	public static List<Animal> AnimalfindAll()
	{
		return null;
	}
	public static void Animalinsert(Animal c) 
	{

	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Animalupdate(Animal c) 
	{

	}

	public static void Animaldelete (int id) 
	{

	}
	//------------------------BORDEAUX----------------------------











	//CRUD Fiche1-----------LE RESTE DU MONDE-------------------------- 


	/// 
	public static Fiche FichefindById(int id) 
	{

		//Animal a = AnimalfindById(id);
		return null;
	}
	public static List<Fiche> FichefindAll()
	{
		return null;
	}
	//--------------------------------LE RESTE DU MONDE---------------









	//Fiche2------------------------TOULOUSE------------- Ajouter id dans fiche

	public static void FicheInsert(Fiche c) 
	{


		try {
			//étape 1: charger la classe driver
			Class.forName("com.mysql.jdbc.Driver");
			//étape 2: créer l'objet de connexion
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			//étape 3: créer l'objet statement 
			PreparedStatement ps = conn.prepareStatement("INSERT INTO fiche (description,creation,nom,sexe,age,puce,poids,couleur,sociable,animal,vendeur) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			System.out.println("Insertion des caractéristique de la fiche");
			ps.setString(1, c.getDescription());
			ps.setString(2, c.getCreation().toString());
			ps.setString(3, c.getNom());
			ps.setString(4, c.getSexe());
			ps.setInt(5, c.getAge());
			ps.setInt(6, c.getPuce());
			ps.setDouble(7, c.getPoids());
			ps.setString(8, c.getCouleur());
			ps.setBoolean(9, c.isSociable());
			// ps.setInt(10, c.getAnimal().getId());
			// ps.setInt(11, c.getVendeur().getId());
		
			//Virer ces deux la demain
			ps.setInt(10, 2);
			ps.setInt(11, 3);

			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}

		System.out.println("Fiche"+c+" inséré avec succès");		




		//c.getAnimal().getId();
	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Ficheupdate(Fiche c) 
	{

	}

	public static void Fichedelete (int id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM fiche WHERE id=?");
			ps.setString(1,String.valueOf(id));
			
			ps.executeUpdate();
		
		
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//-------------------------TOULOUSE----------------------------



	public static void main(String[] args) {


		Fiche f = new Fiche("Descirpiton",LocalDate.now(),"nom","male",3,511487,10.5,"Blanc",true,null);
		FicheInsert(f);


	}

}
