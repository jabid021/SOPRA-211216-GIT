package safariJpa.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
@SequenceGenerator(name = "seqDefault", sequenceName = "seq_chat", initialValue = 100, allocationSize = 1)
public class Chat extends Animal {
	private boolean poilCourt;
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
