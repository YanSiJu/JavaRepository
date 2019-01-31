package cn.ccsu.entity;

/**
* @author Bill
* @title: Station.java
* @Package: cn.ccsu.entity
* @Description: TODO
* @date:2019年1月31日 下午12:58:09
* @version:V1.0
*/
public class Station {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Station(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
