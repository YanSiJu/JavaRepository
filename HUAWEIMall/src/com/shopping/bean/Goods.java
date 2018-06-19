package com.shopping.bean;

public class Goods {
	private int id;
	private String name;
	private String batteryCapacity;
	private String frontFacingCamera;
	private String rearCamera;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getFrontFacingCamera() {
		return frontFacingCamera;
	}
	public void setFrontFacingCamera(String frontFacingCamera) {
		this.frontFacingCamera = frontFacingCamera;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}
	public Goods(int id, String name, String batteryCapacity, String frontFacingCamera, String rearCamera) {
		super();
		this.id = id;
		this.name = name;
		this.batteryCapacity = batteryCapacity;
		this.frontFacingCamera = frontFacingCamera;
		this.rearCamera = rearCamera;
	}
	public Goods() {
		// TODO Auto-generated constructor stub
	}
}
