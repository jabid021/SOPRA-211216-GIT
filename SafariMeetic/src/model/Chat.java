package model;

public class Chat extends Animal {

	private boolean poilCourt;
	private boolean malheur;
	

	public Chat(Integer idAnimal, String race, boolean poilCourt, boolean malheur) {
		super(idAnimal, race);
		this.poilCourt = poilCourt;
		this.malheur = malheur;
	}
	
	public Chat( String race, boolean poilCourt, boolean malheur) {
		super(race);
		this.poilCourt = poilCourt;
		this.malheur = malheur;
	}


	public boolean isPoilCourt() {
		return poilCourt;
	}


	public boolean isMalheur() {
		return malheur;
	}


	public void setPoilCourt(boolean poilCourt) {
		this.poilCourt = poilCourt;
	}


	public void setMalheur(boolean malheur) {
		this.malheur = malheur;
	}

	
	@Override
	public String toString() {
		return "Chat [poilCourt=" + poilCourt + ", malheur=" + malheur + ", race=" + race + ", id=" + id + "]";
	}

}
