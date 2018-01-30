package com.tfseven.dao;

import java.util.List;

import com.tfseven.pojo.*;

public interface HrDao
{
	List<AddEmployee> listAllEmployee();
	List<Object> getFullEmployeeById(Integer employee_id);
	boolean registerEmployee(AddEmployee emp,Accounts acc);
	AddEmployee updateEmployee(AddEmployee e);
	String deleteEmployee(Integer employee_id);
}
