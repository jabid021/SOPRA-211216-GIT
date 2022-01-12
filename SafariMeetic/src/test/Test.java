package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.Admin;
import model.Adresse;
import model.Client;
import model.Compte;
import model.Refuge;
import model.Vendeur;

public class Test {

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	
	public static void init() 
	{
		/*Adresse adresse1 = new Adresse("6","Rue rougemont","Paris","75009");
		Adresse adresse2 = new Adresse("12","Rue rougemont","Paris","75009");
		
		Client c = new Client("Jaxx","toto123","jordanabid@gmail.com","00440403765",adresse2);
		Admin a = new Admin("admin","admin@gmail.com");
		Vendeur v = new Vendeur("password","vendeur@yahoo.fr", Refuge.Animalerie, adresse1);
		
		Chien chien1 = new Chien("Bichon");
		Chien chien2 = new Chien("Husky");
		Chien chien3 = new Chien("Corgy");
		Chat chat1 = new Chat("Siamois",false,true);
		
		
		Fiche fiche1 = new Fiche("RAS",LocalDate.now(),"Rox","Male",4,751235978,6.2,"Blanc",true,chien1);
		v.getFiches().add(fiche1);
		
		Match m1 = new Match(fiche1,c);
		fiche1.getMatchs().add(m1);
		
		System.out.println(m1);*/
	}
	
	
	public static void seConnecter(String login,String password) 
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from compte where login='"+login+"' and password='"+password+"'");
			
			System.out.println("SELECT * from compte where login='"+login+"' and password='"+password+"'");
			Compte c=null;
			
			while(rs.next()) 
			{
				
				if(rs.getString("type_compte").equals("client")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c=new Client(rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"), a);
				}
				else if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getString("login"), rs.getString("password"),rs.getString("mail"));
				}
				else if(rs.getString("type_compte").equals("vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c=new Vendeur(rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")), a);
				}
				
				System.out.println("Welcome : "+c);
			}
			if(c==null) {System.out.println("Identifiants invalides");}
			else 
			{
				System.out.println("Welcome : "+c);
			}
			rs.close();
			st.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void seConnecterSECURE(String login,String password) 
	{

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
					c=new Client(rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("tel"), a);
				}
				else if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getString("login"), rs.getString("password"),rs.getString("mail"));
				}
				else if(rs.getString("type_compte").equals("vendeur")) 
				{
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
					c=new Vendeur(rs.getString("login"), rs.getString("password"), rs.getString("mail"), Refuge.valueOf(rs.getString("refuge")), a);
				}
			}
			if(c==null) {System.out.println("Identifiants invalides");}
			else 
			{
				System.out.println("Welcome : "+c);
			}
			rs.close();
			ps.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
	
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		
		seConnecterSECURE(login, password);

		

	}

}
