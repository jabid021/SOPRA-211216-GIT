package safariJpa;

import java.util.HashSet;
import java.util.Set;

import safariJpa.dao.DaoCompte;
import safariJpa.dao.DaoFiche;
import safariJpa.dao.DaoMatch;
import safariJpa.model.Client;
import safariJpa.model.Fiche;
import safariJpa.model.Match;
import safariJpa.model.MatchKey;
import safariJpa.model.singleTable.Animal;
import safariJpa.model.singleTable.Chat;
import safariJpa.model.singleTable.Chien;
import safariJpa.model.singleTable.DaoAnimal;
import safariJpa.util.Context;

public class AppTest {

	public static void main(String[] args) {

		DaoAnimal daoAnimal = Context.getDaoAnimal();

		Animal a1 = new Chien("malinois");
		daoAnimal.insert(a1);
		Animal a2 = new Chat("siamois");
		daoAnimal.insert(a2);
		daoAnimal.findAll();

		DaoCompte daoCompte = Context.getDaoCompte();

		Client c1 = new Client("toto", "toto", "toto");
		Client c2 = new Client("tutu", "tutu", "tutu");
		daoCompte.insert(c1);
		daoCompte.insert(c2);

		DaoFiche daoFiche = Context.getDaoFiche();
		Fiche f1 = new Fiche();
		f1.setAnimal(a2);
		f1.setNom("fiche1");

		daoFiche.insert(f1);

		DaoMatch daoMatch = Context.getDaoMatch();

		Match m1 = new Match(new MatchKey(f1, c2));

		daoMatch.insert(m1);
		daoMatch.insert(new Match(new MatchKey(f1, c1)));
		Context.destroy();
	}

}
