package com.bisystem.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bisystem.dao.UserDao;
import com.bisystem.model.AppUser;
import com.bisystem.model.Login;
import com.bisystem.model.User;




@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	  @Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  /*
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  @Override
		public void persistUser(User user) {
		 sessionFactory.getCurrentSession().persist(user);
			
		}

		@Override
		public User findUserById(int id) {
			 return (User) sessionFactory.getCurrentSession().get(User.class, id);
			
		}


		@Override
		public void updateUser(User user) {
			 sessionFactory.getCurrentSession().update(user);
			
		}

		@Override
		public void deleteUser(User user) {
			sessionFactory.getCurrentSession().delete(user);
			
		}
*/

	  
	
	  
	  
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
