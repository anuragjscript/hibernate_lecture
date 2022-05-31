package com.jsclasses.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsclasses.model.Course;
import com.jsclasses.model.Teacher;
import com.jsclasses.util.HibernateUtil;

public class TeacherCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public TeacherCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Teacher insertTeacherRecord(Teacher teacher) {
    	
    	//save the Teacher instance to the database
        try {
            session = sessionFactory.openSession();
            //begin the transaction
            session.beginTransaction();
            //save the teacher instance to the database
            session.save(teacher);
            session.getTransaction().commit();
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return teacher;
        
    }
    
	@SuppressWarnings("unchecked")
	public List<Teacher> fetchAllTeachers() {
    	
    	List<Teacher> teachers = null;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            teachers = session.createQuery("from Teacher").list();
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
        return teachers;
        
    }
	
	@SuppressWarnings("unchecked")
	public List<Teacher> fetchAllTeachersWithCourses() {
    	
    	List<Teacher> teachers = null;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            teachers = session.createQuery("from Teacher T LEFT JOIN FETCH T.courses").list();
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
        return teachers;
        
    }
	
	public Teacher fetchTeacherById(int teacherId) {
		
		Teacher teacher = null;
		
		try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId);
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		return teacher;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> fetchAllCoursesByTeacherId(int teacherId) {
		
		List<Course> courses = null;
		
		try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            courses = session.createQuery("from Course C LEFT JOIN FETCH C.teacher where teacher_id = " + teacherId).list();
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		return courses;
		
	}
    
    public boolean deleteTeacherById(int teacherId){
    	
    	boolean deleted = false;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Teacher teacherFromDB = session.get(Teacher.class, teacherId);
            if( teacherFromDB != null ) {
            	session.delete(teacherFromDB);
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
    
    

}
