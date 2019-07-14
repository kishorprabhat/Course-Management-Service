package com.bean;

public class Student {
	private String enrollNumber;
	private String studentName;
	private int contact;
	private String coursecode;
	private String gender;
	private String [] coursetype;
	public String getEnrollNumber() {
		return enrollNumber;
	}
	public void setEnrollNumber(String enrollNumber) {
		this.enrollNumber = enrollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String[] coursetype) {
		this.coursetype = coursetype;
	}
}
