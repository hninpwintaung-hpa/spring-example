package com.javaEETuring.demo.service.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.javaEETuring.demo.service.PrototypeService;

import lombok.extern.slf4j.Slf4j;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Slf4j
public class PrototypeBean implements PrototypeService{

	public PrototypeBean() {
		log.info("Prototype Bean Created" + this);
	}
	public void api() {
		log.info("API called");
	}
}
