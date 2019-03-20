package com.bisystem.dao;

import org.hibernate.Session;

import com.bisystem.model.UserProfile;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {
 
	private static final Logger logger = LoggerFactory.getLogger(UserProfileDaoImpl.class);
	
   private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void addUserProfile(UserProfile p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, User Details="+p);
		
	}

}
