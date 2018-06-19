package com.ascent.bean;

/**
 * 描述用户表与产品表多对多关系
 * @author zy
 */
@SuppressWarnings("serial")
public class UserProduct implements java.io.Serializable {

	// Fields

	private Integer id;//主键编号

	private Integer usrid;//外键,引用用户id

	private Integer productid;//外键,引用商品id

	// Constructors

	/** default constructor */
	public UserProduct() {
	}

	/** full constructor */
	public UserProduct(Integer usrid, Integer productid) {
		super();
		this.usrid = usrid;
		this.productid = productid;
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

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
}