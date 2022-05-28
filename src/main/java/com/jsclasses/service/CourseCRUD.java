package com.jsclasses.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsclasses.model.Course;
import com.jsclasses.model.Teacher;
import com.jsclasses.util.HibernateUtil;

public class CourseCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public CourseCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
    
	public void insertCourseRecord(Course course, int teacherId) {
    	
    	//save the student instance to the database
        try {
            session = sessionFactory.openSession();      
            //begin the transaction
            session.beginTransaction();
            
            // fetch teacher by id
            Teacher tempTeacher = session.get(Teacher.class, teacherId);
            // add course to teacher
            tempTeacher.add(course);
            
            //save the course instance to the database
            session.save(tempTeacher);
            session.getTransaction().commit();
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
    }
	
	@SuppressWarnings("unchecked")
	public List<Course> getCourseTeacher(int teacherId) {
		
		List<Course> courses = null;
		
		try {
			session = sessionFactory.openSession();      
            //begin the transaction
            session.beginTransaction();
            //Teacher tempTeacher = session.get(Teacher.class, teacherId);
            courses = session.createQuery("from Course Where teacher_id ='" + teacherId + "'").list();
            session.getTransaction().commit();
		} catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		
		return courses;
	}

}
