package com.spring.lexter;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleServiceIMPL implements RoleService {

	// private List<Role> roles = new ArrayList<Role>();

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired
	private RoleRepository roleRepository;

	public RoleServiceIMPL(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public List<Role> readRoles() {
		List<Role> roles = new ArrayList<Role>();
		roleRepository.findAll().forEach(role -> roles.add(role));
		return roles;
	}

	public Role getRole(int id) {
		// Role role = (Role) hibernateUtil.getSingleObject(Role.class, id);
		Role role = roleRepository.findById(id).get();
 		if(role == null) {
			return null;
		}
		return role;
	}

	public boolean addRole(Role role) {
		List<Role> roles = readRoles();
		System.out.println(roles);
		boolean existing = roles.stream().anyMatch(r -> r.getRole().equals(role.getRole()));
		System.out.println(existing);
		if(role == null) {
			return false;
		}
		if(!existing) {
			roleRepository.save(role);
			return true;
		}
		else {
			return false;
		}
	}

	public void updateRole(Role role) {
		// hibernateUtil.updateObject(role);
		roleRepository.save(role);
	}

	public void deleteRole(int id) {
		// Role role = (Role) hibernateUtil.getSingleObject(Role.class, id);
		// hibernateUtil.deleteObject(role);
		roleRepository.deleteById(id);
	}
}