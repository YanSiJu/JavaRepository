package com.ascent.bean;

/**
 * �����ʼ���Ϣ����
 * @author zy
 */
@SuppressWarnings("serial")
public class Mailtb implements java.io.Serializable {

	// Fields

	private Integer id; // �����ʼ���ID

	private String fromaddress; // �������ʼ���ַ

	private String frompassword; // �������ʼ�����

	private String toaddress; // �������ʼ���ַ

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