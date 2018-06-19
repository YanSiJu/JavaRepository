package com.ascent.bean;

/**
 * 描述邮件信息的类
 * @author zy
 */
@SuppressWarnings("serial")
public class Mailtb implements java.io.Serializable {

	// Fields

	private Integer id; // 电子邮件表ID

	private String fromaddress; // 发送者邮件地址

	private String frompassword; // 发送者邮件密码

	private String toaddress; // 接收者邮件地址

	// Constructors

	/** default constructor */
	public Mailtb() {
	}

	/** full constructor */
	public Mailtb(String fromaddress, String frompassword, String toaddress) {
		this.fromaddress = fromaddress;
		this.frompassword = frompassword;
		this.toaddress = toaddress;
	}

	// Property accessors
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromaddress() {
		return this.fromaddress;
	}

	public void setFromaddress(String fromaddress) {
		this.fromaddress = fromaddress;
	}

	public String getFrompassword() {
		return this.frompassword;
	}

	public void setFrompassword(String frompassword) {
		this.frompassword = frompassword;
	}

	public String getToaddress() {
		return this.toaddress;
	}

	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
	}
	
}