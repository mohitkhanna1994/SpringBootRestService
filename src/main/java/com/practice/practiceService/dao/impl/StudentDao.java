package com.practice.practiceService.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.query.N1qlQuery;
import com.practice.practiceService.constant.StudentConstant;
import com.practice.practiceService.couchBase.config.CouchBaseConnService;
import com.practice.practiceService.exception.StudentServiceException;
import com.practiceService.model.Student;
import com.practiceService.model.StudentDetail;

@Configuration
public class StudentDao extends CouchBaseConnService {

	@Value("${get.student.ids}")
	private String GET_STUDENT_IDS;

	public List<Student> getStudentId() throws StudentServiceException{
		List<Student> studentIds = null;
		try {
		System.out.println("student dao::"+GET_STUDENT_IDS);
		N1qlQuery query = N1qlQuery.simple(GET_STUDENT_IDS);
		studentIds = template.findByN1QL(query, Student.class);
		}catch (Exception e) {
			throw new StudentServiceException();
		}
		return studentIds;
	}
	
	public int postStudent(StudentDetail studentDetail) throws StudentServiceException {
		int response = StudentConstant.QUERY_STATUS_CODE_FAILURE;
		try {
			template.save(studentDetail);
			response = StudentConstant.QUERY_STATUS_CODE_SUCCESS;		
		}catch (Exception e) {
			throw new StudentServiceException();
		}
		return response;
	}
}
