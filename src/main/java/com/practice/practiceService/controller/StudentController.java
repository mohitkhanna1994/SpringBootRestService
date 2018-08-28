package com.practice.practiceService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.practiceService.bizManager.StudentBiz;
import com.practice.practiceService.exception.StudentServiceException;
import com.practice.practiceService.service.StudentService;
import com.practiceService.model.Student;
import com.practiceService.model.StudentDetail;

@RestController
@RequestMapping("/practice")
@EnableAutoConfiguration
public class StudentController implements StudentService {

	@Autowired
	public StudentBiz studentBiz;
	
	public List<Student> getStudentId() throws StudentServiceException {
		System.out.println("studentIdCalled::");
		return studentBiz.getStudentId();
	}

	public String postStudent(@RequestBody StudentDetail studentDetail) throws StudentServiceException {
		System.out.println("PostServiceCalleed::" +studentDetail);
		return studentBiz.postStudent(studentDetail);
	}
	
}
