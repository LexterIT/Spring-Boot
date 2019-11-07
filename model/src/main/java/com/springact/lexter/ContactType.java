package com.spring.lexter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name="contacttypetbl")
public class ContactType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="contacttype")
	private String contactType;

	public ContactType() {
		contactType = "";
	}

	public ContactType(String contactType) {
		this.contactType = contactType;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getContactType() {
		return contactType;
	}

	public String toString() {
		return this.id+".\t"+this.contactType;
	}

}