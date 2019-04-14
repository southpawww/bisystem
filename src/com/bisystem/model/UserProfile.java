package com.bisystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import javax.persistence.Table;



@Entity
@Table(name="USER_PROFILE")
public class UserProfile {

	@Id
	@Column(name="ID_PROFILE")
	//@GeneratedValue
	private int id;
	
	@Column(name="PROFILE_PIC")
	byte[] pic_path;
	@Column(name="CREATION_DATE")
	Date creation_date;
	@Column(name="LAST_LOGIN")
	Date last_login;
	@Column(name="NAME")
	String name;
	@Column(name="SURNAME")
	String surname;
	@Column(name="EMAIL")
	String email;
	@Column(name="VERSION")
	int version;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PROFILE")
	@MapsId
	private User user;
	
	
	public User getUser()
	 {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPic_path() {
		return pic_path;
	}

	public void setPic_path(byte[] pic_path) {
		this.pic_path = pic_path;
	}
	
	public Date getCreation_date(){
		return creation_date;
	}
	
	public void setCreation_date(Date creation_date){
		 this.creation_date=creation_date;
	}
	
	public Date getLast_login() {
		return last_login;
	}
	
	public void setLast_login(Date last_login) {
		this.last_login= last_login;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname=surname;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
	    this.email=email;
	}
	
	public int getVersion(){
		return version;
	}
	
	public void setVersion(int version){
		this.version=version;
	}
	
	
}
