package com.ascent.bean;

/**
 * �����û������Ʒ���Զ��ϵ
 * @author zy
 */
@SuppressWarnings("serial")
public class UserProduct implements java.io.Serializable {

	// Fields

	private Integer id;//�������

	private Integer usrid;//���,�����û�id

	private Integer productid;//���,������Ʒid

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