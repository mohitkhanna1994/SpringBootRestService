package com.practice.practiceService.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.practiceService.exception.StudentServiceException;
import com.practiceService.model.Student;
import com.practiceService.model.StudentDetail;

public interface StudentService {

	@CrossOrigin
	@RequestMapping(value = "/getStudentId", consumes = "application/json", produces = "application/json", method = {
			RequestMethod.GET })
	@ResponseBody
	public List<Student> getStudentId() throws StudentServiceException;
	
	@CrossOrigin
	@RequestMapping(value = "/student", consumes = "application/json", produces = "text/plain", method = { RequestMethod.POST })
	@ResponseBody
	public String postStudent(@RequestBody StudentDetail studentDetail) throws StudentServiceException; 
	
}
