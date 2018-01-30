package com.tfseven.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tfseven.pojo.Address;
import com.tfseven.pojo.Employee;

@Repository
public class UserRegistration implements IUserRegistration {

	@Autowired
	private SessionFactory sf;

	@Override
	public void regUser(Employee usr, Address address) throws HibernateException {
		// TODO Auto-generated method stub
		Session hs = sf.getCurrentSession();
		hs.persist(usr);
		usr.addAddress(address);
	}

	@Override
	public Employee validateEmployee(String em, String pass, String role) {
		return (Employee) sf.getCurrentSession()
				.createQuery("select e from Employee e where e.email = :em and e.password = :pass and e.role=:role",
						Employee.class)
				.setParameter("em", em).setParameter("pass", pass).setParameter("role", role).getSingleResult();
	}

	@Override
	public Employee changePassword(String oldpassword, String newpassword, String emailId) {
		// Madhura Edit -- update query has to be fired with executeUpdate & it
		// rets int
		System.out.println("in dao "+emailId+" "+newpassword+" "+oldpassword);
		Employee e = sf.getCurrentSession()
				.createQuery("select e from Employee e where e.email=:email and e.password=:pass", Employee.class)
				.setParameter("email", emailId).setParameter("pass", oldpassword).getSingleResult();
		e.setPassword(newpassword);//SINC
		return e;
	}

}
