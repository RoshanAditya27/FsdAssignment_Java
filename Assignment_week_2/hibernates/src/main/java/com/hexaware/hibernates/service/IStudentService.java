package com.hexaware.hibernates.service;

import java.util.List;

import com.hexaware.hibernates.entity.Student;

public interface IStudentService {
	public void insertStudent(Student student);
	public void updateStudent(int rollno, int marks);
	public void deleteStudent(int rollno);
	
	public List<Student> getAllStudents();
	public Student getStudentById(int rollno);
}
