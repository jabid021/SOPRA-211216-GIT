package formation.sopra.springBoot.dto;

import java.util.List;

public class EmployeDto {
	private Long id;
	private String nom;
	private List<EmployeDto> subordonnes;
	private EmployeDto manager;
	
	public EmployeDto() {
		
	}

	public EmployeDto(Long id, String nom, EmployeDto manager) {
		super();
		this.id = id;
		this.nom = nom;
		this.manager = manager;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<EmployeDto> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<EmployeDto> subordonnes) {
		this.subordonnes = subordonnes;
	}

	public EmployeDto getManager() {
		return manager;
	}

	public void setManager(EmployeDto manager) {
		this.manager = manager;
	}
	
	
	
	
}
