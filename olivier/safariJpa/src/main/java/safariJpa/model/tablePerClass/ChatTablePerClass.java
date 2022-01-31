package safariJpa.model.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="chat_table_per_class")
public class ChatTablePerClass extends AnimalTablePerClass {
	private boolean poilCourt;
	private boolean malheur;

	public ChatTablePerClass() {

	}

	public ChatTablePerClass(String race, boolean poilCourt, boolean malheur) {
		super(race);
		this.poilCourt = poilCourt;
		this.malheur = malheur;
	}

	public ChatTablePerClass(String race) {
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
