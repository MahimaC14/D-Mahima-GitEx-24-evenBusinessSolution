package com.tfseven.service;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tfseven.dao.IUserRegistration;
import com.tfseven.pojo.Address;
import com.tfseven.pojo.Employee;

@Service("UserService")
@Transactional
public class UserService implements IUserService{

	@Autowired
	private IUserRegistration dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,
		    isolation = Isolation.DEFAULT)
	public void regUser(Employee usr, Address address) throws HibernateException {
		// TODO Auto-generated method stub
		dao.regUser(usr, address);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Employee validateEmployee(String em, String pass,String role) {
		Employee e = dao.validateEmployee(em, pass,role);
		return e;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public String changePassword(String oldpassword,String newpassword,String emailId)
	{
		Employee e = dao.changePassword(oldpassword,newpassword,emailId);
		if(e==null)
		{
			return "Password updation Failed";
		}
		else
		{
		return "password updated successfully " + e;
		}
		
	}

}
