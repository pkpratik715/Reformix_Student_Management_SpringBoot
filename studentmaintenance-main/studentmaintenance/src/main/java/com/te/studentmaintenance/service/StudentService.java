package com.te.studentmaintenance.service;

import java.util.List;

import com.te.studentmaintenance.bean.StudentBean;

public interface StudentService {
	
	public StudentBean getStudent(int user_Id);

	public boolean deleteStudent(int  user_Id);

	public List<StudentBean> getAllStudents();

	public boolean addStudent(StudentBean bean);

	public boolean updateStudent(StudentBean bean);

}
