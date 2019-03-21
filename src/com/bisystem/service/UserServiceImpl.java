package com.bisystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bisystem.dao.UserDao;
import com.bisystem.model.User;
import com.bisystem.model.UserProfile;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
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

	@Override
	@Transactional
	public List<User> getUsersByPage(int pageid, int total) {
		return this.userDao.getUsersByPage(pageid, total);
		
	}
	
	@Transactional
	public void upUser(User user) {
        User entity = userDao.getUserById(user.getId());
        UserProfile entityprofile = entity.getUserProfile();
       
        if(entity!=null){
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            entity.setRoleId(user.getRoleId());
            entityprofile.setEmail(user.getUserProfile().getEmail());
            entityprofile.setName(user.getUserProfile().getName());
            entityprofile.setSurname(user.getUserProfile().getSurname());
            
        }
    }
	
}
