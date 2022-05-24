package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Address;
import util.HibernateUtil;

public class AddressCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;
    
	public AddressCRUD() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Address fetchAddressById(int addressId) {
		
		Address address = null;
		
		try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            address = session.get(Address.class, addressId);
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
            Address addressFromDB = session.get(Address.class, addressId);
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
