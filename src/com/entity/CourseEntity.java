package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseEntity {

	@Id
	private String coursecode;
	private String coursename;
	private double coursefees;
	private String coursetype;
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public double getCoursefees() {
		return coursefees;
	}
	public void setCoursefees(double coursefees) {
		this.coursefees = coursefees;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
		
}
