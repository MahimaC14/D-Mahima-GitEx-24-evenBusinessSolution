package com.tfseven.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfseven.dao.HrDao;
import com.tfseven.pojo.Accounts;
import com.tfseven.pojo.AddEmployee;
import com.tfseven.pojo.Employee;

@Service("Employee_Service")
@Transactional
public class EmployeeDaobasedService implements EmployeeService {
	@Autowired
	private HrDao dao;

	@Override
	@Transactional
	public AddEmployee updateEmployee(AddEmployee e) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(e);
	}
	
	@Override
	@Transactional
	public String deleteEmployee(Integer employee_id)
	{
		return dao.deleteEmployee(employee_id);
	}

	@Override
	public List<Object> getFullEmployeeById(Integer employee_id) {
		// TODO Auto-generated method stub
		return dao.getFullEmployeeById(employee_id);
}

	@Override
	public List<AddEmployee> listAllEmployee() {
		// TODO Auto-generated method stub
		return new ArrayList<> (dao.listAllEmployee());
		
	}

	@Override
	@Transactional
	public boolean registerEmployee(AddEmployee emp, Accounts acc) {
		// TODO Auto-generated method stub
		if (dao.registerEmployee(emp, acc)) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
