package exoSpring.bean;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {

	@Override
	public void jouer() {
		System.out.println("le piano");
	}

}
