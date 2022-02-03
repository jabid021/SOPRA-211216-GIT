package exoSpring.bean;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument {

	@Override
	public void jouer() {
		System.out.println("la guitare");
	}

}
