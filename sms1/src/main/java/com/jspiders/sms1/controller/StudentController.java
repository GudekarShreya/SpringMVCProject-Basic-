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
import com.jspiders.sms1.pojo.Student;
import com.jspiders.sms1.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/add_student", method = RequestMethod.GET)
	public String getPageToAddStudent(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			return "add_student";
		} else {
			return "login";
		}

	}

	@RequestMapping(path = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam byte age,
			ModelMap modelMap) {
		studentService.addStudent(name, email, age);
		modelMap.addAttribute("message", "Student Added...");
		return "add_student";
	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.GET)
	public String getPageToDeleteStudent(ModelMap modelMap, HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			List<Student> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "delete_student";
		} else {
			return "login";
		}

	}

	@RequestMapping(path = "/deleteStudent", method = RequestMethod.POST)
	public String deleteStudent(@RequestParam int id, ModelMap modelMap) {
		String message = studentService.deleteStudent(id);
		modelMap.addAttribute("message", message);
		List<Student> students = studentService.getAllStudents();
		modelMap.addAttribute("students", students);
		return "delete_student";
	}

	@RequestMapping(path = "/edit_student", method = RequestMethod.GET)
	public String getPageToEdit(ModelMap modelMap, HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			List<Student> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "edit_student";
		} else {
			return "login";
		}

	}

	@RequestMapping(path = "/editStudent", method = RequestMethod.POST)
	public String editStudent(@RequestParam int id, ModelMap modelMap) {
		Student student = studentService.getStudentById(id);
		modelMap.addAttribute("student", student);
		return "update_student";
	}

	@RequestMapping(path = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam byte age, ModelMap modelMap) {
		String message = studentService.updateStudent(id, name, email, age);
		modelMap.addAttribute("message", message);
		List<Student> students = studentService.getAllStudents();
		modelMap.addAttribute("students", students);
		return "edit_student";
	}

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getHomePage(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			return "home";
		} else {
			return "login";
		}

	}

	@RequestMapping(path = "/search")
	public String getPageToSearch(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			return "search";
		} else {
			return "login";
		}

	}

	@RequestMapping(path = "/get_students")
	public String getPageOfStudentList(ModelMap modelMap, HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("admin");
		if (admin != null) {
			List<Student> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "get_students";
		} else {
			return "login";
		}

	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String search(@RequestParam String pattern, ModelMap modelMap) {
		List<Student> students = studentService.searchStudentByPattern(pattern);
		modelMap.addAttribute("students", students);

		return "search";
	}
}
