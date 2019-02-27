package com.bisystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TM_USER")
public class User {

	@Id
	@Column(name = "ID_USER", nullable = false)
	private int id;
	
	@Id
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@Id
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Id
	@Column(name = "ROLE_ID", nullable = false)
	private int roleid;
	
	
	public User() {		
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRoleid() {
		return roleid;
	}
	
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
