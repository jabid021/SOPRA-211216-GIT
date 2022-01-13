package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Adresse;
import model.Client;
import model.Compte;
import model.Refuge;
import model.Vendeur;

public class DAOCompte implements IDAO<Compte,Integer> {

	@Override
	public Compte findById(Integer id) {
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

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

	@Override
	public List<Compte> findAll() {
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

	@Override
	public void insert(Compte c) {
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

	@Override
	public void update(Compte c) {
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

	@Override
	public void delete(Integer id) {
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

}
