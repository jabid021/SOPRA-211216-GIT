package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Admin;
import model.Adresse;
import model.Animal;
import model.Chat;
import model.Chien;
import model.Civilite;
import model.Client;
import model.Compte;
import model.Fiche;
import model.Refuge;
import model.Vendeur;

public class App {

	
	static Compte connected = null;
	
	
	
	
	
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}
	
	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	//CRUD Compte PARIS------------------------------------- Ajouter id dans compte

	public static Compte seConnecter(String login,String password) 
	{
		Compte connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1,login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			Compte c=null;
			
			while(rs.next()) 
			{
				
				if(rs.getString("type_compte").equals("client")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					connect=new Client(rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"), a);
				}
				else if(rs.getString("type_compte").equals("admin")) 
				{
					connect = new Admin(rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"),rs.getString("mail"));
				}
				else if(rs.getString("type_compte").equals("vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					connect=new Vendeur(rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")), a);
				}
			}
			
			rs.close();
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connect;
		
	}
	
	public static Compte ComptefindById(int id) 
	{
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id_compte=?");
			ps.setInt(1,id);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			
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
			rs.close();
			ps.close();
			conn.close();
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	public static List<Compte> ComptefindAll()
	{
		List<Compte> comptes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from Compte");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{	
						
				if(rs.getString("type_compte").equals("client")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					Client c=new Client(rs.getInt("id_compte"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"),a);
					comptes.add(c);
				}
				else if(rs.getString("type_compte").equals("admin")) 
				{
					Admin c = new Admin(rs.getInt("id_compte"), rs.getString("login"), rs.getString("password"),rs.getString("mail"));
					comptes.add(c);
				}
				else if(rs.getString("type_compte").equals("vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					Vendeur c=new Vendeur(rs.getInt("id_compte"),rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")),a);
					comptes.add(c);
				}
			}
			
			
			rs.close();
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		
	}
	
		return comptes;
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

		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

//            ComptefindById(c.getId());

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
			e.printStackTrace();
		}
		return a;

	}

	public static List<Animal> AnimalfindAll()
	{
		List<Animal> animaux=new ArrayList<Animal>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from animal");

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				if (rs.getString("type_animal").equals("chien"))
				{
					animaux.add(new Chien(rs.getInt("id_animal"), rs.getString("race")));
				} else if (rs.getString("type_animal").equals("chat"))
				{
					animaux.add(new Chat(rs.getInt("id_animal"), rs.getString("race"), rs.getBoolean("poil_court"),
							rs.getBoolean("malheur")));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return animaux;
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
			
			ps.setInt(5, c.getId()) ;  

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
		Fiche f=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche where id_fiche=?");
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) 
			{
				Animal a = AnimalfindById(rs.getInt("animal"));
				Vendeur v = (Vendeur) ComptefindById(rs.getInt("vendeur"));
				f = new Fiche(id,rs.getString("description"), LocalDate.parse(rs.getString("creation")), rs.getString("nom"), 
						rs.getString("sexe"), rs.getInt("age"), rs.getInt("puce"), rs.getDouble("poids"), rs.getString("couleur"),
						rs.getBoolean("sociable"), a,v);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
		return f;
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
				Vendeur v = (Vendeur) ComptefindById(rs.getInt("vendeur"));
				f = new Fiche(rs.getInt("id_fiche"),rs.getString("description"), LocalDate.parse(rs.getString("creation")), rs.getString("nom"), 
						rs.getString("sexe"), rs.getInt("age"), rs.getInt("puce"), rs.getDouble("poids"), rs.getString("couleur"),
						rs.getBoolean("sociable"), a,v);
				
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

	public static void Fichedelete (Integer id) 
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM fiche WHERE id=?");
			ps.setInt(1,id);
			
			ps.executeUpdate();
		
		
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	//-------------------------TOULOUSE----------------------------



	
	
	
	
	
	
	
	public static void main(String[] args) {

		
		
		//menuPrincipal();
		//deleteCompte(8);
		
	}

	public static void menuPrincipal() {
		
		System.out.println("Menu principal");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Fermer l'appli");
		
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);break;
		}
		
		menuPrincipal();
		
	}


	public static void connexion() {
		
		System.out.println("Connexion");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected= seConnecter(login, password);
		
		if(connected instanceof Client) {menuClient();}
		else if(connected instanceof Vendeur) {menuVendeur();}
		else if(connected instanceof Admin) {menuAdmin();}
		else if(connected ==null) 
		{
			System.out.println("Identifiants invalides !");
		}
		menuPrincipal();
		
		
	}

	public static void menuAdmin() {
		
		System.out.println("Menu Admin");
		System.out.println("1 - Afficher toutes les fiches");
		System.out.println("2 - Afficher tous les comptes");
		System.out.println("3 - Afficher tous les animals");
		System.out.println("4 - Afficher tous les matchs");
		System.out.println("5 - Ajouter un animal");
		System.out.println("6 - Modifier un animal");
		System.out.println("7 - Se deconnecter");
		
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : showAllFiches();break;
		case 2 : showAllComptes();break;
		case 3 : showAllAnimaux();break;
		case 4 : showAllMatchs();break;
		case 5 : addAnimal();break;
		case 6 : updateAnimal();break;
		case 7 : connected=null;break;
		}
		
		menuAdmin();
	}



	

	public static void menuVendeur() {

		System.out.println("Menu Vendeur");
		System.out.println("1 - Consulter mes fiches");
		System.out.println("2 - Ajouter une nouvelle fiche");
		System.out.println("3 - Modifier une fiche");
		System.out.println("4-  Supprimer une fiche ");
		System.out.println("5 - Voir les matchs de mes fiches ");
		System.out.println("6-  Modifier mon profil ");
		System.out.println("7 - Se deconnecter");
		
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : showFichesVendeur();break;
		case 2 : addFiche();break;
		case 3 : updateFiche();break;
		case 4 : deleteFiche();break;
		case 5 : showMatchsVendeur();break;
		case 6 : modifierInfosVendeur();break;
		case 7 : connected=null;menuPrincipal();break;
		}
		
		menuVendeur();
		
	}



	public static void menuClient() {
		
		System.out.println("Menu Client");
		System.out.println("1 - Consulter les fiches");
		System.out.println("2 - Consulter mes match");
		System.out.println("3- Modifier mon profil");
		System.out.println("4 - Se deconnecter");
		
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : clientMatch();break;
		case 2 : showMatchsClient();break;
		case 3 : modifierInfosClient();break;
		case 4 : connected=null;menuPrincipal();break;
		}
		
		menuClient();
	}

	
	//GESTION DES COMPTES
	
	public static void inscription() {
		//choisir si on veut un compte client / vendeur
		//Si client, saisir login,password,mail,adresse,tel
		//Si vendeur, saisir login,password,mail,refuge,adresse
		

		
		System.out.println("1 - Client");
		System.out.println("2 - Vendeur");
		
		int choix = saisieInt("Choisir un type de compte");
		
		if ( choix ==1) {
			String log= saisieString("Entrer votre login");
			String pass= saisieString("Entrer votre password");
			String mail= saisieString("Entrer votre mail");
			String tel= saisieString("Entrer votre numero de telephone");
			System.out.println("Entrer votre adresse");
			Adresse adr = new Adresse(saisieString("Entrer votre numero"),saisieString("Entrer votre voie"),saisieString("Entrer votre ville"),saisieString("Entrer votre code postal"));
			Compte c = new Client(1,log,pass,mail,tel,adr);
			Compteinsert(c);
		}
		else if ( choix ==2) {
			String log= saisieString("Entrer votre login");
			String pass= saisieString("Entrer votre password");
			String mail= saisieString("Entrer votre mail");
			

			String refuge = saisieString("Saisir refuge "+Arrays.toString(Refuge.values()));
			System.out.println("Entrer votre adresse");
			Adresse adr = new Adresse(saisieString("Entrer votre numero"),saisieString("Entrer votre voie"),saisieString("Entrer votre ville"),saisieString("Entrer votre code postal"));
			Compte c = new Vendeur(1,log,pass,mail,Refuge.valueOf(refuge),adr);
			Compteinsert(c);
		}

		
		
	}
	
	public static void modifierInfosVendeur() {
		//Pouvoir modifier login/mail/password/adresse(numero,voie,cp,ville) / refuge
		
		System.out.println("Menu modification donnees Vendeur");
		System.out.println("1 - Modification login");
		System.out.println("2 - Modification mail");
		System.out.println("3 - Modification password");
		System.out.println("4 - Modification numero ");
		System.out.println("5 - Modification voie ");
		System.out.println("6 - Modification ville");
		System.out.println("7 - Modification cp");
		System.out.println("8 - Modification refuge");
		System.out.println("9 - Sauvgarder toutes les modifications et revenir vers le menu Vendeur");
		System.out.println("10 - Annuler toutes les modifications et revenir vers le menu Vendeur");

		int choix = saisieInt("Choisir votre action");
		
		Vendeur c=((Vendeur)connected);
		
		
		switch(choix) 
		{
		case 1 : c.setLogin(saisieString("Veuillez saisir votre nouveau login : "));break;
		case 2 : c.setMail(saisieString("Veuillez saisir votre nouveau mail: "));break;
		case 3 : c.setPassword(saisieString("Veuillez saisir votre nouveau password : "));break;
		case 4 : c.getAdresse().setNumero(saisieString("Veuillez saisir votre nouveau numero : "));break;
		case 5 : c.getAdresse().setVoie(saisieString("Veuillez saisir votre nouvelle voie : "));break;
		case 6 : c.getAdresse().setVille(saisieString("Veuillez saisir votre nouvelle ville : "));break;
		case 7 : c.getAdresse().setCp(saisieString("Veuillez saisir votre nouveau CP : "));break;
		case 8 : c.setRefuge(Refuge.valueOf(saisieString("Veuillez saisir votre nouveau refuge : ")));break;
		case 9 : connected=c;Compteupdate(connected);menuClient();break;
		case 10 : menuClient();break;
		}

		modifierInfosVendeur();
		
	}

	public static void modifierInfosClient() 
	{
		System.out.println("Menu modification donn�es du Client");
		System.out.println("1 - Modification du login");
		System.out.println("2 - Modification du mail");
		System.out.println("3 - Modification du password");
		System.out.println("4 - Modification Adresse : Modification du num�ro");
		System.out.println("5 - Modification Adresse : Modification de la voie");
		System.out.println("6 - Modification Adresse : Modification de la ville");
		System.out.println("7 - Modification Adresse : Modification du cp");
		System.out.println("8 - Modification du tel");
		System.out.println("9 - Sauvgarder toutes les modifications et revenir vers le menu Client");
		System.out.println("10 - Annuler toutes les modifications et revenir vers le menu Client");

		int choix = saisieInt("Choisir une action");
		
		Client c=((Client)connected);

		switch(choix) 
		{
		case 1 : c.setLogin(saisieString("Veuillez saisir votre nouveau login : "));break;
		case 2 : c.setMail(saisieString("Veuillez saisir votre nouveau mail: "));break;
		case 3 : c.setPassword(saisieString("Veuillez saisir votre nouveau password : "));break;
		case 4 : c.getAdresse().setNumero(saisieString("Veuillez saisir votre nouvelle adresse : nouveau numero : "));break;
		case 5 : c.getAdresse().setVoie(saisieString("Veuillez saisir votre nouvelle adresse : nouvelle voie : "));break;
		case 6 : c.getAdresse().setVille(saisieString("Veuillez saisir votre nouvelle adresse : nouvelle ville : "));break;
		case 7 : c.getAdresse().setCp(saisieString("Veuillez saisir votre nouvelle adresse : nouveau CP : "));break;
		case 8 : c.setTel(saisieString("Veuillez saisir votre nouveau numero : "));break;
		case 9 : connected=c;Compteupdate(connected);menuClient();break;
		case 10 : menuClient();break;
		}

		modifierInfosClient();
		
	}
	
	public static void showAllComptes() {
		List<Compte> listComptes = new ArrayList<Compte>();
		listComptes=ComptefindAll();
		for (Compte c:listComptes) {
			System.out.println(c);
		}
		
	}
	//----------------------------------------
	
	
	
	//GESTION DES MATCHS
	
	public static void showMatchsVendeur() {
		//Afficher les match du vendeur connecte
		
	}

	public static void showMatchsClient() {
		//Affiche tous les match du client connected
		
	}
	

	public static void showAllMatchs() {
		// TODO Auto-generated method stub
		
	}
	

	public static void clientMatch() {
		
		//Lister toutes les fiches
		//Dans un for each, demander au client s'il veut match ou non
		//Si match, insert match 
	}
	


	//------------------------------
	
	
	
	
	//GESTION DES FICHES
	public static void deleteFiche() {
		//Afficher toutes mes fiches 
		showFichesVendeur();
		//Choisir l'id a delete
		
		
	}

	public static void updateFiche() {
		//Afficher toutes mes fiches 
		showFichesVendeur();
		//FindById de la fiche � modifier
		//Saisir les modifs
		
	}
	
	public static void addFiche() {
		//Remplir les infos d'une fiche
		
		
	}

	public static void showFichesVendeur() {
		//Afficher les fiches du vendeur connecte
		
	}
	
	
	public static void showAllFiches() {
		// TODO Auto-generated method stub
		
	}

	//-------------------------------------------
	
	
	// Gestion des animals
	
	public static void showAllAnimaux() {
		// TODO Auto-generated method stub
		
	}
	
	
	private static void updateAnimal() {
		// TODO Auto-generated method stub
		
	}

	private static void addAnimal() {
		// TODO Auto-generated method stub
		
	}

	//---------------------
	

	
}
