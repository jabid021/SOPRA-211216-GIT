package formation.sopra.springBoot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	// gestion des regles sur les URL
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off

		
		
		http.antMatcher("/api/**")
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().ignoringAntMatchers("/api/**")
			.and()
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/api/auth/search/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
				.antMatchers(HttpMethod.POST,"/api/auth/inscription").permitAll()
				.antMatchers(HttpMethod.POST).hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
				.antMatchers("/api/**").authenticated()
			.and()
			.httpBasic();
//			.and()
//		.antMatcher("/**")
//			.authorizeHttpRequests()
//				.antMatchers("/employe/**").authenticated()
//				.antMatchers("/departement/**").hasRole("DEPT")
//				.antMatchers("/poste/**").hasAnyRole("POSTE","ADMIN")
//			.and()
//				.formLogin()
//					.loginPage("/login")	
//			.and().logout();
		
		// @formatter:on
	}

	// gestion des utilisateurs
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		//inMemory
//		auth.inMemoryAuthentication()
//				.withUser("admin").password("{noop}admin").roles("ADMIN")
//			.and()
//				.withUser("dept").password("{noop}dept").roles("DEPT")
//			.and()
//				.withUser("poste").password("{noop}poste").roles("POSTE")
//			.and()
//				.withUser("olivier").password("{noop}olivier").roles("DEPT","ADMIN","POSTE");
		
		
		//requete sql
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.usersByUsernameQuery("select username,password,enable from users where username=?")
//				.authoritiesByUsernameQuery("select u.username,ur.roles from users u join users_roles ur on u.id=ur.utilisateur_id where username=?");
//						
		auth.userDetailsService(userDetailsService);
		// @formatter:on

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
