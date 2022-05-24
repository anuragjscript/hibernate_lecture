package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.Student;

public class HibernateUtil {
	
private static SessionFactory sessionFactory = null;
	
    public static final SessionFactory getSessionFactory(){
    	
        if (sessionFactory == null) {
           sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
    				.addAnnotatedClass(Address.class)
                    .buildSessionFactory();
        }
        
        return sessionFactory;
        
    }

}
