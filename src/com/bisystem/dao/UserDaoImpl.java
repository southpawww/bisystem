package com.bisystem.dao;


import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.bisystem.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, User Details="+p);
	}
	
	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
	
		session.update(p);
		
		logger.info("User updated successfully, User Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList =(List<User>) session.createQuery("from User").list();
		for(User p : usersList){
			logger.info("User List::"+p);
		}
		 for(User user : usersList){
	            Hibernate.initialize(user.getUserProfile());
	        }
		return usersList;
	}
	
	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+p);
		return p;
	}
	
	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	 public List<User> getUsersByPage(int pageid, int total) {
			Session session = this.sessionFactory.getCurrentSession();
			 List<User> usersList =(List<User>) session.createQuery("from User").setFirstResult(pageid).setMaxResults(total).list();
	             
	           return usersList;
	       
	    }
}


