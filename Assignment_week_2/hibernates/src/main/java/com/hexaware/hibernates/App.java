package com.hexaware.hibernates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.hibernates.entity.Student;
import com.hexaware.hibernates.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student(101, "Roshan", 90);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction trx = session.beginTransaction();
        
        session.save(student);
        
        trx.commit();
        
    }
}
