package com.jsclasses.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsclasses.model.Staff;
import com.jsclasses.util.HibernateUtil;

public class StaffCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public StaffCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
    
	public void insertTeacherRecord(Staff staff) {
    	
    	//save the Teacher instance to the database
        try {
            session = sessionFactory.openSession();
            //begin the transaction
            session.beginTransaction();
            //save the teacher instance to the database
            session.save(staff);
            session.getTransaction().commit();
        } catch ( Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
    }
	
	@SuppressWarnings("unchecked")
	public List<Staff> fetchAllStaffs() {
    	
    	List<Staff> staffs = null;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            staffs = session.createQuery("from Staff").list();
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        
        return staffs;
        
    }
	
	public Staff fetchStaffById(int staffId) {
		
		Staff staff = null;
		
		try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            staff = session.get(Staff.class, staffId);
            session.getTransaction().commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		return staff;
		
	}
    
    public boolean deleteStaffById(int staffId){
    	
    	boolean deleted = false;
    	
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Staff staffFromDB = session.get(Staff.class, staffId);
            if( staffFromDB != null ) {
            	session.delete(staffFromDB);
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
