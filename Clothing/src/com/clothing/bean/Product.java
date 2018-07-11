package com.clothing.bean;

public class Product {
	private int proId;
	private String proName;
	private int sizeId;
	private int colorId;
	private int outmaId;
	private double proFacPrice;
	private double proRetPrice;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getOutmaId() {
		return outmaId;
	}
	public void setOutmaId(int outmaId) {
		this.outmaId = outmaId;
	}
	public double getProFacPrice() {
		return proFacPrice;
	}
	public void setProFacPrice(double proFacPrice) {
		this.proFacPrice = proFacPrice;
	}
	public double getProRetPrice() {
		return proRetPrice;
	}
	public void setProRetPrice(double proRetPrice) {
		this.proRetPrice = proRetPrice;
	}
	public Product(int proId, String proName, int sizeId, int colorId, int outmaId, double proFacPrice,
			double proRetPrice) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.sizeId = sizeId;
		this.colorId = colorId;
		this.outmaId = outmaId;
		this.proFacPrice = proFacPrice;
		this.proRetPrice = proRetPrice;
	}
	
	public Product(){
		
	}
	
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", sizeId=" + sizeId + ", colorId=" + colorId
				+ ", outmaId=" + outmaId + ", proFacPrice=" + proFacPrice + ", proRetPrice=" + proRetPrice + "]";
	}
	
	
}
