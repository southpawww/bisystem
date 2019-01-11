package com.bisystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bisystem.dao.UserMapper;
import com.bisystem.model.Login;
import com.bisystem.model.AppUser;

@Repository
public class UserDaoImpl implements UserDao {

	  @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	 
	 
	  
	  
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
		  String sql="Select username, MS_ROLES.R_NAME as role " + 
		  		"from TM_USER " + 
		  		"join MS_ROLES on TM_USER.ID_ROLE = MS_ROLES.ID_ROLE " + 
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
