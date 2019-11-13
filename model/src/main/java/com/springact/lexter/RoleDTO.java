package com.spring.lexter;

/**
 * Hello world!
 *
 */

public class RoleDTO {

	private int id;

	private String role;

	public RoleDTO() {
		role = "";
	}

	public RoleDTO(String role) {
		this.role = role;
	}

	public RoleDTO(int id, String role) {
		this.id = id;
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}

	public String toString() {
		return this.role;
	}

	@Override
	public int hashCode() {
		return (int) role.hashCode();
	}

}