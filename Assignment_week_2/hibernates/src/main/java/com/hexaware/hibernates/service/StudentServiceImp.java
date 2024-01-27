package com.hexaware.hibernates.service;

import java.util.List;

import com.hexaware.hibernates.dao.IStudentDao;
import com.hexaware.hibernates.entity.Student;

public class StudentServiceImp implements IStudentService {
	
	IStudentDao studentDao;
	@Override
	public void insertStudent(Student student) {
		studentDao.insertStudent(student);

	}

	@Override
	public void updateStudent(int rollno, int marks) {
		studentDao.updateStudent(rollno, marks);

	}

	@Override
	public void deleteStudent(int rollno) {
		studentDao.deleteStudent(rollno);

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentDao.getAllStudents();
		return list;
	}

	@Override
	public Student getStudentById(int rollno) {
		Student student = studentDao.getStudentById(rollno);
		return student;
	}

}
