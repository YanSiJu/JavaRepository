package com.clothing.bean;

public class Warehouse {
	private Integer wareId;
	private String wareName;
	private String wareLinkMan;
	private String wareLinkPhone;
	private Integer wareContent;
	public Integer getWareId() {
		return wareId;
	}
	public void setWareId(Integer wareId) {
		this.wareId = wareId;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	public String getWareLinkMan() {
		return wareLinkMan;
	}
	public void setWareLinkMan(String wareLinkMan) {
		this.wareLinkMan = wareLinkMan;
	}
	public String getWareLinkPhone() {
		return wareLinkPhone;
	}
	public void setWareLinkPhone(String wareLinkPhone) {
		this.wareLinkPhone = wareLinkPhone;
	}
	public Integer getWareContent() {
		return wareContent;
	}
	public void setWareContent(Integer wareContent) {
		this.wareContent = wareContent;
	}
	public Warehouse(Integer wareId, String wareName, String wareLinkMan, String wareLinkPhone, Integer wareContent) {
		super();
		this.wareId = wareId;
		this.wareName = wareName;
		this.wareLinkMan = wareLinkMan;
		this.wareLinkPhone = wareLinkPhone;
		this.wareContent = wareContent;
	}
	public Warehouse(){
		
	}
	@Override
	public String toString() {
		return "Warehouse [wareId=" + wareId + ", wareName=" + wareName + ", wareLinkMan=" + wareLinkMan
				+ ", wareLinkPhone=" + wareLinkPhone + ", wareContent=" + wareContent + "]";
	}
	
}
