package exoSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoSpring.config.AppConfig;

public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(App.class).run(args);
		ctx.close();
	}

}
