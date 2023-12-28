package com.jspiders.sms1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.sms1.pojo.Admin;
import com.jspiders.sms1.repository.AdminRepo;

@Component
public class AdminService {
	@Autowired
	private AdminRepo adminRepo;

	public void signUp(String userName, String email, String password) {

		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setEmail(email);
		admin.setPassword(password);
		adminRepo.signUp(admin);

	}

	public Admin logIn(String userName, String password) {
		List<Admin> admins = adminRepo.getAllAdmins();
		Admin adminToBeLogIn = null;
		for (Admin admin : admins) {
			if (admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {
				adminToBeLogIn = admin;
				break;
			}
		}
		return adminToBeLogIn;
	}

	public void deleteAdmin(String userName) {
		List<Admin> admins = adminRepo.getAllAdmins();
		Admin adminToBeDeleted = null;
		for (Admin admin : admins) {
			if (admin.getUserName().equals(userName)) {
				adminToBeDeleted = admin;
				System.out.println(adminToBeDeleted);
				break;
			}
		}
		
		System.out.println("Deleting....Serviceeeee....");
		adminRepo.deleteAdmin(adminToBeDeleted);
	}

	public List<Admin> getAllAdmins() {
		 return adminRepo.getAllAdmins();
	}

}
