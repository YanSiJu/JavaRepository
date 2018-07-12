package com.alibaba.entity;

/**
 * @author Bill
 *
 */
public class User {

	private int userId;
	private String userName;
	private String password;
	private double height;
	private double weight;

	public User(int userId, String userName, String password, double height, double weight, String tel, String sex,
			String icon) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.height = height;
		this.weight = weight;
		this.icon = icon;
		this.tel = tel;
		this.sex = sex;
	}

	private String icon;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", height=" + height
				+ ", weight=" + weight + ", icon=" + icon + ", tel=" + tel + ", sex=" + sex + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		if (icon == null) {
			if (other.icon != null) {
				return false;
			}
		} else if (!icon.equals(other.icon)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (sex == null) {
			if (other.sex != null) {
				return false;
			}
		} else if (!sex.equals(other.sex)) {
			return false;
		}
		if (tel == null) {
			if (other.tel != null) {
				return false;
			}
		} else if (!tel.equals(other.tel)) {
			return false;
		}
		if (userId != other.userId) {
			{
				return false;
			}
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}

		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight)) {
			return false;
		}
		return true;
	}

	private String tel;
	private String sex;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
