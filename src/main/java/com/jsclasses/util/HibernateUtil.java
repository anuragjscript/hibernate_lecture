package com.jsclasses.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsclasses.model.StudentAddress;
import com.jsclasses.model.Teacher;
import com.jsclasses.model.TeacherAddress;
import com.jsclasses.model.Course;
import com.jsclasses.model.Review;
import com.jsclasses.model.Staff;
import com.jsclasses.model.Student;

public class HibernateUtil {
	
private static SessionFactory sessionFactory = null;
	
    public static final SessionFactory getSessionFactory(){
    	
        if (sessionFactory == null) {
           sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
    				.addAnnotatedClass(StudentAddress.class)
    				.addAnnotatedClass(Teacher.class)
    				.addAnnotatedClass(TeacherAddress.class)
    				.addAnnotatedClass(Review.class)
    				.addAnnotatedClass(Course.class)
    				.addAnnotatedClass(Staff.class)
                    .buildSessionFactory();
        }
        
        return sessionFactory;
        
    }

}
