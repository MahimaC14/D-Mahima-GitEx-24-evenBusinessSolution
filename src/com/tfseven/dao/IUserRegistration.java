package com.tfseven.dao;

import com.tfseven.pojo.Address;
import com.tfseven.pojo.Employee;

public interface IUserRegistration {

	Employee validateEmployee(String em,String pass,String role);
	Employee changePassword (String oldpassword,String newpassword,String email);
	void regUser(Employee usr,Address address);
}
