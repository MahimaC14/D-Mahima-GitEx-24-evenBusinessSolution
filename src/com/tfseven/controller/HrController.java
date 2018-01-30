package com.tfseven.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tfseven.pojo.Accounts;
import com.tfseven.pojo.AddEmployee;
import com.tfseven.pojo.Address;
import com.tfseven.pojo.Employee;
import com.tfseven.service.EmployeeService;


@Controller
@RequestMapping("/emp/hr")
public class HrController 
{
	@Autowired
	@Qualifier("Employee_Service")
	private EmployeeService service;
	
	
	//Add Employee
	@GetMapping(value = "/hr_add")
	public String showRegForm(AddEmployee addEmployee)
	{
		System.out.println("in show reg form");
		return "HR/hr_add";
	}


	// req handling method to process form
	@PostMapping(value="/hr_add")
	public String ProcessRegform(@Valid @ModelAttribute("addEmployee") AddEmployee addEmployee, BindingResult res,HttpSession hs)
	{
		System.out.println("in process reg emp:"+ addEmployee);
		if(res.hasErrors())
		{
			System.out.println("p.l errrrrrrrrrr"+res);
			return "/HR/hr_add";
		}
		hs.setAttribute("emp",addEmployee);
		return "redirect:/emp/hr/Account";
		
	}
	
	@GetMapping(value = "/Account")
	public String showAccForm(RedirectAttributes attrs, Accounts accounts) {

		attrs.addFlashAttribute("usrInfo2", accounts);
		return "/HR/Account";
	}

	@PostMapping(value = "/Account")
	public String processAccForm(@ModelAttribute("emp") AddEmployee addEmployee, RedirectAttributes attrs,
			@Valid @ModelAttribute("usrInfo2") Accounts accounts, BindingResult res, HttpSession hs) {
		if (res.hasErrors()) {
			System.out.println("processing reg form " + res);
			return "/HR/Error";
		}
		service.registerEmployee((AddEmployee) hs.getAttribute("emp"), accounts);
		return "/HR/abc";
	}

	
	
	/*//Get Employee by ID
	@GetMapping(value = "/getEmployeeByID")
	public String showEmp()
	{
		System.out.println("in getEmp form");
		return "/HR/getEmployeeByID";
	}
	
	@PostMapping(value = "/getEmployeeID") 
	public String showEmp(Model model, @RequestParam Integer id)
	{
		System.out.println("in getEmp form 2");
		model.addAttribute("Emp",service.getEmployeeById(id));
		return "/HR/EmpInfo";
	}
	*/
	
	
	//Update Employee
	@GetMapping(value = "/getEmployeeUpdated")
	public String updateById()
	{
		System.out.println("in updateEmp form");
		return "/HR/getEmployeeUpdated";
	}
	
	@PostMapping(value = "/getEmployeeUpdated") 
	public String showUpdateById(HttpSession hs, @RequestParam Integer id)
	{
		System.out.println("in updateEmp form 2");
		hs.setAttribute("Employee",(service.getFullEmployeeById(id)).get(0));
		return "redirect:/emp/hr/updateEmployee";
	}
	
	@GetMapping(value = "/updateEmployee")
	public String showUpdateForm(Map model,AddEmployee addEmployee,HttpSession hs) {
		model.put("id",((AddEmployee)hs.getAttribute("Employee")).getEmployee_id());
		return "/HR/updateEmployee";
	}

	
	@PostMapping(value = "/updateEmployee")
	public String processUpdateForm(RedirectAttributes attrs, @Valid AddEmployee addEmployee,
			BindingResult res) {
		
		System.out.println("in proc update form " + " " + addEmployee);
		if (res.hasErrors()) {
			System.out.println("p.l errs : processing reg form " + res);
			return "/HR/Error";
		}
		//((AddEmployee)hs.getAttribute("Emp"))
		System.out.println("in process update form , no pl errs " + addEmployee);
		attrs.addFlashAttribute("status", service.updateEmployee(addEmployee));
		return "/HR/abc";
	}

	
	//delete Employee
	@GetMapping(value = "/deleteEmployee")
	public String deleteEmployeeRecord()
	{
		System.out.println("in deleteEmp form");
		return "/HR/deleteEmployee";
	}
	
	@PostMapping(value = "/deleteEmployee")
	public String deleteEmployeeRecord(Model model,@RequestParam Integer id)
	{
		System.out.println("in getEmp form 2");
		model.addAttribute("delemp",service.deleteEmployee(id));
		return "/HR/abc";
	}

	//Get Full Details of an employee
			@GetMapping(value = "/getFullEmployeeByID")
			public String showFullEmp()
			{
				System.out.println("in getFullEmp-form");
				return "/HR/getFullEmployeeByID";
			}
			
			@PostMapping(value = "/getFullEmployeeByID") 
			public String showFullEmp(Model model, @RequestParam Integer id)
			{
				System.out.println("in getFull Emp processing form");
				//model.addAttribute("EmpFull",service.getFullEmployeeById(id));
				List<Object> list=service.getFullEmployeeById(id);
				model.addAttribute("employee",list.get(0));
				model.addAttribute("account",list.get(1));
				model.addAttribute("department",list.get(2));
				model.addAttribute("job",list.get(3));
				model.addAttribute("location",list.get(4));
				
				return "/HR/EmpFullInfo";
			}
			
			@GetMapping("/listAllEmployee")
			public String listAllEmployee(Model map) {
				System.out.println("in list Employees " + map.getClass().getName());
				System.out.println("after list emp"+service.listAllEmployee());
				map.addAttribute("hr_list", service.listAllEmployee());
				return "/HR/listAllEmployee";
			}
	
}
 
