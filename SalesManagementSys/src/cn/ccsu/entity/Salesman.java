package cn.ccsu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Bill
 *
 */
public class Salesman {

	private String name;
	private Integer id;
	private String sex;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
 
	public Salesman(String name, Integer id, String sex, Date birth) {
		super();
		this.name = name;
		this.id = id;
		this.sex = sex;
		this.birth = birth;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Salesman [name=" + name + ", id=" + id + ", sex=" + sex + ", birth=" + birth + "]";
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Salesman() {

	}

}
