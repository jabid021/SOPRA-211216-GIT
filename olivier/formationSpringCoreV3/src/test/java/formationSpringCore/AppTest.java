package formationSpringCore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpringCore.beans.InterfacePourAspect;
import formationSpringCore.beans.Personne;
import formationSpringCore.configuration.AppConfig;

public class AppTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);

		// System.out.println(ctx.getBean(InterfacePourAspect.class).methodePourTestAspect());
		ctx.close();
	}
}
