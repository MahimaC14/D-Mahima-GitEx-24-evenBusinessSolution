package com.tfseven.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
@Entity
public class Locations
{
	int location_id;
	@NotNull
	String street_address;
	@NotNull
	long postal_code;
	@NotNull
	String city;
	@NotNull
	String state_province;
	@NotNull
	int country_id;

	public Locations(){}
	
	public Locations(int location_id, String street_address, long postal_code, String city, String state_province,
			int country_id) {
		super();
		this.location_id = location_id;
		this.street_address = street_address;
		this.postal_code = postal_code;
		this.city = city;
		this.state_province = state_province;
		this.country_id = country_id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
	@Column(length=20)
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	@Column(length=20)
	public long getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(long postal_code) {
		this.postal_code = postal_code;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	@Column(length=20)
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	
	
	
	@Override
	public String toString() {
		return "Locations [location_id=" + location_id + ", street_address=" + street_address + ", postal_code="
				+ postal_code + ", city=" + city + ", state_province=" + state_province + ", country_id=" + country_id
				+ "]";
	}

	
	
}
