package com.practice.practiceService.bizManager;

import java.util.List;

import com.practice.practiceService.exception.StudentServiceException;
import com.practiceService.model.Student;
import com.practiceService.model.StudentDetail;

public interface StudentBiz {

	public List<Student> getStudentId() throws StudentServiceException;
	
	public String postStudent(StudentDetail studentDetail) throws StudentServiceException;
}
