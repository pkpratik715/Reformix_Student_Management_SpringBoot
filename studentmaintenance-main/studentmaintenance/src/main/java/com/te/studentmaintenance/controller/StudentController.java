package com.te.studentmaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.studentmaintenance.bean.StudentBean;
import com.te.studentmaintenance.bean.StudentResponse;
import com.te.studentmaintenance.service.StudentService;



@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse getAll() {
		StudentResponse response = new StudentResponse();
		List<StudentBean> studentBeans = service.getAllStudents();
		if (studentBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");
			response.setBeans(studentBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}

	@GetMapping(path = "/getStudent", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse getStudent(int user_Id) {
		StudentBean studentBeans = service.getStudent(user_Id);
		StudentResponse response = new StudentResponse();
		if (studentBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data found for id : " + user_Id);
			response.setBean(studentBeans);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Error Data Not found");
		}
		return response;
	}// end of getEmp

	@DeleteMapping(path = "/delete/{user_Id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse deleteStudent(@PathVariable(name = "user_Id") int user_Id) {
		StudentResponse response = new StudentResponse();
		if (service.deleteStudent(user_Id)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data Deleted for id : " + user_Id);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription(" Data Not for id : " + user_Id);
		}

		return response;
	}//

	@PostMapping(path = "/addStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse addStudent(@RequestBody StudentBean bean) {
		StudentResponse response = new StudentResponse();
		if (service.addStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse updateStudent(@RequestBody StudentBean bean) {
		System.out.println(bean);
		StudentResponse response = new StudentResponse();
		if (service.updateStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}

}
