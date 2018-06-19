package cn.ccsu.entity;

import java.time.LocalDateTime;

/**
 * @author Bill
 *
 */
public class SalesRecord {

	public SalesRecord(Integer productId, Integer salesmanId, Integer number, Double saleroom, Integer recordId,
			LocalDateTime dateTime) {
		super();
		this.productId = productId;
		this.salesmanId = salesmanId;
		this.number = number;
		this.saleroom = saleroom;
		this.recordId = recordId;
		this.dateTime = dateTime;
	}

	// 产品号
	/**
	 * 
	 */
	private Integer productId;
	// 销售员编号
	/**
	 * 
	 */
	private Integer salesmanId;
	// 销售数量
	/**
	 * 
	 */
	private Integer number;
	// 销售额
	/**
	 * 
	 */
	private Double saleroom;

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SalesRecord [productId=" + productId + ", salesmanId=" + salesmanId + ", number=" + number
				+ ", saleroom=" + saleroom + ", recordId=" + recordId + ", dateTime=" + dateTime + "]";
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	// 流水号
	private Integer recordId;

	// 订单的时间
	private LocalDateTime dateTime;

	public SalesRecord() {

	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
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

}
