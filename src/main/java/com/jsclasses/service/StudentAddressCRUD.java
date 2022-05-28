package com.jsclasses.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsclasses.model.StudentAddress;
import com.jsclasses.util.HibernateUtil;

public class StudentAddressCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public StudentAddressCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public StudentAddress fetchAddressById(int addressId) {
		
		StudentAddress address = null;
		
		try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            address = session.get(StudentAddress.class, addressId);
            tx.commit();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
		return address;
		
	}

    
	public boolean deleteAddressById(int addressId) {
		
		boolean deleted = false;
		
		try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            StudentAddress addressFromDB = session.get(StudentAddress.class, addressId);
            if( addressFromDB != null ) {
            	session.delete(addressFromDB);
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
