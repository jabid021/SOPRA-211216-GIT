package formationJpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formationJpa.exceptions.PosteException;
import formationJpa.model.Poste;
import formationJpa.repositories.PosteRepository;

@Service
public class PosteService {

	@Autowired
	PosteRepository posteRepository;

	public List<Poste> getAll() {
		return posteRepository.findAll();
	}

	public Poste getByCode(String code) {
		return posteRepository.findById(code).orElseThrow(PosteException::new);
	}

	public Poste save(Poste poste) {
		checkData(poste);
		Poste posteEnBase = null;
		try {
			posteEnBase = getByCode(poste.getCode());
			posteEnBase.setLibelle(poste.getLibelle());
			posteEnBase.setSalaireMax(poste.getSalaireMax());
			posteEnBase.setSalaireMin(poste.getSalaireMin());
			posteEnBase = posteRepository.save(posteEnBase);
		} catch (PosteException e) {
			posteEnBase = posteRepository.save(poste);
		}
		return posteEnBase;

	}

	private void checkData(Poste poste) {
		if (poste.getCode() == null || poste.getCode().isEmpty()) {
			throw new PosteException();
		}
		if (poste.getLibelle() == null || poste.getLibelle().isEmpty()) {
			throw new PosteException();
		}
	}
}
