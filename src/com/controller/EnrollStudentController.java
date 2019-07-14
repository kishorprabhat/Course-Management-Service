package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Course;
import com.bean.Student;
import com.service.EnrollStudentService;

@Controller
public class EnrollStudentController {
	@Autowired
	EnrollStudentService service;
	
	@RequestMapping("/home.htm")
	public ModelAndView displayHomePage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("home");
		return mView;
	}
	
	@RequestMapping("/student.htm")
	public ModelAndView displaystudent() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("student");
		return mView;
	}
	
	@ModelAttribute("CourseNameList")
	public Map<String, String> populateCourse(){
		Map<String, String> courseMap = new HashMap<String, String>();
		List<Course> courseList = service.getCourseDetails();
		for(Course c : courseList) {
			courseMap.put(c.getCoursecode(),c.getCoursename());
		}
		return courseMap;
	}
	
	@RequestMapping("/courseenrollment.htm")
	public ModelAndView loadEnrollPage(ModelMap map) {
		ModelAndView mView = new ModelAndView();
		Student student = new Student();
		map.addAttribute(student);
		mView.setViewName("courseenrollment");
		return mView;
	}
	
	@RequestMapping("/enrollStudent.htm")
	public ModelAndView enrollStudent(@ModelAttribute Student student) {
		ModelAndView mView = new ModelAndView();
		String enrollNo = null;
		String msg = null;
		try {
			enrollNo = service.enrollStudent(student);
			System.out.println(enrollNo+"Cont");
			msg = "Thanks you for Registration. Your enrollment id is ";
			msg+=enrollNo;
			System.out.println(msg);
			mView.setViewName("success");
		} catch (Exception e){
			msg = e.getMessage();
			System.out.println(e.getMessage());
			mView.setViewName("courseenrollment");
		}
		mView.addObject("msg", msg);
		return mView;
	}
	
	@RequestMapping("/viewallcourse.htm")
	public ModelAndView getCourseDetails() {
		ModelAndView mView = new ModelAndView();
		List<Course> courseList = service.getCourseDetails();
		mView.addObject(courseList);
		mView.setViewName("viewallcourse");
		return mView;
	}
}
