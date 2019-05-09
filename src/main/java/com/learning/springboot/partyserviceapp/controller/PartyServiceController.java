package com.learning.springboot.partyserviceapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/partyservice")
public class PartyServiceController {
	@GetMapping(path = "/hello")
	public String helloParty() {
		return "Hello Party!!!";
	}

}
