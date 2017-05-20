package com.springboot.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users", uniqueConstraints= @UniqueConstraint(columnNames={"username", "email"}))
@XmlRootElement
public class User {

	@Id
	@Column(name = "username",length = 20)
	private String username;
	
	@Column(name = "email" , length = 30)	
	private String emailAddress;
	
	@Column(name = "password", length = 20)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
