package com.clothing.bean;

public class StockInDet {
	private int stockInDetId;
	private int stockInId;
	private int stockInDetAccount;
	private int proId;
	public int getStockInDetId() {
		return stockInDetId;
	}
	public void setStockInDetId(int stockInDetId) {
		this.stockInDetId = stockInDetId;
	}
	public int getStockInId() {
		return stockInId;
	}
	public void setStockInId(int stockInId) {
		this.stockInId = stockInId;
	}
	public int getStockInDetAccount() {
		return stockInDetAccount;
	}
	public void setStockInDetAccount(int stockInDetAccount) {
		this.stockInDetAccount = stockInDetAccount;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public StockInDet(int stockInDetId, int stockInId, int stockInDetAccount, int proId) {
		super();
		this.stockInDetId = stockInDetId;
		this.stockInId = stockInId;
		this.stockInDetAccount = stockInDetAccount;
		this.proId = proId;
	}
	
	public StockInDet(){
		
	}
	@Override
	public String toString() {
		return "StockInDet [stockInDetId=" + stockInDetId + ", stockInId=" + stockInId + ", stockInDetAccount="
				+ stockInDetAccount + ", proId=" + proId + "]";
	}
	
}
