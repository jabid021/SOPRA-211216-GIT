package safariJpa.model.singleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("chat")
public class Chat extends Animal {
	@Column(name="poil_court")
	private boolean poilCourt;
	@Column(name="malheur")
	private boolean malheur;

	public Chat() {

	}

	public Chat(String race, boolean poilCourt, boolean malheur) {
		super(race);
		this.poilCourt = poilCourt;
		this.malheur = malheur;
	}

	public Chat(String race) {
		super(race);
		// TODO Auto-generated constructor stub
	}

	public boolean isPoilCourt() {
		return poilCourt;
	}

	public void setPoilCourt(boolean poilCourt) {
		this.poilCourt = poilCourt;
	}

	public boolean isMalheur() {
		return malheur;
	}

	public void setMalheur(boolean malheur) {
		this.malheur = malheur;
	}

}
