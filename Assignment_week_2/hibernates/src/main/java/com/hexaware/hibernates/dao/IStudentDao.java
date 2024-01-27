package com.hexaware.hibernates.dao;

import java.util.List;

import com.hexaware.hibernates.entity.Student;

public interface IStudentDao {
	public void insertStudent(Student student);
	public void updateStudent(int rollno, int marks);
	public void deleteStudent(int rollno);
	
	public List<Student> getAllStudents();
	public Student getStudentById(int rollno);
	
}
