package com.bisystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bisystem.dao.LoginDao;
import com.bisystem.model.AppUser;
import com.bisystem.model.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
    @Qualifier("loginDao")
	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public AppUser validateLogin(Login login) {
		return loginDao.validateLogin(login);
	}

}
