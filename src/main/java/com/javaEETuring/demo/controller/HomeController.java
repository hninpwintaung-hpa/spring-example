package com.javaEETuring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaEETuring.demo.service.ArithematicService;
import com.javaEETuring.demo.service.PrototypeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
		
	@Value ("${catalog.name}") String catalog;
	int a;
	@Autowired
	private ArithematicService arithematicService;
	
	public void setArithematicService(ArithematicService arithService) {
		this.arithematicService = arithService;
	}
	
	public HomeController() {
		log.info("Home Controller Created");
	}
	
	@Autowired
	PrototypeService prototypeService;
	
      @GetMapping("/")
      String home() {
    	  log.info("Catalog is : " + catalog);
    	  log.info("Home Controller / " + this.a);
    	  log.info("Get /" + arithematicService.add(1, 2));
    	  a++;
    	  return "home";
      }
}
