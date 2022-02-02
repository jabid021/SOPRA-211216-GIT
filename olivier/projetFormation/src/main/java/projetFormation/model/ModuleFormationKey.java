package projetFormation.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ModuleFormationKey implements Serializable {

	/**
	 * Default constructor
	 */
	public ModuleFormationKey() {
	}

	@ManyToOne
	@JoinColumn(name = "formation_module_formation_id", foreignKey = @ForeignKey(name = "formation_module_formation_id_fk"))
	private Formation formation;

	@ManyToOne
	@JoinColumn(name = "formation_module_module_id", foreignKey = @ForeignKey(name = "formation_module_module_id_fk"))
	private Module module;

	public ModuleFormationKey(Formation formation, Module module) {
		super();
		this.formation = formation;
		this.module = module;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public int hashCode() {
		return Objects.hash(formation, module);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleFormationKey other = (ModuleFormationKey) obj;
		return Objects.equals(formation, other.formation) && Objects.equals(module, other.module);
	}

}