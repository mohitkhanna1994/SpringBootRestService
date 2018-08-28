package com.practice.practiceService.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.practiceService.bizManager.StudentBiz;
import com.practice.practiceService.constant.StudentConstant;
import com.practice.practiceService.dao.impl.StudentDao;
import com.practice.practiceService.exception.StudentServiceException;
import com.practiceService.model.Student;
import com.practiceService.model.StudentDetail;

@Service
public class StudentBizImpl implements StudentBiz {

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getStudentId() throws StudentServiceException {
		return studentDao.getStudentId();
	}

	public String postStudent(StudentDetail studentDetail) throws StudentServiceException {
		if( studentDao.postStudent(studentDetail) == StudentConstant.QUERY_STATUS_CODE_SUCCESS) 
			return StudentConstant.STATUS_SUCCESS;
		else
			return StudentConstant.STATUS_FAIL;
	}

}
