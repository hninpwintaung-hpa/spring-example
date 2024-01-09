package com.javaEETuring.demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.javaEETuring.demo.model.ShoppingCart;
import com.javaEETuring.demo.service.impl.ExampleBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig implements WebMvcConfigurer{
	@Bean
	public ExampleBean exampleBean() {
		log.info("Invoke via factory method");
		return new ExampleBean();
	}
	
	@Bean 
	@SessionScope
	public ShoppingCart shoppingCart() {
		log.info("Shopping Cart created");
		return new ShoppingCart();
		
	}
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
}
