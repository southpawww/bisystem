package com.bisystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TM_USER")
public class User {

	
    @Id
	@Column(name="ID_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "TM_USER_SEQ4",allocationSize = 1)
	private int id;
	
	private String username;
	
	private String password;
	
	private int role_Id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public int getRoleId() {
		return role_Id;
	}

	public void setRoleId(int role_Id) {
		this.role_Id = role_Id;
	}
	
	
	@Override
	public String toString(){
		return "id="+id+", username="+username+", password="+password;
	}

}
