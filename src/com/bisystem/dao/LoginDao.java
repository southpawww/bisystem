package com.bisystem.dao;

import com.bisystem.model.AppUser;
import com.bisystem.model.Login;

public interface LoginDao {

	
	 AppUser validateLogin(Login login);
}
