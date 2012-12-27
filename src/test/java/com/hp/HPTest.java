package com.hp;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hp.dto.Address;
import com.hp.dto.FourWheeler;
import com.hp.dto.Student;
import com.hp.dto.Teacher;
import com.hp.dto.TwoWheeler;
import com.hp.dto.UserDetails;
import com.hp.dto.Vehicle;

@RunWith(JUnit4.class)
public class HPTest {

	@Test
	public void executeHibernate() {
		
		UserDetails userDetails = new UserDetails();
		//userDetails.setId(1);
		userDetails.setUserName("First User");
		//userDetails.setAddress("Address");
		Address address = new Address();
		address.setCity("city");
		address.setPincode("pincode");
		address.setState("state");
		address.setStreet("street");
		userDetails.getAddresses().add(address);
		Address address2 = new Address();
		address2.setCity("city");
		address2.setPincode("pincode");
		address2.setState("state");
		address2.setStreet("street");
		userDetails.getAddresses().add(address2);
		userDetails.setDescirption("Desc");
		userDetails.setJoinedDate(new Date());
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Ritz");
		userDetails.setVehicle(vehicle);
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Steering Handle");
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Porche");
		fourWheeler.setVehicleName("Porsche Steering Wheel");
		
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(userDetails);
		//session.save(userDetails);
		//session.save(vehicle);
		
		session.persist(vehicle1);
		session.persist(twoWheeler);
		session.persist(fourWheeler);
		session.getTransaction().commit();
		session.close();
		
		/*session = sessionFactory.openSession();
		UserDetails user = (UserDetails)session.get(UserDetails.class, 10);
		session.close();
		System.out.println(user.getAddresses());*/
	}
	
	/*@Test
	public void executeStudentDetails() {
		Student st1 = new Student();
		st1.setName("Abdul Sami");
		st1.setCourse("Maths");
		Student st2 = new Student();
		st2.setName("Juveria");
		st2.setCourse("English");
		
		Teacher t1 = new Teacher();
		t1.setCourse("Madiha Fatima");
		t1.setName("Maths");
		Teacher t2 = new Teacher();
		t2.setCourse("English");
		t2.setName("Saiqa Fatima");
		
		st1.getTeachers().add(t1);
		st1.getTeachers().add(t2);
		
		st2.getTeachers().add(t1);
		st2.getTeachers().add(t2);
		
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(st1);
		session.save(st2);
		session.save(t1);
		session.save(t2);
		session.getTransaction().commit();
		session.close();
	}*/
}
