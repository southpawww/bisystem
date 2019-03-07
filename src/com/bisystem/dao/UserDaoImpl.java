package com.bisystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import com.bisystem.daoimpl.UserMapper;
import com.bisystem.model.AppUser;
import com.bisystem.model.Login;
import com.bisystem.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	  @Autowired
	  DataSource datasource;
	
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	
	
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

	 
	 public void register(AppUser user) {
		    String sql = "insert into users values(?,?,?,?,?)";
		    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
		    user.getLastname(), user.getEmail()});
		    }
		 
		  
		  public AppUser validateUser(Login login) {
		   String sql="Select * from TM_USER "
	                + "where username ='"+login.getUsername() +"'and password ='"+login.getPassword()+"'";
			
		   
			List<AppUser> users = jdbcTemplate.query(sql, new UserMapper());
			

		    return users.size() > 0 ? users.get(0) : null;
		    
		   
		    }
		  
		  public AppUser getUserInfo(String username)
		  {
			  String sql="Select username, ROLES.ROLES_NAME as role " + 
			  		"from TM_USER " + 
			  		"join ROLES on TM_USER.ROLE_ID = ROLES.ID_ROLE " + 
			  		"where tm_user.enabled=1 and TM_USER.username =?" ;
			  	
			  AppUser user = jdbcTemplate.queryForObject(sql, new Object[]{username},
			    		new RowMapper<AppUser>() {
		            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		                AppUser user = new AppUser();
		                user.setUsername(rs.getString("username"));
		                user.setPassword(rs.getString("role"));
		                
		                return user;
		            }
	      });
			  return user;
		  }
	
}
class UserMapper implements RowMapper<AppUser> {
	  
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
	    
		AppUser user = new AppUser();
		user.setFirstname(rs.getString(2));
		user.setLastname(rs.getString(3));
	 //    user.setUsername(rs.getString("username"));
	   // user.setPassword(rs.getString("password"));
	    
	    return user;
	  }
	
}


