package com.yf.bean;

import java.util.Date;

public class Tb_stockout {
	private int stockout_id;
	private int user_id;
	private int ware_id;
	private int client_id;
	private String stockout_remark;
	private Date stockout_date;

	public int getStockout_id() {
		return stockout_id;
	}

	public void setStockout_id(int stockout_id) {
		this.stockout_id = stockout_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getWare_id() {
		return ware_id;
	}

	public void setWare_id(int ware_id) {
		this.ware_id = ware_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getStockout_remark() {
		return stockout_remark;
	}

	public void setStockout_remark(String stockout_remark) {
		this.stockout_remark = stockout_remark;
	}

	public Date getStockout_date() {
		return stockout_date;
	}

	public void setStockout_date(Date stockout_date) {
		this.stockout_date = stockout_date;
	}
}
