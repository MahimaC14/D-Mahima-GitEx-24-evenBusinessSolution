package com.tfseven.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/Employee")
public class LogoutController {
	@GetMapping(value = "/logout")
	public String logout(HttpSession hs,Model map) {
		System.out.println("in logout");
		map.addAttribute("logoutStatus", hs.getAttribute("status"));
		hs.invalidate();
		return "/Common/logout";
	}
}
