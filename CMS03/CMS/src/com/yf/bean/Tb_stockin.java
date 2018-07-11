package com.yf.bean;

import java.util.Date;

public class Tb_stockin {
  private int stockin_id;
  private int ware_id;
  private int user_id;
  private Date stockin_date;
  private String stockin_remark;
public int getStockin_id() {
	return stockin_id;
}
public void setStockin_id(int stockin_id) {
	this.stockin_id = stockin_id;
}
public int getWare_id() {
	return ware_id;
}
public void setWare_id(int ware_id) {
	this.ware_id = ware_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public Date getStockin_date() {
	return stockin_date;
}
public void setStockin_date(Date stockin_date) {
	this.stockin_date = stockin_date;
}
public String getStockin_remark() {
	return stockin_remark;
}
public void setStockin_remark(String stockin_remark) {
	this.stockin_remark = stockin_remark;
}
}
