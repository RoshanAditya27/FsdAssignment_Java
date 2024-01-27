package com.hexaware.hibernates.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hexaware.hibernates.entity.Student;
import com.hexaware.hibernates.util.HibernateUtil;

public class StudentDaoImp implements IStudentDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction trx;
	@Override
	public void insertStudent(Student student) {
		Transaction trx = session.beginTransaction();
		session.save(student);
		
		trx.commit();

	}

	@Override
	public void updateStudent(int rollno, int marks) {
		trx = session.beginTransaction();
		Query query = session.createNamedQuery("updateStudent");
		query.setParameter("newMarks", marks);
		query.setParameter("rollno", rollno);
		
		int count = query.executeUpdate();
		trx.commit();
		System.out.println("No. of rows updated: " + count);

	}

	@Override
	public void deleteStudent(int rollno) {
		trx = session.beginTransaction();
		Query query = session.createNamedQuery("deleteStudent");
		query.setParameter("rollno", rollno);
		
		int count = query.executeUpdate();
		trx.commit();
		
		System.out.println("No. of rows deleted: " + count);
		
	}

	@Override
	public List<Student> getAllStudents() {
		Query query = session.createNamedQuery("getAllStudents");
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public Student getStudentById(int rollno) {
		Query query = session.createNamedQuery("getStudentById");
		query.setParameter("rollno", rollno);
		
		Student student = (Student) query.getSingleResult();
		return student;
	}

}
