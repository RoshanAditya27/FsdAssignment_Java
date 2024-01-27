package com.hexaware.hibernates.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "student_records")

@NamedQueries(
		{
			@NamedQuery(name = "updateStudent", query = "update student_records set s.marks = :newMarks from student_records s where s.rollno = :rollno"),
			@NamedQuery(name = "deleteStudent", query = "delete s from student_records where s.rollno = :rollno"),
			@NamedQuery(name = "getAllStudents", query = "select s from student_records s"),
			@NamedQuery(name = "getStudentById", query = "select s from student_records s where s.rollno = :rollno")
		}
		)
public class Student {
	
	@Id
	private int rollno;
	private String name;
	private int marks;
	
	public Student() {
		
	}

	public Student(int rollno, String name, int marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
}
