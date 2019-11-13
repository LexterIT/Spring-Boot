package com.spring.lexter;


import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserDetailService extends UserDetailsService {

	void addUser(User user);

}