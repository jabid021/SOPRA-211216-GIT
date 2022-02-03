package exoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import exoSpring.bean.Musicien;

public class App {

	@Autowired
	@Qualifier("guitariste")
	private Musicien musicien;

	public void run(String... args) {
		musicien.jouer();
	}
}
