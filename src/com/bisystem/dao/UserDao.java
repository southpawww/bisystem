package com.bisystem.dao;

import com.bisystem.model.Login;
import com.bisystem.model.AppUser;

public interface UserDao {

    void register(AppUser user);
	
    AppUser validateUser(Login login);
	
}
