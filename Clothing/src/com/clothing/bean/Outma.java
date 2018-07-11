package com.clothing.bean;

public class Outma {
	private int outmaId;
	private String outmaName;
	
	
	
	public int getOutmaId() {
		return outmaId;
	}



	public void setOutmaId(int outmaId) {
		this.outmaId = outmaId;
	}



	public String getOutmaName() {
		return outmaName;
	}



	public void setOutmaName(String outmaName) {
		this.outmaName = outmaName;
	}

	

	public Outma(int outmaId, String outmaName) {
		super();
		this.outmaId = outmaId;
		this.outmaName = outmaName;
	}

	public Outma(){
		
	}

	@Override
	public String toString() {
		return "Outma [outmaId=" + outmaId + ", outmaName=" + outmaName + "]";
	}
	
}
