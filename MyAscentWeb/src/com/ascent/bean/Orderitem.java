package com.ascent.bean;

/**
 * 描述订单项信息的类
 * @author zy
 */
@SuppressWarnings("serial")
public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer id; //主键编号

	private Integer ordersid; //外键引用订单ID

	private Integer productid; //外键引用商品ID

	private String quantity; //每个商品所购买数量

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** full constructor */
	public Orderitem(Integer ordersid, Integer productid, String quantity) {
		super();
		this.ordersid = ordersid;
		this.productid = productid;
		this.quantity = quantity;
	}
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(Integer ordersid) {
		this.ordersid = ordersid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}