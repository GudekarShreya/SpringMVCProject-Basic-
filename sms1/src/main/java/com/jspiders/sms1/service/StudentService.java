package com.jspiders.sms1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.sms1.pojo.Student;
import com.jspiders.sms1.repository.StudentRepo;

@Component
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public void addStudent(String name, String email, byte age) {
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		studentRepo.addStudent(student);	
		
	}
	
	public List<Student> getAllStudents() {
		
		List<Student> students = studentRepo.getAllStudents();
		return students;
		
	}
	
	public String deleteStudent(int id) {
		return studentRepo.deleteStudent(id);		
	}

	public Student getStudentById(int id) {
		return studentRepo.getStudentById(id);
	}

	public String updateStudent(int id, String name, String email, byte age) {
		studentRepo.updateStudent(id, name, email, age);
		return "Student updated..";
	}

	public List<Student> searchStudentByPattern(String pattern) {
		return studentRepo.searchStudentByPattern(pattern);
		
	}
	

}
