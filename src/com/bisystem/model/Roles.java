package com.bisystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Roles {

   @Id
   @Column(name="ID_USER")
   private int id;
	
   
   private String roles_name;
	
	
}
