package com.clothing.bean;

import java.sql.Date;

public class StockOut {
	private int stockOutId;
	private int userId;
	private int wareId;
	private int clientId;
	private Date stockOutDate;
	private String stockOutRemark;
	public int getStockOutId() {
		return stockOutId;
	}
	public void setStockOutId(int stockOutId) {
		this.stockOutId = stockOutId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWareId() {
		return wareId;
	}
	public void setWareId(int wareId) {
		this.wareId = wareId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Date getStockOutDate() {
		return stockOutDate;
	}
	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}
	public String getStockOutRemark() {
		return stockOutRemark;
	}
	public void setStockOutRemark(String stockOutRemark) {
		this.stockOutRemark = stockOutRemark;
	}
	public StockOut(int stockOutId, int userId, int wareId, int clientId, Date stockOutDate, String stockOutRemark) {
		super();
		this.stockOutId = stockOutId;
		this.userId = userId;
		this.wareId = wareId;
		this.clientId = clientId;
		this.stockOutDate = stockOutDate;
		this.stockOutRemark = stockOutRemark;
	}
	public StockOut(){
		
	}
	
	@Override
	public String toString() {
		return "StockOut [stockOutId=" + stockOutId + ", userId=" + userId + ", wareId=" + wareId + ", clientId="
				+ clientId + ", stockOutDate=" + stockOutDate + ", stockOutRemark=" + stockOutRemark + "]";
	}
	
}
