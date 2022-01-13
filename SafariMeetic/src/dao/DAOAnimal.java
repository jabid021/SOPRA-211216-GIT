package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Chat;
import model.Chien;

public class DAOAnimal implements IDAO<Animal, Integer> {

	@Override
	public Animal findById(Integer id) {
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

	@Override
	public List<Animal> findAll() {
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

	@Override
	public void insert(Animal c) {
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

	@Override
	public void update(Animal c) {
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

	@Override
	public void delete(Integer id) {
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

}
