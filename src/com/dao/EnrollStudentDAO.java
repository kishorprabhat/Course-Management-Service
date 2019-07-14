package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.bean.Course;
import com.bean.Student;
import com.entity.CourseEntity;
import com.entity.StudentEntity;



@Component
public class EnrollStudentDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public String enrollStudent(Student stud) {
		StudentEntity studEntity = new StudentEntity();
		CourseEntity courseEntity = em.find(CourseEntity.class, stud.getCoursecode());
		studEntity.setCoursetype(stud.getCoursetype()[0]);
		studEntity.setCourse(courseEntity);
		studEntity.setGender(stud.getGender());
		studEntity.setStudentName(stud.getStudentName());
		em.persist(studEntity);
		String enrollNo = "STD00"+studEntity.getEnrollNumber();
		System.out.println(enrollNo);
		return enrollNo;
	}

	public String retrieveCourseType (String courseCode) {		
		CourseEntity courseEntity = em.find(CourseEntity.class, courseCode);
		return courseEntity.getCoursetype();
	}
	
	@Transactional
	public List<Course> getCourseDetails(){
		Query query = em.createQuery("select c from CourseEntity c");
		List<CourseEntity> cEntityList = query.getResultList();
		List<Course> courseList = new ArrayList<Course>();
		for(CourseEntity ce : cEntityList) {
			Course course = new Course();
			course.setCoursecode(ce.getCoursecode());
			course.setCoursefees(ce.getCoursefees());
			course.setCoursename(ce.getCoursename());
			course.setCoursetype(ce.getCoursetype());
			courseList.add(course);
		}
		return courseList;
	}
}
