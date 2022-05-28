package com.jsclasses.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
            Transaction tx = session.beginTransaction();
            //save the teacher instance to the database
            Long result = (Long) session.save(teacher);
            System.out.println("Generated identifier: " + result);
            tx.commit();
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
            Transaction tx = session.beginTransaction();
            teachers = session.createQuery("from Teacher").list();
            tx.commit();
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
            Transaction tx = session.beginTransaction();
            teacher = session.get(Teacher.class, teacherId);
            tx.commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		return teacher;
		
	}
    
    public boolean deleteTeacherById(int teacherId){
    	
    	boolean deleted = false;
    	
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Teacher teacherFromDB = session.get(Teacher.class, teacherId);
            if( teacherFromDB != null ) {
            	session.delete(teacherFromDB);
            	deleted = true;
        	}
            tx.commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
        return deleted;
        
    }
    
    

}
