package com.ascent.bean;

import java.util.Date;

/**
 * ����������Ϣ����
 * @author zy
 */
@SuppressWarnings("serial")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer id; //����ID

	private Integer usrid;//�û�ID
	
	private String ordernumber;//�������
	
	private Date createtime; //��������ʱ��
	
	private String delsoft; //��ɾ����־1Ϊ��ɾ����0Ϊ����

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Integer usrid, String ordernumber, Date createtime,
			String delsoft) {
		super();
		this.usrid = usrid;
		this.ordernumber = ordernumber;
		this.createtime = createtime;
		this.delsoft = delsoft;
	}

	// Property accessors
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsrid() {
		return usrid;
	}

	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDelsoft() {
		return delsoft;
	}

	public void setDelsoft(String delsoft) {
		this.delsoft = delsoft;
	}

}