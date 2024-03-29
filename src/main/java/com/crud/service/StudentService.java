package com.crud.service;

import java.util.List;

import com.crud.entity.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public Student updateStudent(Student student,long id);
	public Student getStudent(long id);
	public List<Student> getAllStudent();
	public void deleteStudent(long id);

}
