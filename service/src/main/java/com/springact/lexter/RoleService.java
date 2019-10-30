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
	// // @Autowired
	// private HibernateUtil hibernateUtil;
	// // private ScannerUtil scannerUtil;

	// public RoleService(HibernateUtil hibernateUtil) {
	// 	// this.hibernateUtil = hibernateUtil;
	// 	// this.scannerUtil = new ScannerUtil();
	// }

	// public RoleService(HibernateUtil hibernateUtil, ScannerUtil scannerUtil) {
	// 	this.hibernateUtil = hibernateUtil;
	// 	this.scannerUtil = scannerUtil;
	// }

	// public void setScannerUtil(ScannerUtil scannerUtil) {
	// 	this.scannerUtil = scannerUtil;
	// }

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

	public void addRole(Role role) {
		hibernateUtil.insertObject(role);
	}

	public void updateRole(Role role) {
		hibernateUtil.updateObject(role);
	}

	public void deleteRole(int id) {
		Role role = (Role) hibernateUtil.getSingleObject(Role.class, id);
		hibernateUtil.deleteObject(role);
	}
}