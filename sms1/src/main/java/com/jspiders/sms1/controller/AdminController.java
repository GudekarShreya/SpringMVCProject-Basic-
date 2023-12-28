package com.jspiders.sms1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.sms1.pojo.Admin;
import com.jspiders.sms1.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(path = "/sign_up")
	public String addAdmin(ModelMap modelMap) {
		List<Admin> admins = adminService.getAllAdmins();
		if (admins.size()<3) {
			return "add_admin";
		}
		else {
			modelMap.addAttribute("message", "Access Denied..");
			return "login";
		}
		
	}
	
	@RequestMapping(path = "/signUp", method = RequestMethod.POST)
	public String signUp(@RequestParam String userName, @RequestParam String email, @RequestParam String password, ModelMap modelMap) {
		adminService.signUp(userName,email,password);
		modelMap.addAttribute("message", "Signed up successfully..");
		return "login";
	}
	
	@RequestMapping(path = "/log_in")
	public String logIn() {
		return "login";
	}
	
	@RequestMapping(path = "/logIn")
	public String logIn(@RequestParam String userName,@RequestParam String password, ModelMap modelMap, HttpSession httpSession) {
		Admin admin = adminService.logIn(userName,password);
		if (admin!=null) {
			httpSession.setAttribute("admin", admin);
			httpSession.setMaxInactiveInterval(1800);
			modelMap.addAttribute("admin", userName);
			return "welcome";
		}else {
			modelMap.addAttribute("message", "Wrong credentials..");
			return "login";
		}
	}
	
	@RequestMapping(path = "/delete_admin")
	public String deleteAdmin(@RequestParam String userName, ModelMap modelMap) {
		adminService.deleteAdmin(userName);
		modelMap.addAttribute("message", "Admin deleted");
		return "login";
	}
	
	@RequestMapping(path = "/log_out")
	public String log_out(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

}
