package com.ascent.bean;

import java.util.Date;

/**
 * 描述订单信息的类
 * @author zy
 */
@SuppressWarnings("serial")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer id; //订单ID

	private Integer usrid;//用户ID
	
	private String ordernumber;//订单编号
	
	private Date createtime; //订单创建时间
	
	private String delsoft; //软删除标志1为软删除，0为正常

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