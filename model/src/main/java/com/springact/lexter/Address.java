package com.spring.lexter;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="street")
	private String street;
	@Column(name="barangay")
	private String barangay;
	@Column(name="municipality")
	private String municipality;
	@Column(name="zipcode")
	private String zipCode;

	public Address() {
		street = "";
		barangay = "";
		municipality = "";
		zipCode = "";
	}

	public Address(String street, String barangay, String municipality, String zipCode) {
		this.street = street;
		this.barangay = barangay;
		this.municipality = municipality;
		this.zipCode = zipCode;
	}


	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet() {
		return street;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}
	public String getBarangay() {
		return barangay;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getMunicipality() {
		return municipality;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getZipCode() {
		return zipCode;
	}

	public String toString() {
		return street +" " + barangay + " " + municipality + " " + zipCode;
	}

}