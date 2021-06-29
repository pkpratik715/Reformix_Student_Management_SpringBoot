package com.te.studentmaintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.studentmaintenance.bean.StudentBean;
import com.te.studentmaintenance.dao.StudentDAO;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO dao;
	
	@Override
	public StudentBean getStudent(int user_Id) {
		// TODO Auto-generated method stub
		return dao.getStudent(user_Id);
	}

	@Override
	public boolean deleteStudent(int user_Id) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(user_Id);
	}

	@Override
	public List<StudentBean> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

	@Override
	public boolean addStudent(StudentBean bean) {
		// TODO Auto-generated method stub
		return dao.addStudent(bean);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		// TODO Auto-generated method stub
		return dao.updateStudent(bean);
	}

}
