package formation.sopra.exerciceBootSecurite.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private Compte compte;

	public CustomUserDetails(Compte compte) {
		super();
		this.compte = compte;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> role = null;
		if (compte instanceof Utilisateur) {
			role = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			role = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_AUTRE"));
		}
		return role;
	}

	@Override
	public String getPassword() {
		return compte.getPassword();
	}

	@Override
	public String getUsername() {
		return compte.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
