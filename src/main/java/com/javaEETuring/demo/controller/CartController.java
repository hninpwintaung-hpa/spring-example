package com.javaEETuring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaEETuring.demo.model.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shop")
public class CartController {

	@Autowired
	ShoppingCart shoppingCart;
	
	@GetMapping("/addToCart")
	public String getRequestScopeMessage(@RequestParam String item) {
		this.shoppingCart.AddToCart(item);
		return "shoppingCart";
	}
}
