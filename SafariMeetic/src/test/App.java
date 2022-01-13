package test;

import java.time.LocalDate;
import java.util.List;
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
