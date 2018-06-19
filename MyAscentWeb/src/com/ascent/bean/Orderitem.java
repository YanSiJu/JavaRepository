package com.ascent.bean;

/**
 * ������������Ϣ����
 * @author zy
 */
@SuppressWarnings("serial")
public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer id; //�������

	private Integer ordersid; //������ö���ID

	private Integer productid; //���������ƷID

	private String quantity; //ÿ����Ʒ����������

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