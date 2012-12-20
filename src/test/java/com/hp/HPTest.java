package com.hp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hp.dto.UserDetails;

@RunWith(JUnit4.class)
public class HPTest {

	@Test
	public void executeHibernate() {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setUserName("First User");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}
	
}
