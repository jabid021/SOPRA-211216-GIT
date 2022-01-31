package safariJpa.model.tablePerClass;

import java.util.List;

import safariJpa.dao.DaoGeneric;
import safariJpa.model.Chien;

public interface DaoAnimalTablePerClass extends DaoGeneric<AnimalTablePerClass, Long>{
	List<ChienTablePerClass> findAllChien();
	List<ChatTablePerClass> findAllChat();
}
