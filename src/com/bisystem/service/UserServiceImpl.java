package com.bisystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bisystem.dao.UserDao;
import com.bisystem.model.AppUser;
import com.bisystem.model.Login;
import com.bisystem.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	 @Autowired
	  DataSource datasource;
	
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	@Override
	@Transactional
	public void addUser(User p) {
		this.userDao.addUser(p);
	}
	
	@Override
	@Transactional
	public void updateUser(User p) {
		this.userDao.updateUser(p);
	}
    
	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDao.listUsers();
	}
	
	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDao.removeUser(id);
	}

	@Override
	public AppUser validateUser(Login login) {
		userDao.validateUser(login);
		return null;
	}

	@Override
	public AppUser getUserInfo(String username) {
		userDao.getUserInfo(username);
		return null;
	}
	
	
	
}

