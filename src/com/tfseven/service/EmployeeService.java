package com.tfseven.service;
import java.util.List;

import com.tfseven.pojo.Accounts;
import com.tfseven.pojo.AddEmployee;
import com.tfseven.pojo.Employee;;

public interface EmployeeService
{
	List<Employee> listEmployee();
	AddEmployee updateEmployee(AddEmployee e);
	String deleteEmployee(Integer employee_id);
	boolean registerEmployee(AddEmployee emp,Accounts acc);
	List<AddEmployee> listAllEmployee();
	List<Object> getFullEmployeeById(Integer employee_id);
}
