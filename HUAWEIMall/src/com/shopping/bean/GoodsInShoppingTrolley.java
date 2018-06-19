package com.shopping.bean;

public class GoodsInShoppingTrolley {
	private int shoppingTrolleyId;
	private int goodsId;
	private int quantity;
	private double amount;
	public int getShoppingTrolleyId() {
		return shoppingTrolleyId;
	}
	public void setShoppingTrolleyId(int shoppingTrolleyId) {
		this.shoppingTrolleyId = shoppingTrolleyId;
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
