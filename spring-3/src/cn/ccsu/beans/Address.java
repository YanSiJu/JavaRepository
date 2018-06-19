package cn.ccsu.beans;

public class Address {

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}

	private String city;
	private String street;

	public Address() {

		System.out.println("Address's   constructor!!");

	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
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
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

}
