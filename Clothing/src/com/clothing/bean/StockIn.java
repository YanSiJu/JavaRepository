package com.clothing.bean;

import java.sql.Date;

public class StockIn {
	private int stockInId;
	private int wareId;
	private int userId;
	private Date stockInDate;
	private String stockInRemark;
	public int getStockInId() {
		return stockInId;
	}
	public void setStockInId(int stockInId) {
		this.stockInId = stockInId;
	}
	public int getWareId() {
		return wareId;
	}
	public void setWareId(int wareId) {
		this.wareId = wareId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getStockInDate() {
		return stockInDate;
	}
	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}
	public String getStockInRemark() {
		return stockInRemark;
	}
	public void setStockInRemark(String stockInRemark) {
		this.stockInRemark = stockInRemark;
	}
	public StockIn(int stockInId, int wareId, int userId, Date stockInDate, String stockInRemark) {
		super();
		this.stockInId = stockInId;
		this.wareId = wareId;
		this.userId = userId;
		this.stockInDate = stockInDate;
		this.stockInRemark = stockInRemark;
	}
	
	public StockIn(){
		
	}
	@Override
	public String toString() {
		return "StockIn [stockInId=" + stockInId + ", wareId=" + wareId + ", userId=" + userId + ", stockInDate="
				+ stockInDate + ", stockInRemark=" + stockInRemark + "]";
	}
	
}
