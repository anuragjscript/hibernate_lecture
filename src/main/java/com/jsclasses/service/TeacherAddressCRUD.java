package com.jsclasses.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsclasses.model.TeacherAddress;
import com.jsclasses.util.HibernateUtil;

public class TeacherAddressCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public TeacherAddressCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
    
public TeacherAddress fetchAddressById(int addressId) {
		
		TeacherAddress address = null;
		
		try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            address = session.get(TeacherAddress.class, addressId);
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
            TeacherAddress addressFromDB = session.get(TeacherAddress.class, addressId);
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
