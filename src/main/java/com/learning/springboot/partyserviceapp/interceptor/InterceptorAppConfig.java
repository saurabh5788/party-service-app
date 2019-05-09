package com.learning.springboot.partyserviceapp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorAppConfig extends WebMvcConfigurerAdapter {
	@Autowired
	PartyServiceControllerInterceptor partyServiceControllerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(partyServiceControllerInterceptor);
	}
}
