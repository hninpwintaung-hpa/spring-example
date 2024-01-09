package com.javaEETuring.demo.service.impl;

import org.springframework.stereotype.Service;

import com.javaEETuring.demo.service.ArithematicService;

@Service
public class ArithematicServiceImpl implements ArithematicService {

	@Override
	public int add(int a, int b) {
		return a+b;
	}
        
}
