package com.learning.springboot.partyserviceapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PartyServiceControllerInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyServiceControllerInterceptor.class);
	@Value("${spring.datasource.url:NO DS URL}")
	private String dataSourceURL;
	@Value("${spring.datasource.username:NO DS USERNAME}")
	private String dataSourceUserName;
	@Value("${vcap.services.party-service-app-db.name:NO VCAP DB NAME}")
	private String dataSourceDBName;
	@Value("${spring.datasource.password:NO PASSWORD}")
	private String dataSourcePassword;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("'preHandle' Method Calling!!!");
		LOGGER.info("Data Source URL : {}", dataSourceURL);
		LOGGER.info("Data Source DB Name : {}", dataSourceDBName);
		LOGGER.info("Data Source UserName : {}", dataSourceUserName);
		LOGGER.info("Data Source Password : {}", dataSourcePassword);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.info("'postHandle' Method Calling!!!");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		LOGGER.info("'afterCompletion' Method Calling!!!");
	}
}