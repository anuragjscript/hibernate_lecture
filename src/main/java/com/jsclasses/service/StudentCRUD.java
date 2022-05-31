package com.jsclasses.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsclasses.model.Course;
import com.jsclasses.model.Student;
import com.jsclasses.util.HibernateUtil;

public class StudentCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;

    public StudentCRUD(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public Student insertStudentRecord(Student student) {
    	
    	//save the student instance to the database
        try {
            session = sessionFactory.openSession();
            //begin the transaction
            session.beginTransaction();
            //save the student instance to the database
            session.save(student);
            session.getTransaction().commit();
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return student;
        
    }
    
	@SuppressWarnings("unchecked")
	public List<Student> fetchAllStudents() {
    	
    	List<Student> students = null;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            students = session.createQuery("from Student").list();
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
        return students;
        
    }
	
	public Student fetchStudentById(int studentId) {
		
		Student student = null;
		
		try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            student = session.get(Student.class, studentId);
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		return student;
		
	}
    
    public boolean deleteStudentById(int studentId){
    	
    	boolean deleted = false;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Student studentFromDB = session.get(Student.class, studentId);
            if( studentFromDB != null ) {
            	session.delete(studentFromDB);
            	deleted = true;
        	}
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
        return deleted;
        
    }
    
    public void updateStudentRecord(int studentId, int courseId) {
    	
    	//save the student instance to the database
        try {
        	
            session = sessionFactory.openSession();
            //begin the transaction
            session.beginTransaction();
            
            Student student = session.get(Student.class, studentId);
        	Course course = session.get(Course.class, courseId);
        	
        	student.setCourses(course);
        	course.setStudents(student);
                	
                	
            //save the student instance to the database
            session.update(student);
            session.update(course);
            
            session.getTransaction().commit();
            
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
    }
    
}
