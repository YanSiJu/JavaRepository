package com.ascent.bean;

/**
 * 描述用户信息的类
 * @author zy
 */
@SuppressWarnings("serial")
public class Usr implements java.io.Serializable {
	
	// Fields
	
	private Integer id;//用户ID

	private String username;//用户名

	private String password;//密码
	
	private String fullname;//用户全称
	
	private String title;//职称级别

	private String companyname;//公司名称
	
	private String companyaddress;//公司地址

	private String city;//城市

	private String job;//工作职位

	private String tel;//联系电话

	private String email;//电子邮件

	private String country;//国家

	private String zip;//邮政编号
	
	private String superuser;//用户角色权限3高级管理员,2管理员,1普通用户
	
	private String delsoft;//软删除标志1软删除,0正常

	private String note;//备注
	
	
	// Constructors

	/** default constructor */
	public Usr(){
		
	}

	/** full constructor */
	public Usr(String username, String password, String fullname, String title,
			String companyname, String companyaddress, String city, String job,
			String tel, String email, String country, String zip,
			String superuser, String delsoft, String note) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.title = title;
		this.companyname = companyname;
		this.companyaddress = companyaddress;
		this.city = city;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.country = country;
		this.zip = zip;
		this.superuser = superuser;
		this.delsoft = delsoft;
		this.note = note;
	}
	
	// Property accessors
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSuperuser() {
		return superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}

	public String getDelsoft() {
		return delsoft;
	}

	public void setDelsoft(String delsoft) {
		this.delsoft = delsoft;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
