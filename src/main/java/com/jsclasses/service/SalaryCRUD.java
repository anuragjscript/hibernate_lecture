package com.jsclasses.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jsclasses.model.Staff;
import com.jsclasses.util.HibernateUtil;

public class SalaryCRUD {
	
	private final SessionFactory sessionFactory;
    private Session session;

    public SalaryCRUD(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
	
	public String getStaffBySalary(int salaryId) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Staff staff = session.get(Staff.class, salaryId);
		session.getTransaction().commit();
		session.close();
		return staff.getName();
	}

}
