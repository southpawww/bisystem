package com.bisystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bisystem.dao.UserDao;
import com.bisystem.model.UserProfile;
import com.bisystem.dao.UserProfileDao;

@Service
public class UserProfileServiceImpl implements UserProfileService {

   private UserProfileDao userProfileDao;
	
	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	
	
	@Override
	@Transactional
	public void addUserProfile(UserProfile p) {
		this.userProfileDao.addUserProfile(p);
		
	}

}
