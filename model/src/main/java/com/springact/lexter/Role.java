package com.spring.lexter;

/**
 * Hello world!
 *
 */
import javax.persistence.Entity;
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="roletbl")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "rolename")
	private String role;

	public Role() {
		role = "";
	}

	public Role(String role) {
		this.role = role;
	}

	public Role(int id, String role) {
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

	// @Override
	// public boolean equals(Object obj) {
	// 	System.out.println("Comparing");
	// 	Role rl = (Role) obj;
	// 	return rl.role.equals(this.role);
	// }

	@Override
	public int hashCode() {
		return (int) role.hashCode();
	}

}