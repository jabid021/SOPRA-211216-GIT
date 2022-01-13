package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	public static Fiche FichefindById(Integer id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche where fiche_id=?");
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			Fiche f=null;
			
			while(rs.next()) 
			{
				Animal a = AnimalfindById(rs.getInt("animal"));
				
				f = new Fiche(rs.getString("description"), LocalDate.parse(rs.getString("creation")), rs.getString("nom"), 
						rs.getString("sexe"), rs.getInt("age"), rs.getInt("puce"), rs.getDouble("poids"), rs.getString("couleur"),
						rs.getBoolean("sociable"), a);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
			return f;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static List<Fiche> FichefindAll()
	{
		List<Fiche> fiches = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche");
			ResultSet rs = ps.executeQuery();
			
			Fiche f=null;
			
			while(rs.next()) 
			{
				Animal a = AnimalfindById(rs.getInt("animal"));
				
				f = new Fiche(rs.getString("description"), LocalDate.parse(rs.getString("creation")), rs.getString("nom"), 
						rs.getString("sexe"), rs.getInt("age"), rs.getInt("puce"), rs.getDouble("poids"), rs.getString("couleur"),
						rs.getBoolean("sociable"), a);
				
				fiches.add(f);
			}
			
			rs.close();
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return fiches;
	}
	//--------------------------------LE RESTE DU MONDE---------------
	
	
	
	
	
	
	
	
	
	//Fiche2------------------------TOULOUSE------------- Ajouter id dans fiche

	public static void Ficheinsert(Fiche c) 
	{
		//c.getAnimal().getId();
	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Ficheupdate(Fiche c) 
	{

	}

	public static void Fichedelete (int id) 
	{

	}
	//-------------------------TOULOUSE----------------------------





	public static void main(String[] args) {






	}

}
