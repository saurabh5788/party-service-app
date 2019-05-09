package com.learning.springboot.partyserviceapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PartyServiceControllerInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyServiceControllerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOGGER.info("'preHandle' Method Calling!!!");
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