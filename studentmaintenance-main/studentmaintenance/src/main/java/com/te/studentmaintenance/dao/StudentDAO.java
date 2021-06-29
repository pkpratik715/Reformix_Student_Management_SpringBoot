package com.te.studentmaintenance.dao;

import java.util.List;

import com.te.studentmaintenance.bean.StudentBean;

public interface StudentDAO {
	
	public StudentBean getStudent(int user_Id);

	public boolean deleteStudent(int  user_Id);

	public List<StudentBean> getAllStudents();

	public boolean addStudent(StudentBean bean);

	public boolean updateStudent(StudentBean bean);

}
