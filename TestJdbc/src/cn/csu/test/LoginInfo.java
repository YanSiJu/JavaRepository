package cn.csu.test;

import java.io.Serializable;
import java.util.Date;

public class LoginInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginInfo() {
		
	}
	
	
	private Long id;
	private String userName;
	private String ip;
	private String city;// 登录地
	private String success;// 是否登录成功
	private Date loginTime;// 登录时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", userName=" + userName + ", ip=" + ip + ", city=" + city + ", success="
				+ success + ", loginTime=" + loginTime + "]";
	}


}
