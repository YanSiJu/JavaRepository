package cn.ccsu.entity;

/**
 * @author Bill
 *
 */
public class ProductMonthlyRecord implements Comparable<ProductMonthlyRecord> {

	// 产品编号
	private Integer productId;
	// 月销售总额
	private Double monthlySaleroom;
	// 月份
	private String month;
	// 产品名
	private String productName;

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductMonthlyRecord [productId=" + productId + ", monthlySaleroom=" + monthlySaleroom + ", month="
				+ month + ", productName=" + productName + "]";
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductMonthlyRecord(Integer productId, Double monthlySaleroom, String month, String productName) {
		super();
		this.productId = productId;
		this.monthlySaleroom = monthlySaleroom;
		this.month = month;
		this.productName = productName;
	}

	/**
	 * @return the monthlySaleroom
	 */
	public Double getMonthlySaleroom() {
		return monthlySaleroom;
	}

	/**
	 * @param monthlySaleroom
	 *            the monthlySaleroom to set
	 */
	public void setMonthlySaleroom(Double monthlySaleroom) {
		this.monthlySaleroom = monthlySaleroom;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	public ProductMonthlyRecord() {

	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public int compareTo(ProductMonthlyRecord o) {
		return -this.getMonthlySaleroom().compareTo(o.getMonthlySaleroom());
	}

}
