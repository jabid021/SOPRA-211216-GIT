package formationSpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import formationSpringCore.beans.InterfacePourAspect;
import formationSpringCore.beans.Personne;

public class AppSpring {
	@Autowired
	@Qualifier("olivier")
	private InterfacePourAspect olivier;

	public void run(String... args) {
		System.out.println(olivier.methodePourTestAspect());
	}
}
