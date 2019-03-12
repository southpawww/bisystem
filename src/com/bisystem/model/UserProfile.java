package com.bisystem.model;

import java.sql.Date;

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
@Table(name="USER_PROFILE")
public class UserProfile {

	@Id
	@Column(name="ID_PROFILE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "USER_PROFILE_SEQ",allocationSize = 1)
	private int id;
	
	String pic_path;
	Date creation_date;
	Date last_login;
	String name;
	String surname;
	String email;
	int version;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPic_path() {
		return pic_path;
	}

	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	
	public Date getCreation_date(){
		return creation_date;
	}
	
	public void setCreation_date(Date creation_date){
		 this.creation_date=creation_date;
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
