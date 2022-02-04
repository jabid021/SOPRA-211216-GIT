package formationJpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import formationJpa.config.AppConfig;
import formationJpa.model.Departement;
import formationJpa.repositories.DepartementRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class DepartementRepositoryTest {

	@Autowired
	DepartementRepository deptRepo;

	@Test
	@Disabled
	void test() {
		assertEquals(deptRepo.findAll().size(), deptRepo.count());
	}

	@Test
	@Transactional
	@Disabled
	void saveAndDeleteTest() {
		Departement d = new Departement("pour demo");
		deptRepo.save(d);
		deptRepo.delete(d);
	}
	
	@Test
	void requetePersoTest() {
		System.out.println(deptRepo.findByNomContaining("o"));
	}

	@Test
	@Disabled
	void findById() {
		Optional<Departement> opt = deptRepo.findById(100000L);
		System.out.println(opt);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		}
		assertThrows(NoResultException.class, () -> deptRepo.findById(100000L).orElseThrow(NoResultException::new));
		assertTrue(deptRepo.findById(100L).orElseThrow(NoResultException::new) instanceof Departement);
	}

	@Test
	@Disabled
	void demoPageAndSort() {
		// deptRepo.findAll();
//		Pageable page=PageRequest.of(0, 5);
//		Page<Departement> p= deptRepo.findAll(page);
//		System.out.println(p);
//		p.get().forEach(d->{
//			System.out.println(d.getNom());
//		});
//		p=deptRepo.findAll(p.nextOrLastPageable());
//		p.get().forEach(d->{
//			System.out.println(d.getNom());
//		});
//
//		deptRepo.findAll(Sort.by("nom").descending()).forEach(d -> {
//			System.out.println(d.getNom());
//		});
		
		Pageable page=PageRequest.of(0, 5,Sort.by("nom"));
		deptRepo.findAll(page).get().forEach(d->{
			System.out.println(d.getNom());
		});
	}

}
