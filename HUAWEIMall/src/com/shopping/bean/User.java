package com.shopping.bean;

public class User {
	//用户id
	private int id;
	//手机号码
	private String tel;
	//用户名
	private String userName;
	//密码
	private String password;
	//收货地址
	private String address;
	//用户姓名
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id, String tel, String userName, String password, String address, String name) {
		super();
		this.id = id;
		this.tel = tel;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.name = name;
	}
	public User(){
		
	}
}
