package safariJpa.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="admin",uniqueConstraints = {@UniqueConstraint(columnNames = "login",name = "admin_login_uk")})
public class Admin extends Compte {
	public Admin() {

	}

	public Admin(String login, String password, String mail) {
		super(login, password, mail);
		// TODO Auto-generated constructor stub
	}

}
