package br.com.bingo.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bingo.models.SecUsuarios;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private int id;

	private String username;

	private String loginusuario;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(int id, String username, String loginusuario, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.loginusuario = loginusuario;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(SecUsuarios usuario) {
		List<GrantedAuthority> authorities = usuario.getSecPerfis().stream()
				.map(perfil -> new SimpleGrantedAuthority(perfil.getNOMEPERFIL()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				usuario.getIDUSUARIO(), 
				usuario.getNOMEUSUARIO(), 
				usuario.getLOGINUSUARIO(),
				usuario.getSENHA(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getLoginusuario() {
		return loginusuario;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
