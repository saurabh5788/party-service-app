package com.learning.springboot.partyserviceapp;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learning.springboot.partyserviceapp.entity.PartyEntity;

@SpringBootApplication
public class PartyServiceApplication implements ApplicationRunner,
		CommandLineRunner {
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${server.port:NO PORT}")
	private String applicationPort;
	@Value("${spring.profiles.active:NO ACTIVE PROFILE}")
	private String activeProfile;
	
	@Value("${spring.datasource.url:NO DS URL}")
	private String dataSourceURL;
	@Value("${spring.datasource.username:NO DS USERNAME}")
	private String dataSourceUserName;
	@Value("${vcap.services.cleardb.name:NO VCAP DB NAME}")
	private String dataSourceDBName;
	@Value("${spring.datasource.password:NO PASSWORD}")
	private String dataSourcePassword;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PartyServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		LOGGER.info("ApplicationRunner - {}:{}", applicationName,
				applicationPort);
		Set<String> optionNameSet = arg0.getOptionNames();
		int optionNameIndex = 0;
		for(String optionName : optionNameSet){
			LOGGER.info("Argument ({}) : {}", ++optionNameIndex, optionName);
		}		
	}

	@Override
	public void run(String... arg0) throws Exception {
		LOGGER.info("CommandLineRunner - {}:{}", applicationName,
				applicationPort);
		LOGGER.info("Application Name : {}", applicationName);
		LOGGER.info("Application Port : {}", applicationPort);
		LOGGER.info("Active Profile : {}", activeProfile);
		LOGGER.info("Data Source URL : {}", dataSourceURL);
		LOGGER.info("Data Source DB Name : {}", dataSourceDBName);
		LOGGER.info("Data Source UserName : {}", dataSourceUserName);
		LOGGER.info("Data Source Password : {}", dataSourcePassword);
		
		int argIndex = 0;
		for (String arg : arg0) {
			LOGGER.info("Argument ({}) : {}", ++argIndex, arg);
		}
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
