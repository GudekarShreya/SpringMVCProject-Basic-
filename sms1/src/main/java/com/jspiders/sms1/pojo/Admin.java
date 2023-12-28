package com.jspiders.sms1.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false, unique = true)
	private String userName;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

}
