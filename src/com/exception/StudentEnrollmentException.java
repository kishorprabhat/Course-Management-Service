package com.exception;

public class StudentEnrollmentException extends Exception {

	public StudentEnrollmentException() {
		super("Selected coursetype is not available for the given course");
	}
	
}
