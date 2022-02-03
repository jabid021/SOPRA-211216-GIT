package exoSpring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianiste implements Musicien {

	@Autowired
	@Qualifier("piano")
	private Instrument instrument;

	public Pianiste() {

	}

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le pianiste joue");
		//throw new IllegalArgumentException();
		instrument.jouer();
	}
}
