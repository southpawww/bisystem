package com.bisystem.service;

import com.bisystem.model.AppUser;
import com.bisystem.model.Login;

public interface LoginService {

	 AppUser validateLogin(Login login);
}
