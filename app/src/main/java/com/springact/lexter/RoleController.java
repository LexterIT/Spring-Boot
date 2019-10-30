package com.spring.lexter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleSerivce;

	@RequestMapping("/roles")
	public ResponseEntity<Object> readRoles() {
		roleSerivce.readRoles();
		return new ResponseEntity<>(roleSerivce.readRoles(), HttpStatus.OK);
	}

	@RequestMapping("/roles/{id}")
	public Role readRole(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();	
		return roleSerivce.getRole(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/roles")
	public ResponseEntity<Object> addRole(@RequestBody Role role) {
		roleSerivce.addRole(role);
		return new ResponseEntity<>("The Role:"+role+" has been added!", HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/roles/{id}")
	public ResponseEntity<Object> updateRole(@RequestBody Role role, @PathVariable int id) {
		roleSerivce.updateRole(role);
		return new ResponseEntity<>("Role has been updated", HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/roles/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable int id) {
		roleSerivce.deleteRole(id);
		return new ResponseEntity<>("Role has been deleted", HttpStatus.OK);
	}
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
}