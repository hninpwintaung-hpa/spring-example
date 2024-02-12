package com.javaEETuring.demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.javaEETuring.demo.interceptor.CustomInterceptor;
import com.javaEETuring.demo.interceptor.LogInterceptor;
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
	
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addWebRequestInterceptor(customInterceptor()).addPathPatterns("/books/**");
		registry.addInterceptor(logInterceptor());
	}
	
	@Bean 
	public HandlerInterceptor localeChangeInterceptor() {
	   LocaleChangeInterceptor localeChangeInterceptor =  new LocaleChangeInterceptor();
	   localeChangeInterceptor.setParamName("lang");
	   return localeChangeInterceptor;
	   
	}
	@Bean
	public WebRequestInterceptor customInterceptor() {
		CustomInterceptor interceptor = new CustomInterceptor();
		return interceptor;
	}
	@Bean
	public HandlerInterceptor logInterceptor() {
		return new LogInterceptor();
	}
}
