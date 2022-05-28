package com.jsclasses.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsclasses.model.Course;
import com.jsclasses.model.Teacher;
import com.jsclasses.util.HibernateUtil;

public class CourseCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public CourseCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
    
	public Course insertCourseRecord(Course course, int teacherId) {
    	
    	//save the student instance to the database
        try {
            session = sessionFactory.openSession();      
            //begin the transaction
            Transaction tx = session.beginTransaction();
            
            // fetch teacher by id
            Teacher tempTeacher = session.get(Teacher.class, teacherId);
            // add course to teacher
            tempTeacher.add(course);
            
            //save the course instance to the database
            Long result = (Long) session.save(course);
            System.out.println("Generated identifier: " + result);
            tx.commit();
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return course;
        
    }

}
