package com.bisystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bisystem.model.AppUser;
import com.bisystem.model.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

	 @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	@Override
	public AppUser validateLogin(Login login) {
		String sql="Select * from TM_USER "
                + "where username ='"+login.getUsername() +"'and password ='"+login.getPassword()+"'";
		
	   
		List<AppUser> users = jdbcTemplate.query(sql, new UserMapper());
		
         
	    return users.size() > 0 ? users.get(0) : null;
	    
	   
	    
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