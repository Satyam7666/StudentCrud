package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class Controller {
	@Autowired
	private StudentServiceImpl studentService;
	
	@PostMapping("/add")
	public Student createStudent(@RequestBody Student student) {
		
		return studentService.createStudent(student);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable long id) {
		
		return this.studentService.updateStudent(student, id);
	}
	
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable long id) {
		return this.studentService.getStudent(id);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudents(){
		
		return this.studentService.getAllStudent();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable long id) {
		this.studentService.deleteStudent(id);
	}
		
	
	
	
	
	
	

}
