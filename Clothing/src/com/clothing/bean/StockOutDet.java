package com.clothing.bean;

public class StockOutDet {
	private int stockOutDetId;
	private int stockOutId;
	private int stockOutDetAccount;
	private int proId;
	public int getStockOutDetId() {
		return stockOutDetId;
	}
	public void setStockOutDetId(int stockOutDetId) {
		this.stockOutDetId = stockOutDetId;
	}
	public int getStockOutId() {
		return stockOutId;
	}
	public void setStockOutId(int stockOutId) {
		this.stockOutId = stockOutId;
	}
	public int getStockOutDetAccount() {
		return stockOutDetAccount;
	}
	public void setStockOutDetAccount(int stockOutDetAccount) {
		this.stockOutDetAccount = stockOutDetAccount;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public StockOutDet(int stockOutDetId, int stockOutId, int stockOutDetAccount, int proId) {
		super();
		this.stockOutDetId = stockOutDetId;
		this.stockOutId = stockOutId;
		this.stockOutDetAccount = stockOutDetAccount;
		this.proId = proId;
	}
	
	public StockOutDet(){
		
	}
	
	@Override
	public String toString() {
		return "StockOutDet [stockOutDetId=" + stockOutDetId + ", stockOutId=" + stockOutId + ", stockOutDetAccount="
				+ stockOutDetAccount + ", proId=" + proId + "]";
	}
	
}
