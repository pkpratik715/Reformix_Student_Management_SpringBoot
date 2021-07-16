package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.dto.Student;
import com.te.springboot.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/insertData")
	public int insertData(@RequestBody Student bean) {

		service.insert(bean);
		return bean.getUserId();

	}

	@GetMapping("/searchAll")
	public List<Student> searchAll() {
		return service.searchAll();
	}

	@GetMapping("/search/{userId}")
	public Student search(@PathVariable("userId") int userId) {
		return service.search(userId);
	}

	@PutMapping("/update/{userId}")
	public Student update(@PathVariable("userId") int eid, @RequestBody Student info) {
		return service.update(info);
	}

	@DeleteMapping("/remove/{userId}")
	public void remove(@PathVariable("userId") int userId) {
		service.remove(userId);

	}
	@GetMapping("/avg")
	public double avg() {
		return service.aggregateMarks();
		}
	@GetMapping("/grade")
	public String grade() {
		return service.grade();
	}
}
