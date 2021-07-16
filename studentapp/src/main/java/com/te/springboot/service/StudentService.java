package com.te.springboot.service;

import java.util.List;

import com.te.springboot.dto.Student;

public interface StudentService {
   public Student insert(Student bean);
   public List<Student> searchAll();
   public Student search(int userId);
   public Student update(Student bean);
   public void remove(int userId);
  public double aggregateMarks();
  public String grade();
}
