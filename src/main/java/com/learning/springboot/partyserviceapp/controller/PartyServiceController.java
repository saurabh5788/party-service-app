package com.learning.springboot.partyserviceapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.partyserviceapp.entity.PartyEntity;
import com.learning.springboot.partyserviceapp.repository.PartyRepository;

@RestController
@RequestMapping(value = "/partyservice")
public class PartyServiceController {
	@Value("${eureka.instance.instance-id:NOT SET}")
	private String instanceId;
	@Autowired
	PartyRepository repository;

	@Autowired
	@Qualifier(value = "blankParty")
	PartyEntity blankParty;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyServiceController.class);
	@GetMapping(path = "/hello")
	public String helloParty() {
		LOGGER.info("Hello Party!!!");
		return "Hello Party!!!";
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<PartyEntity> find(@PathVariable("id") Long id) {
		LOGGER.info("Instance ID : {}",instanceId);
		PartyEntity party = repository.findOne(id);
		if (party == null) {
			// return new ResponseEntity<PartyEntity>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<PartyEntity>(blankParty,
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PartyEntity>(party, HttpStatus.OK);
	}
}
