package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.Course;
import com.bean.Student;
import com.dao.EnrollStudentDAO;
import com.exception.StudentEnrollmentException;

@Component
public class EnrollStudentService {
	@Autowired
	EnrollStudentDAO dao;
	
	public String enrollStudent(Student stud) throws Exception {
		String enrollNo = null;
		String courseType = dao.retrieveCourseType(stud.getCoursecode());
		if(courseType.equalsIgnoreCase("Both")) {
			if(stud.getCoursetype().length == 2) 
				stud.getCoursetype()[0] = "Both";
			enrollNo = dao.enrollStudent(stud);
		}
		else if(courseType.equalsIgnoreCase(stud.getCoursetype()[0]) && stud.getCoursetype().length == 1) {
			System.out.println(stud.getCoursetype()[0]);
			enrollNo = dao.enrollStudent(stud);
		}
		else {
			throw new StudentEnrollmentException();
		}
		return enrollNo;
	}
	
	public List<Course> getCourseDetails(){
		return dao.getCourseDetails();
	}
}
