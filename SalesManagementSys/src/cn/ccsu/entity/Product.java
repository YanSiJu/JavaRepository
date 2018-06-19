package cn.ccsu.entity;

/**
 * @author Bill
 *
 */
public class Product {

	private String productName;
	private Integer id;
	private double price;

	public Product() {

	}

	public Product(String productName, Integer id, double price) {
		super();
		this.productName = productName;
		this.id = id;
		this.price = price;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", id=" + id + ", price=" + price + "]";
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
