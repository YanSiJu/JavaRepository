package com.clothing.bean;

public class Size {
	private Integer sizeId;
	private String sizeName;
	public Integer getSizeId() {
		return sizeId;
	}
	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public Size(Integer sizeId, String sizeName) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
	}
	public Size(){
		
	}
	@Override
	public String toString() {
		return "Size [sizeId=" + sizeId + ", sizeName=" + sizeName + "]";
	}
	
}
