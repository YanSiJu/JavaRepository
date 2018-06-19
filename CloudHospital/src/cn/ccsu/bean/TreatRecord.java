package cn.ccsu.bean;

import java.sql.Date;

public class TreatRecord {

	private Integer doctorId;
	private Integer patientId;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreatRecord [doctorId=" + doctorId + ", patientId=" + patientId + ", treatDate=" + treatDate
				+ ", reason=" + reason + ", solution=" + solution + "]";
	}

	/**
	 * @return the doctorId
	 */
	public Integer getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the patientId
	 */
	public Integer getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the treatDate
	 */
	public Date getTreatDate() {
		return treatDate;
	}

	/**
	 * @param treatDate the treatDate to set
	 */
	public void setTreatDate(Date treatDate) {
		this.treatDate = treatDate;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	private Date treatDate;
	private String reason;	//≤°“Ú
	private String solution;

	public TreatRecord() {

	}

}
