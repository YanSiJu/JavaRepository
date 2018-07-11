package com.clothing.bean;

public class Client {
	private int clientId;
	private String clientName;
	private String clientPhone;
	private String clientAddress;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientNameAddress() {
		return clientName;
	}
	public void setClientNameAddress(String clientNameAddress) {
		this.clientName = clientNameAddress;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public Client(int clientId, String clientName, String clientPhone, String clientAddress) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientPhone = clientPhone;
		this.clientAddress = clientAddress;
	}
	
	public Client(){
		
	}
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientPhone="
				+ clientPhone + ", clientAddress=" + clientAddress + "]";
	}
	
	
	
}
