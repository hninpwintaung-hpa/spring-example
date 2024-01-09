package com.javaEETuring.demo.service.impl;

import org.springframework.stereotype.Service;

import com.javaEETuring.demo.service.AccountService;
import com.javaEETuring.demo.service.AuthenticationException;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public boolean login(String username, String password) throws AuthenticationException {
		if("admin".equals(username) && "admin".equals(password)) {
			return true;
		}else {
			throw new AuthenticationException("Invalid username or password");
		}
	}

}
