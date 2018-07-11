package com.clothing.bean;

public class User {
	private Integer userId;
	private String userName;
	private String userPass;
	private String realName;
	private String userSex;
	private String userMobil;
	
	
	
	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPass() {
		return userPass;
	}



	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}



	public String getRealName() {
		return realName;
	}



	public void setRealName(String realName) {
		this.realName = realName;
	}



	public String getUserSex() {
		return userSex;
	}



	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}



	public String getUserMobil() {
		return userMobil;
	}



	public void setUserMobil(String userMobil) {
		this.userMobil = userMobil;
	}

	

	public User(Integer userId, String userName, String userPass, String realName, String userSex, String userMobil) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.realName = realName;
		this.userSex = userSex;
		this.userMobil = userMobil;
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", realName=" + realName
				+ ", userSex=" + userSex + ", userMobil=" + userMobil + "]";
	}



	public User(){
		
	}
}
