package com.te.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.dao.StudentDao;
import com.te.springboot.dto.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public Student insert(Student bean) {
		return dao.save(bean);

	}

	@Override
	public List<Student> searchAll() {
		List<Student> list = new ArrayList<Student>();
		dao.findAll().forEach(data -> list.add(data));
		return list;
		
	}

	@Override
	public Student search(int userId) {
		
		return dao.findById(userId).get();
	}

	@Override
	public Student update(Student bean) {
		Optional<Student> info2 = this.dao.findById(bean.getUserId());
		if (info2.isPresent()) {
			Student bean1 = info2.get();
			bean1.setName(bean.getName());
			bean1.setGrade(bean.getGrade());
			bean1.setEmail(bean.getEmail());
			bean1.setMarks(bean.getMarks());
			
			dao.save(bean1);
			return bean1;
		} else {
			System.out.println("Not Updated");
		}
		return null;
	}

	@Override
	public void remove(int userId) {
		dao.deleteById(userId);
		
		
	}

	@Override
	public double aggregateMarks() {
		
		return dao.aggregatemarks();
	}

	@Override
	public String grade() {
		
		return dao.grade();
	}



	
	
	
}







