package com.bisystem.dao;

import com.bisystem.model.Login;
import com.bisystem.model.User;
import com.bisystem.model.AppUser;

public interface UserDao {

    void register(AppUser user);
	
    AppUser validateUser(Login login);
    
    /*void persistUser(User user);
    
    User findUserById(int id);
     
    void updateUser(User user);
     
    void deleteUser(User user);
	*/
}
