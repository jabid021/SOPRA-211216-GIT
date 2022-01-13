package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Animal;
import model.Compte;
import model.Fiche;

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

	public static void Ficheinsert(Fiche c) 
	{
		//c.getAnimal().getId();
	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Ficheupdate(Fiche f) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
		
			PreparedStatement ps = conn.prepareStatement("UPDATE fiche set nom=?, description=?, creation=?, sexe=?, age=?, puce=?, poids=?, couleur=?, sociable=?, animal=?, vendeur=?  where id_fiche=?");
			
			System.out.println("Update de la fiche");
			ps.setString(1, f.getNom());
			ps.setString(2, f.getDescription());
			ps.setString(3, f.getCreation().toString());
			ps.setString(4, f.getSexe());
			ps.setInt(5, f.getAge());
			ps.setInt(6, f.getPuce());
			ps.setDouble(7, f.getPoids());
			ps.setString(8, f.getCouleur());
			ps.setBoolean(9, f.isSociable());
			ps.setInt(10, f.getAnimal().getId());
			ps.setInt(11, f.getVendeur().getId());
			ps.setInt(12, f.getId());
			
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fiche"+f+" update");
		
		
	}

	public static void Fichedelete (int id) 
	{
		
	}
	//-------------------------TOULOUSE----------------------------





	public static void main(String[] args) {






	}

}
