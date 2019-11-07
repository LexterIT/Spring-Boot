package com.spring.lexter;

import java.util.List;
import java.util.ArrayList;
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
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="contacttbl")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="contacttype")
	private String contactType;
	@Column(name="contactinfo")
	private String contactInfo;
	@Column(name="index")
	private int index;

	public ContactInfo() {
		contactType = "";
		contactInfo = "";	
	}

	public ContactInfo(String contactType, String contactInfo) {
		this.contactType = contactType;
		this.contactInfo = contactInfo;
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

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getContactInfo() {
		return contactInfo;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public String toString() {
		return contactType + ":" + contactInfo;
	}

}