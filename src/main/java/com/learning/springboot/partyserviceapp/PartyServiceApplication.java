package com.learning.springboot.partyserviceapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.learning.springboot.partyserviceapp.entity.PartyEntity;

@SpringBootApplication
public class PartyServiceApplication implements ApplicationRunner, CommandLineRunner{
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${server.port:NO PORT}")
	private String applicationPort;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PartyServiceApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		LOGGER.info("ApplicationRunner - {}:{}", applicationName,applicationPort);
	}

	@Override
	public void run(String... arg0) throws Exception {
		LOGGER.info("CommandLineRunner - {}:{}", applicationName,applicationPort);
	}
	
	@Bean(name = "blankParty")
	public PartyEntity getBlankPartyEntity() {
		return new PartyEntity();
	}

	@Bean(name = "dummyParty")
	public PartyEntity getDummyPartyEntity() {
		PartyEntity pe = new PartyEntity();
		pe.setId(123L);
		pe.setName("Saurabh");
		pe.setEmail("xyz@gma.com");
		return pe;
	}
}
