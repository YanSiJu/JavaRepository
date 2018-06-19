package cn.csu.bean;

public class Student {

	
	public Student(String sno, String name, String classNo, double grade) {
		super();
		this.sno = sno;
		this.name = name;
		this.classNo = classNo;
		this.grade = grade;
	}
	private String sno;
	private String name;
	private String classNo;
	private double grade;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [classNo=" + classNo + ", grade=" + grade + ", name="
				+ name + ", sno=" + sno + "]";
	}
	
	
	
	
	
}
