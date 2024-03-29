package com.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.entity.Student;
import com.crud.exception.StudentNotFoundException;
import com.crud.repo.StudentRepo;
import com.crud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		
		return this.studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		Student student2 = this.studentRepo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with id "+id+" is not found"));
		student2.setFirstName(student.getFirstName());
		student2.setLastName(student.getLastName());
		student2.setEmail(student.getEmail());
		student2.setMobile(student.getMobile());
		student2.setAddress(student.getAddress());
		return this.studentRepo.save(student2);
	}

	@Override
	public Student getStudent(long id) {
		// TODO Auto-generated method stub
		return this.studentRepo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with id "+id+" is not found"));
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> students = this.studentRepo.findAll();
		return students;
	}

	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		
		this.studentRepo.deleteById(id);
		
	}

}
