package com.javaEETuring.demo.service;

public interface AccountService {

	boolean login(String username, String password) throws AuthenticationException;
}
