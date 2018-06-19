package cn.csu.bean;

import java.io.Serializable;

public class Address implements Cloneable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String street;
	
	
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}



	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}



	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}



	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}



	public Address() {
		
	}

}
