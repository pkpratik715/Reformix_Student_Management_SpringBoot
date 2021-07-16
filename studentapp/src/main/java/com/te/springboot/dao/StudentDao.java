package com.te.springboot.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.te.springboot.dto.Student;

public interface StudentDao extends CrudRepository<Student, Integer> {
	@Query("SELECT AVG(marks) FROM Student")
	public double aggregatemarks();
	@Query("SELECT grade from Student WHERE marks>(SELECT AVG(marks) FROM Student)")
	public String grade();
}

