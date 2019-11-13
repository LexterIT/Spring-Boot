package com.spring.lexter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsIMPL implements UserDetails {

	private User user;

	public UserDetailsIMPL(User user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> 	 getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	public String getUsername() {
		return user.getUsername();
	}

	public String getPassword() {
		return user.getPassword();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}	

	public boolean isEnabled() {
		return true;
	}

}