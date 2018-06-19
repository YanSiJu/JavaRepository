package cn.ccsu.bean;

import java.sql.Date;

public class Duty {

	private Integer doctorId;
	private Date date;
	private String time;
	private Integer totalNumber;		//总共可预约的人数
	private Integer number;				//已经预约的人数
	
	
	/**
	 * @return the doctorId
	 */
	public Integer getDoctorId() {
		return doctorId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Duty [doctorId=" + doctorId + ", date=" + date + ", time=" + time + ", totalNumber=" + totalNumber
				+ ", number=" + number + "]";
	}



	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}



	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}



	/**
	 * @return the totalNumber
	 */
	public Integer getTotalNumber() {
		return totalNumber;
	}



	/**
	 * @param totalNumber the totalNumber to set
	 */
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}



	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}



	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}



	public Duty() {
		
	}

}
