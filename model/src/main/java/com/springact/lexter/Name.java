package com.spring.lexter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Name {

	@Column(name="lastname")
	private String lastName;
	@Column(name="firstname")
	private String firstName;
	@Column(name="midname")
	private String midName = "";
	@Column(name="suffix")
	private String suffix = "";

	public Name() {
		
	}

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Name(String firstName, String lastName, String midName, String suffix) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.suffix = suffix;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getMidName() {
		return midName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getSuffix() {
		return suffix;
	}

	public String toString() {
		return lastName+" "+firstName+" "+midName+" "+suffix;
	}

}