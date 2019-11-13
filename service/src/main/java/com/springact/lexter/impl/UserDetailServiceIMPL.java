package com.spring.lexter;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceIMPL implements MyUserDetailService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("User 404");

		return new UserDetailsIMPL(user);
	}

	public void addUser(User user) {
		System.out.println(user);
		userRepository.save(user);
	}
}