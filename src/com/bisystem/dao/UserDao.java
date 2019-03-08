package com.bisystem.dao;

import java.util.List;

import com.bisystem.model.User;

public interface UserDao {

	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
	
}
