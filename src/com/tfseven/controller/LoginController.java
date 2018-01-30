package com.tfseven.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tfseven.pojo.Employee;
import com.tfseven.service.IUserService;
import com.tfseven.service.UserService;

@Controller
@RequestMapping("/emp")
public class LoginController {

	@Autowired
	private IUserService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@ModelAttribute("roles")
	public List<String> getRoleList() {
		List<String> role = new ArrayList<>();
		role.add("Human Resource");
		role.add("Finance");
		return role;
	}

	@GetMapping(value = "/login")
	public String showLoginForm(Employee e, Model map) {
		System.out.println("in show login form " + map);
		return "/Common/login";
	}

	// process login form
	@PostMapping(value = "/login")
	public String processLoginForm(@Valid Employee e, BindingResult res, RedirectAttributes attrs, HttpSession hs) {
		if (res.hasFieldErrors("email") || res.hasFieldErrors("password")) {
			System.out.println("errors in process login form");
			return "/Common/login";
		}
		System.out.println("in process login form " + e);
		try {
			Employee emp = service.validateEmployee(e.getEmail(), e.getPassword(), e.getRole());
			hs.setAttribute("empdata", emp);
			System.out.println("successful validated emp  " + emp);
			if ((emp.getRole()).equalsIgnoreCase("Human Resource")) {
				System.out.println("session1 " + hs.getAttribute("empdata") + " " + hs.isNew());
				return "/HR/HomePage";
			} else {
				
				return "/Finance/HomePage";
			}
		} catch (Exception e1) {
			// In case of invalid login , dao layer's method --getSingleResult
			// throws
			// NoResultException --so catch that
			System.out.println("err in LoginController "+e);
			attrs.addAttribute("status", "Login failed");
			return "/Common/login";
		}

		
	}

	@GetMapping(value = "/ChangePassword2")
	public String showPasswordForm(Employee e, Model map, HttpSession hs) {
		System.out.println("session2 " + hs.getAttribute("empdata") + " " + hs.isNew());
		// System.out.println("session3 " + hs.getAttribute("empdata1"));
		System.out.println("in show pwd form " + map);
		return "/Common/ChangePassword2";
	}

	// process login form
	@PostMapping(value = "/ChangePassword2")
	public String processPasswordForm(@Valid Employee e, BindingResult res, RedirectAttributes attrs, HttpSession hs) {
		Employee validEmp=(Employee)hs.getAttribute("empdata");
		System.out.println("session " +validEmp );
		if (res.hasFieldErrors("npassword") || res.hasFieldErrors("password")) {
			System.out.println("errors in process password form");
			return "/Common/login";
		} else if (!(e.getnPassword().equals(e.getcPassword()))) {
			System.out.println("errors in process password form 2");
			return "/Common/login";
		} else if (!(e.getPassword().equals(validEmp.getPassword()))) {
			System.out.println("errors in process password form 3");
			return "/Common/login";
		} else {
			System.out.println("No P.L errs :  proceed to update" );

			String str = service.changePassword(e.getPassword(), e.getnPassword(),
					validEmp.getEmail());
			/* Madhura Edit
			 * Since there is no HomePage under Common -- I changed it to HR
			 */
			//add modified emp data under session scope
			validEmp.setPassword(e.getnPassword());
			hs.setAttribute("empdata",validEmp);
			return "/HR/HomePage";
			// hs.setAttribute("status", "Login successful");
		}

	}	
}