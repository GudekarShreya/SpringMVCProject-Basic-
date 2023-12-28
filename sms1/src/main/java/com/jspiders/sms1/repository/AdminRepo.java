package com.jspiders.sms1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.sms1.pojo.Admin;

@Component
public class AdminRepo {

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

	public void signUp(Admin admin) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(admin);		
		entityTransaction.commit();
		closeConnection();
	}
	
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins(){
		openConnection();
		Query query = entityManager.createQuery("select admin from Admin admin");
		return query.getResultList();
	}

	public void deleteAdmin(Admin adminToBeDeleted) {
		entityTransaction.begin();
		
		System.out.println("Deleting.....Repoooo");
		entityManager.remove(adminToBeDeleted);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	
	
}
