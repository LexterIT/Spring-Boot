package com.spring.lexter;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleService {

	// private List<Role> roles = new ArrayList<Role>();

	// @Autowired
	private HibernateUtil hibernateUtil;

	public RoleService(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public List<Role> readRoles() {
		List<Role> roles = null;
		roles = hibernateUtil.getSorted(Role.class, "id", "asc");
		return roles;
	}

	public Role getRole(int id) {
		Role role = (Role) hibernateUtil.getSingleObject(Role.class, id);
		if(role == null) {
			return null;
		}
		return role;
		// return roles.stream().filter(r -> r.getId() == id).findFirst().get();
	}

	public boolean addRole(Role role) {
		List<Role> roles = readRoles();
		System.out.println(roles);
		boolean existing = roles.stream().anyMatch(r -> r.getRole().equals(role.getRole()));
		System.out.println(existing);
		if(!existing) { 
			hibernateUtil.insertObject(role);
			return true;
		}
		else {
			return false;
		}
	}

	public void updateRole(Role role) {
		hibernateUtil.updateObject(role);
	}

	public void deleteRole(int id) {
		Role role = (Role) hibernateUtil.getSingleObject(Role.class, id);
		hibernateUtil.deleteObject(role);
	}
}