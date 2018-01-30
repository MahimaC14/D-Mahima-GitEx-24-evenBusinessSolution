package com.tfseven.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tfseven.pojo.Address;
import com.tfseven.pojo.Employee;
import com.tfseven.service.IUserService;

@Controller
@RequestMapping("/Register")
public class UserController {

	@Autowired
	@Qualifier("UserService")
	private IUserService service;
	
	@ModelAttribute("roles") public List getCountry()
	{
		List role = new ArrayList();
		role.add("Human Resource");
		role.add("Finance");
		return role;
	}
	
	@GetMapping(value = "/Registration")
	public String showRegForm(Map model,Employee employee) {
		Employee emp = new Employee();
		model.put("role",emp);
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		model.put("today", dateFormat.format(date));
		return "/Common/Registration";
	}

	@PostMapping(value = "/Registration")
	public String processRegForm(@Valid @ModelAttribute("employee") Employee employee, BindingResult res,
			HttpSession hs) {
		if (res.hasErrors()) {
			return "/Common/Error";
		}
		hs.setAttribute("usrInfo", employee);
		return "redirect:/Register/Address";
	}

	@GetMapping(value = "/Address")
	public String showAddrForm(RedirectAttributes attrs, Address address) {

		attrs.addFlashAttribute("usrInfo2", address);
		return "/Common/Address";
	}

	@PostMapping(value = "/Address")
	public String processAddrForm(@ModelAttribute("usrInfo") Employee employee, RedirectAttributes attrs,
			@Valid @ModelAttribute("usrInfo2") Address address, BindingResult res, HttpSession hs) {
		if (res.hasErrors()) {
			System.out.println("processing reg form " + res);
			return "/Common/Error";
		}
		try{
		service.regUser((Employee) hs.getAttribute("usrInfo"), address);
		}
		catch(Exception e)
		{
			if(true)
				attrs.addFlashAttribute("msg", ((Employee) hs.getAttribute("usrInfo")).getEmail()+"Email is already in use");
				return "/Common/Error";
		}
		return "redirect:/emp/login";
	}
}
