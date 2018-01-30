package com.tfseven.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tfseven.pojo.*;

@Repository
public class HrDaoImpl implements HrDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public boolean registerEmployee(AddEmployee emp, Accounts acc) {
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().saveOrUpdate(emp);
			emp.addAccount(acc);
			return true;
		} catch (Exception e) {
			System.out.println("Error in reg");
			return false;
		}
		// return sf.getCurrentSession().persist(c);

	}

	@Override
	public List<Object> getFullEmployeeById(Integer employee_id) {
	
	 List<Object> list=new ArrayList<>();
	 AddEmployee e = (AddEmployee) sf.getCurrentSession().get(AddEmployee.class, employee_id);
	 Accounts a=(Accounts) sf.getCurrentSession().get(Accounts.class,e.getAcc().getAccID());
	 Departments d=(Departments) sf.getCurrentSession().get(Departments.class,e.getDrpt().getDepartment_id());
	 Jobs j=(Jobs) sf.getCurrentSession().get(Jobs.class,e.getJob().getJob_id());
	 Locations l=(Locations) sf.getCurrentSession().get(Locations.class,e.getLoc().getLocation_id());
		list.add(e);
		list.add(a);
		list.add(d);
		list.add(j);
		list.add(l);
		/*for(Object o:list)
		{
			list.add(o);
		}*/
		return list;
	}
	
	@Override
	public String deleteEmployee(Integer employee_id) {
		String status = "employee deletion failed";
		List<Object> lst = getFullEmployeeById(employee_id);
		AddEmployee emp =  (AddEmployee) lst.get(0);
		if (emp != null) {
			sf.getCurrentSession().delete(emp);
			status = "Employee with ID " + emp.getEmployee_id() + " deleted successfully";
		}
		return status;

	}

	@Override
	public AddEmployee updateEmployee(AddEmployee e) {
		sf.getCurrentSession().update(e);
		return e;
	}
	
	@Override
	public List<AddEmployee> listAllEmployee()
	{
		return sf.getCurrentSession()
				.createQuery("select e from AddEmployee e",AddEmployee.class).getResultList();
		
	}
}
