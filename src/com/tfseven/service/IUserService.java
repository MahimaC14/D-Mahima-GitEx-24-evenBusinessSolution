package com.tfseven.service;

import com.tfseven.pojo.Address;
import com.tfseven.pojo.Employee;

public interface IUserService {

	void regUser(Employee usr, Address address);
	Employee validateEmployee(String em,String pass,String role);
	String changePassword(String oldpassword,String newpassword,String emailId);
}
