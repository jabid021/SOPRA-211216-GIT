package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Fiche;
import model.Vendeur;

public class DAOFiche implements IDAO<Fiche,Integer> {

	@Override
	public Fiche findById(Integer id) {
		Fiche f=null;
		DAOCompte daoC = new DAOCompte();
		DAOAnimal daoA = new DAOAnimal();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche where id_fiche=?");
			ps.setInt(1,id);

			ResultSet rs = ps.executeQuery();



			while(rs.next()) 
			{
				Animal a = daoA.findById(rs.getInt("animal"));
				Vendeur v = (Vendeur) daoC.findById(rs.getInt("vendeur"));
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

	@Override
	public List<Fiche> findAll() {
		List<Fiche> fiches = new ArrayList<>();
		DAOCompte daoC = new DAOCompte();
		DAOAnimal daoA = new DAOAnimal();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche");
			ResultSet rs = ps.executeQuery();

			Fiche f=null;

			while(rs.next()) 
			{
				Animal a = daoA.findById(rs.getInt("animal"));
				Vendeur v = (Vendeur) daoC.findById(rs.getInt("vendeur"));
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

	@Override
	public void insert(Fiche c) {
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

	@Override
	public void update(Fiche f) {
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

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM fiche WHERE id_fiche=?");
			ps.setInt(1,id);

			ps.executeUpdate();


			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}



}
