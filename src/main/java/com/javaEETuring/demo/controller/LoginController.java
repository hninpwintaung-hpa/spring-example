package com.javaEETuring.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaEETuring.demo.service.AccountService;
import com.javaEETuring.demo.service.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AccountService accountService;
	
	@GetMapping
	public String login() {
		log.info("get login handler");
		return "login";
	}
	
	@PostMapping
	public String loginSubmit(@RequestParam String username,
			@RequestParam String password) {
		log.info("login form post username " + username + "password :" + password);
		try {
			boolean result = this.accountService.login(username, password);
		}catch(AuthenticationException ae){
	        return "redirect:/login";
		}
		return "redirect:/";
	}
}
