package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.sql.Statement;

import java.time.LocalDate;
import model.Admin;
import model.Adresse;
import model.Animal;
import model.Chat;
import model.Chien;
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
				System.out.println("Compte "+id+" cree");
				
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
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from Compte");
			ResultSet rs = ps.executeQuery();
			List<Compte> compte= new ArrayList();
		
			while(rs.next()) 
			{	
						
				if(rs.getString("type_compte").equals("client")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					Client c=new Client(rs.getInt("id_compte"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"),a);
					compte.add(c);
				}
				else if(rs.getString("type_compte").equals("admin")) 
				{
					Admin c = new Admin(rs.getInt("id_compte"), rs.getString("login"), rs.getString("password"),rs.getString("mail"));
					compte.add(c);
				}
				else if(rs.getString("type_compte").equals("vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					Vendeur c=new Vendeur(rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")),a);
					compte.add(c);
				}
			}
			
			
			rs.close();
			ps.close();
			conn.close();
			return compte;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		
	}
	
		return null;
	}
	public static void Compteinsert(Compte c) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte VALUES(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1,0);
			ps.setString(2,c.getLogin());
			ps.setString(3,c.getMail());
			ps.setString(4,c.getPassword());
			
			if(c instanceof Client) {
				ps.setString(5,null);
				ps.setString(6,((Client) c).getAdresse().getNumero());
				ps.setString(7, ((Client) c).getAdresse().getVoie());
				ps.setString(8, ((Client) c).getAdresse().getVille());
				ps.setString(9, ((Client) c).getAdresse().getCp());
				ps.setString(10, ((Client) c).getTel());
				ps.setString(11, "client");				
			}
			else if (c instanceof Vendeur) {
				ps.setString(5,((Vendeur) c).getRefuge().toString());
				ps.setString(6,((Vendeur) c).getAdresse().getNumero());
				ps.setString(7, ((Vendeur) c).getAdresse().getVoie());
				ps.setString(8, ((Vendeur) c).getAdresse().getVille());
				ps.setString(9, ((Vendeur) c).getAdresse().getCp());
				ps.setString(10, null);
				ps.setString(11, "vendeur");
			}
			else if (c instanceof Admin) {
				ps.setString(5,null);
				ps.setString(6,null);
				ps.setString(7,null);
				ps.setString(8,null);
				ps.setString(9,null);
				ps.setString(10, null);
				ps.setString(11, "admin");
			}
			
			ps.executeUpdate();
						
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				c.setId(rs.getInt(1));
			}
			
			
			
			rs.close();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Compteupdate(Compte c) 
	{

	}

	public static void deleteCompte(int id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("delete from compte where id_compte=?");
			ps.setInt(1, id);
	
			ps.executeUpdate();
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
		Animal a = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8", "root", "");

			PreparedStatement ps = conn.prepareStatement("SELECT * from animal where id_animal=?");
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();


			while (rs.next())
			{

				if (rs.getString("type_animal").equals("chien"))
				{
					a = new Chien(rs.getInt("id_animal"), rs.getString("race"));
				} else if (rs.getString("type_animal").equals("chat"))
				{
					a = new Chat(rs.getInt("id_animal"), rs.getString("race"), rs.getBoolean("poil_court"),
							rs.getBoolean("malheur"));
				}
			}
			rs.close();
			ps.close();
			conn.close();
			
		

		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}

	public static List<Animal> AnimalfindAll()
	{
		List<Animal> a=new ArrayList<Animal>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from animal");

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				if (rs.getString("type_animal").equals("chien"))
				{
					a.add(new Chien(rs.getInt("id_animal"), rs.getString("race")));
				} else if (rs.getString("type_animal").equals("chat"))
				{
					a.add(new Chat(rs.getInt("id_animal"), rs.getString("race"), rs.getBoolean("poil_court"),
							rs.getBoolean("malheur")));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return a;
	}
	
	public static void Animalinsert(Animal c) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO animal (race, poil_court, malheur, type_animal) VALUES (?,?,?,?)");
			ps.setString(1, c.getRace());
			
			if (c instanceof Chien)
			{
				ps.setObject(2, null);
				ps.setObject(3, null);
				ps.setString(4, "chien");
				
			} 
			else if (c instanceof Chat) 
			{
				ps.setBoolean(2, ((Chat) c).isPoilCourt() );
				ps.setBoolean(3, ((Chat) c).isMalheur() );
				ps.setString(4, "chat");
			}

			
			ps.executeUpdate();
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	//Pour un update, on set toutes les valeurs where id=?
	public static void Animalupdate(Animal c) 
	{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("UPDATE animal SET race=? , poil_court=? , malheur=? , type_animal=? where id_animal=?");
			
			ps.setString(1, c.getRace());
			
			if ( c instanceof Chien)
			{
				
				ps.setObject(2, null);
				ps.setObject(3, null);
				ps.setString(4, "chien");
			}
			else if (c instanceof Chat)
			{
				ps.setObject(2, ((Chat) c).isPoilCourt());
				ps.setObject(3, ((Chat) c).isMalheur());
				ps.setString(4, "chat");
			}
			
			ps.setInt(5, c.getIdAnimal()) ;  

			ps.executeUpdate();
			
			
			
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Animaldelete (int id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
				
			PreparedStatement st = conn.prepareStatement("DELETE from Animal WHERE id_animal=?");
			st.setInt(1,id);
			st.executeUpdate();
			
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	//------------------------BORDEAUX----------------------------











	//CRUD Fiche1-----------LE RESTE DU MONDE-------------------------- 


	/// 
	public static Fiche FichefindById(Integer id) 
	{
		
		//Animal a = AnimalfindById(id);
		return null;
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

	public static void FicheInsert(Fiche c) 
	{


		try {
			//�tape 1: charger la classe driver
			Class.forName("com.mysql.jdbc.Driver");
			//�tape 2: cr�er l'objet de connexion
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			//�tape 3: cr�er l'objet statement 
			PreparedStatement ps = conn.prepareStatement("INSERT INTO fiche (description,creation,nom,sexe,age,puce,poids,couleur,sociable,animal,vendeur) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

			System.out.println("Insertion des caract�ristique de la fiche");
			ps.setString(1, c.getDescription());
			ps.setString(2, c.getCreation().toString());
			ps.setString(3, c.getNom());
			ps.setString(4, c.getSexe());
			ps.setInt(5, c.getAge());
			ps.setInt(6, c.getPuce());
			ps.setDouble(7, c.getPoids());
			ps.setString(8, c.getCouleur());
			ps.setBoolean(9, c.isSociable());
			ps.setInt(10, c.getAnimal().getId());
			ps.setInt(11, c.getVendeur().getId());
		

			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}

		System.out.println("Fiche"+c+" ins�r� avec succ�s");		




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


		

	}

}
