package cn.ccsu.springmvc.entities;

public class Address {

	private String city;
	private String province;
	
	
	
	public String getCity() {
		return city;
	}
	
	
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getProvince() {
		return province;
	}
	
	
	public void setProvince(String province) {
		this.province = province;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [city=" + city + ", province=" + province + "]";
	}
	
	
	
	
}
