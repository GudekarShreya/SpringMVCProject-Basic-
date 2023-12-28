package com.jspiders.sms1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.sms1.pojo.Student;

@Component
public class StudentRepo {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
	}
	
	public void closeConnection() {
		
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public void addStudent(Student student) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(student);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		openConnection();
		Query query = entityManager.createQuery("select student from Student student");
		return query.getResultList();
		
	}
	
	public Student getStudentById(int id) {
		openConnection();
		Student student = entityManager.find(Student.class, id);
		return student;
		
	}

	public String deleteStudent(int id) {
		openConnection();
		Student student = getStudentById(id);
		String message=null;
		entityTransaction.begin();
		if (student != null) {
			entityManager.remove(student);
			message =  "Student deleted";
		}
		else {
			message = "Student not found";
		}		
		
		entityTransaction.commit();
		closeConnection();
		return message;
	}

	public void updateStudent(int id, String name, String email, byte age) {
		openConnection();
		entityTransaction.begin();
		
		Student student = entityManager.find(Student.class, id);
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setAge(age);
		entityManager.persist(student);
		
		entityTransaction.commit();
		closeConnection();
	}

	@SuppressWarnings("unchecked")
	public List<Student> searchStudentByPattern(String pattern) {
		openConnection();
		Query query = entityManager.createQuery("select student from Student student where name like '%"+pattern+"%'");
		return query.getResultList();
	}
	
}
