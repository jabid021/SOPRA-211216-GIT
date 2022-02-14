package formationJpa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import formationJpa.config.AppConfig;
import formationJpa.exceptions.PosteException;
import formationJpa.model.Poste;
import formationJpa.repositories.PosteRepository;
import formationJpa.services.PosteService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
public class PosteTest {
	@Autowired
	PosteService posteService;

	@Test
	@Transactional
	@Disabled
	public void testInsertAndUpdate() {
		Poste poste = new Poste();
		poste.setCode("AD_PRES");
		poste.setLibelle("presidenttttt");
		poste.setSalaireMax(99999999);
		poste.setSalaireMin(10000);
		posteService.save(poste);
	}

	@Test
	@Transactional
	public void testErreurCreation() {
		assertThrows(PosteException.class, () -> {
			Poste poste = new Poste();
			//poste.setCode("AD_PRES");
			poste.setSalaireMax(99999999);
			poste.setSalaireMin(10000);
			posteService.save(poste);
		});
	}
}
