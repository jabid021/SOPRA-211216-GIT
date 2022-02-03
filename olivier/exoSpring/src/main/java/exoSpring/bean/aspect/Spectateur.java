package exoSpring.bean.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class Spectateur {

	@Pointcut("execution(void exoSpring.bean.Musicien.jouer())")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before() {
		couperPortable();
		installation();
	}

	private void installation() {
		System.out.println("le public s'installe");
	}

	private void couperPortable() {
		System.out.println("telephone off");
	}

	@AfterReturning(pointcut = "pointcut()")
	public void bravo() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "pointcut()")
	public void huer() {
		System.out.println("bouhhhh");
	}

	@After("pointcut()")
	public void partir() {
		System.out.println("on part");
	}
}
