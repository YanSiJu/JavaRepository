package cn.ccsu.entity;

/**
 * @author Bill
 *
 */
public class MonthlyRecord {

	// 流水号
	private Integer recordId;
	// 产品号
	private Integer productId;
	// 销售员编号
	private Integer salesmanId;
	// 销售数量
	private Integer number;

	/**
	 * @return the recordId
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * @param recordId
	 *            the recordId to set
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	// 销售额
	private Double saleroom;
	// 月份
	private String month;

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	public MonthlyRecord(Integer recordId, Integer productId, Integer salesmanId, Integer number, Double saleroom,
			String month) {
		super();
		this.recordId = recordId;
		this.productId = productId;
		this.salesmanId = salesmanId;
		this.number = number;
		this.saleroom = saleroom;
		this.month = month;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MonthlyRecord [recordId=" + recordId + ", productId=" + productId + ", salesmanId=" + salesmanId
				+ ", number=" + number + ", saleroom=" + saleroom + ", month=" + month + "]";
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the salesmanId
	 */
	public Integer getSalesmanId() {
		return salesmanId;
	}

	/**
	 * @param salesmanId
	 *            the salesmanId to set
	 */
	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the saleroom
	 */
	public Double getSaleroom() {
		return saleroom;
	}

	/**
	 * @param saleroom
	 *            the saleroom to set
	 */
	public void setSaleroom(Double saleroom) {
		this.saleroom = saleroom;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	public MonthlyRecord() {

	}

}
