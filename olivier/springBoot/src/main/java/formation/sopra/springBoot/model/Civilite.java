package formation.sopra.springBoot.model;

public enum Civilite {
	M("monsieur"), MME("madame"), MLLE("mademoiselle");

	private String titre;

	private Civilite(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}
}
