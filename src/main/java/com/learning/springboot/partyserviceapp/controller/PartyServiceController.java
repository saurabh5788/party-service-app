package com.learning.springboot.partyserviceapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/partyservice")
public class PartyServiceController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyServiceController.class);
	@GetMapping(path = "/hello")
	public String helloParty() {
		LOGGER.info("Hello Party!!!");
		return "Hello Party!!!";
	}
}
