package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;

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
            Transaction tx = session.beginTransaction();
            //save the teacher instance to the database
            Long result = (Long) session.save(student);
            System.out.println("Generated identifier: " + result);
            tx.commit();
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
            Transaction tx = session.beginTransaction();
            students = session.createQuery("from Student").list();
            tx.commit();
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
            Transaction tx = session.beginTransaction();
            student = session.get(Student.class, studentId);
            tx.commit();
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
            Transaction tx = session.beginTransaction();
            Student studentFromDB = session.get(Student.class, studentId);
            if( studentFromDB != null ) {
            	session.delete(studentFromDB);
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
