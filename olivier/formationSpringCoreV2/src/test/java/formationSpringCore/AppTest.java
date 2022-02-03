package formationSpringCore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		// spring disponible
		// Personne p=(Personne)ctx.getBean("olivier");
		// ctx.getBean(Personne.class); possible uniquement si 1 seul objet candidat
		Personne p = ctx.getBean("personne", Personne.class);
		System.out.println(p.getAdresse());
		ctx.close();
	}
}
