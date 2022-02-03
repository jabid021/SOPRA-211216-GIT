package exoSpring.bean.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import exoSpring.bean.Musicien;

@Component
@Aspect
public class Spectateur2 {

	@Autowired
	@Qualifier("pianiste")
	private Musicien musicien;

	@Pointcut("execution(void exoSpring.bean.Musicien.jouer())")
	public void jouerMusicien() {

	}

	@Pointcut("execution(void exoSpring.bean.Guitariste.jouer())")
	public void jouerGuitariste() {

	}

	@Pointcut("execution(void exoSpring.bean.Pianiste.jouer())")
	public void jouerPianiste() {

	}

	@Before("jouerGuitariste()")
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

	@AfterReturning(pointcut = "jouerMusicien()")
	public void bravo() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "jouerMusicien()")
	public void huer() {
		System.out.println("bouhhhh");
	}

	@After("jouerGuitariste()")
	public void deuxiemeMusicien() {
		musicien.jouer();
	}

	@After("jouerPianiste()")
	public void partir() {
		System.out.println("on part");
	}
}
