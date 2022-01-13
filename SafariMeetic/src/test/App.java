package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id_compte=?");
			ps.setInt(1,id);
			
			
			ResultSet rs = ps.executeQuery();
			
			Compte c=null;
			
			while(rs.next()) 
			{
				
				if(rs.getString("type_compte").equals("client")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c=new Client((Integer)rs.getInt("id_compte"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"), a);
				}
				else if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin((Integer)rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"),rs.getString("mail"));
				}
				else if(rs.getString("type_compte").equals("vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c=new Vendeur((Integer)rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")), a);
				}
			}
			if(c==null) {System.out.println("Compte non existant");}
			else 
			{
				System.out.println("Compte "+id+" créé");
				
			}
			rs.close();
			ps.close();
			conn.close();
			return c;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	public static List<Compte> ComptefindAll()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Pour mac, changer le port 3306 -> 8889
			//Pour mac, password = "root"
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SafariMeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from Compte");
			ResultSet rs = ps.executeQuery();
			List<Compte> compte= new ArrayList();
		
			while(rs.next()) 
			{	
				//Compte c = new Compte(rs.getString("login"),rs.getString("password"),rs.getString("mail"));
				//System.out.println(c);
				
				if(rs.getString("type_compte").equals("Client")) 
				{
					Client c=new Client(rs.getInteger("id"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"), rs.getAdresse("adresse"));
					compte.add(c);
				}
				else if(rs.getString("type_compte").equals("Admin")) 
				{
					Admin c = new Admin(rs.getInteger("id"), rs.getString("login"), rs.getString("password"),rs.getString("mail"));
					compte.add(c);
				}
				else if(rs.getString("type_compte").equals("Vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					Vendeur c=new Vendeur(rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")),a);
					compte.add(c);
				}
			}
			
			
			rs.close();
			ps.close();
			conn.close();
			System.out.println("Tout est bon");
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		
	}
	
		return null;
	}
	public static void Compteinsert(Compte c) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(2,c.getLogin());
			ps.setString(3,c.getMail());
			ps.setString(4,c.getPassword());
			
			if(c instanceof Client) {
				ps.setString(6,((Client) c).getAdresse().getNumero());
				ps.setString(7, ((Client) c).getAdresse().getVoie());
				ps.setString(8, ((Client) c).getAdresse().getVille());
				ps.setString(9, ((Client) c).getAdresse().getCp());
				ps.setString(10, ((Client) c).getTel());
				ps.setString(11, "client");				
			}
			else if (c instanceof Vendeur) {
				ps.setString(5,((Vendeur) c).getRefuge().name());
				ps.setString(6,((Vendeur) c).getAdresse().getNumero());
				ps.setString(7, ((Vendeur) c).getAdresse().getVoie());
				ps.setString(8, ((Vendeur) c).getAdresse().getVille());
				ps.setString(9, ((Vendeur) c).getAdresse().getCp());
				ps.setString(11, "vendeur");
			}
			else if (c instanceof Admin) {
				ps.setString(11, "admin");
			}
						
			ps.executeUpdate();
			
			c.setId(null);
	
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Compteupdate(Compte c) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
//			ComptefindById(c.getId());
			
			PreparedStatement ps = conn.prepareStatement("Update Compte set login=?,mail=?,password=?,refuge=?,numero=?,voie=?,ville=?,cp=?,tel=?,type_compte=? where id_compte =?");
			ps.setString(1,c.getLogin());
			ps.setString(2,c.getMail());
			ps.setString(3,c.getPassword());
			ps.setInt(11,c.getId());
			
			if (c instanceof Client)
			{
				Client c1=((Client)c);
				Adresse a = c1.getAdresse();
				
				ps.setString(4,null);
				ps.setString(5,a.getNumero());
				ps.setString(6,a.getVoie());
				ps.setString(7,a.getVille());
				ps.setString(8,a.getCp());
				ps.setString(9,c1.getTel());
				ps.setString(10,"client");
			}
			else if(c instanceof Admin)
			{
				ps.setString(4,null);
				ps.setString(5,null);
				ps.setString(6,null);
				ps.setString(7,null);
				ps.setString(8,null);
				ps.setString(9,null);
				ps.setString(10,"admin");
			}
			else if(c instanceof Vendeur)
			{
				Vendeur c1=((Vendeur)c);
				Adresse a = c1.getAdresse();
				
				ps.setString(4,c1.getRefuge().toString());
				ps.setString(5,a.getNumero());
				ps.setString(6,a.getVoie());
				ps.setString(7,a.getVille());
				ps.setString(8,a.getCp());
				ps.setString(9,null);
				ps.setString(10,"vendeur");
			}

			ps.executeUpdate();

			ps.close();
			conn.close();
		
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

	public static void deleteCompte(int id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("delete from compte where id_compte="+id);
	
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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
