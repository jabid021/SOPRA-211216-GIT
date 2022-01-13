package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Fiche;
import model.Match;

public class DAOMatch implements IDAO<Match,Integer> {

	@Override
	public Match findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Match> findAll() {
		List<Match> matches = new ArrayList<>();
		DAOFiche daoF = new DAOFiche();
		DAOCompte daoC = new DAOCompte();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from matchs");
			ResultSet rs = ps.executeQuery();

			Match m=null;

			while(rs.next()) 
			{
				Fiche f = daoF.findById(rs.getInt("fiche"));
				Client c = (Client) daoC.findById(rs.getInt("client"));
				m = new Match(rs.getInt("id_match"),f, c);
				matches.add(m);


			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return matches;
	}

	@Override
	public void insert(Match o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Match o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}


	public static List<Match> MatchfindByClientId(Integer clientId) {
		List<Match> clientMatchs = new ArrayList<>();
		DAOFiche daoF = new DAOFiche();
		DAOCompte daoC = new DAOCompte();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from matchs WHERE client = ?");
			ps.setInt(1,clientId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Fiche f = daoF.findById(rs.getInt("fiche"));
				Client c = (Client)daoC.findById(rs.getInt("client"));
				Match m = new Match(rs.getInt("id_match"), f, c);

				clientMatchs.add(m);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return clientMatchs;
	}

	public static List<Match> MatchfindByVendeurId(Integer vendeurId){
		List<Match> vendeurMatchs = new ArrayList<>();
		DAOFiche daoF = new DAOFiche();
		DAOCompte daoC = new DAOCompte();
		Match m=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche JOIN matchs ON fiche.id_fiche = matchs.fiche WHERE vendeur = ?;");
			ps.setInt(1,vendeurId);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{
				
				Fiche f = daoF.findById(rs.getInt("id_fiche"));
				Client c = (Client) daoC.findById(rs.getInt("client"));
				m = new Match(rs.getInt("id_match"), f, c);

				vendeurMatchs.add(m);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
		return vendeurMatchs;
	}

}
