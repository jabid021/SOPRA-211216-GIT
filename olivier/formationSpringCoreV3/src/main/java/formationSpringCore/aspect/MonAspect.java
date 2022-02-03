package formationSpringCore.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {

	@Before("execution(String formationSpringCore.beans.Personne.methodePourTestAspect())")
	public void before() {
		System.out.println("methode before de l'aspect");
	}

	@AfterReturning(pointcut = "execution(* formationSpringCore.beans.*.toString())", returning = "returning")
	public void afterReturn(String returning) {
		System.out.println("la valeur remonter par le toString:" + returning);
	}

	@Around("execution(String formationSpringCore.beans.Personne.methodePourTestAspect())")
	public String arround(ProceedingJoinPoint pJP) throws Throwable {
		System.out.println("dans le arround avant le proceed");
		String s = pJP.getTarget().toString();
		// pJP.proceed();
		System.out.println("dans le arround apres le proceed sans avoir execute la methode de depart");
		return s;
	}
	
	//@Around=>ProceedingJointPoint avec la methode proceed()
	//@Before
	//la methode
	//si execution ok=>@AfterReturning
	//si execution ko=>@AfterThrowing
	//@After
}
