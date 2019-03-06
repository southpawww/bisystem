package com.bisystem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bisystem.dao.UserDao;
import com.bisystem.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDAO(UserDao userDao) {
		this.userDao = userDao;
	}
	
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
}
