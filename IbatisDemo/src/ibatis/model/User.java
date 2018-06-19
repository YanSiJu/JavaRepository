package ibatis.model;

public class User {

	public User() {
		
	}
	
	private Integer userId;  
    private String userName;  
    private String password;  
    private String mobile;  
    private String email;  


    
    /**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}



	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	@Override  
    public String toString() {  
        return "User [email=" + email + ", mobile=" + mobile + ", password="  
                + password + ", userId=" + userId + ", userName=" + userName  
                + "]";  
    }  

}
