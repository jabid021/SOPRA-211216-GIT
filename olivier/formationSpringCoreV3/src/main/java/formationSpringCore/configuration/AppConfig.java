package formationSpringCore.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import formationSpringCore.beans.Adresse;
import formationSpringCore.beans.InterfacePourAspect;
import formationSpringCore.beans.Personne;

@Configuration
@ComponentScan(basePackages = { "formationSpringCore.beans", "formationSpringCore.aspect" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("perso")
	public Adresse getAdressePerso() {
		Adresse adresse = new Adresse();
		adresse.setAdresse("une adresse");
		return adresse;
	}

	@Bean("pro")
	public Adresse getAdressePro() {
		Adresse adresse = new Adresse();
		adresse.setAdresse("une adresse pro");
		return adresse;
	}

	@Bean("olivier")
	public Personne olivier(@Qualifier("pro") Adresse adresseAInjecter) {
		Personne p = new Personne();
		p.setAdresse(adresseAInjecter);
		return p;
	}
}
