package com.shopping.bean;

public class GoodsInOrder {
	private int orderFormId;
	private int goodsId;
	private int quantity;
	private double amount;
	public int getOrderFormId() {
		return orderFormId;
	}
	public void setOrderFormId(int orderFormId) {
		this.orderFormId = orderFormId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
