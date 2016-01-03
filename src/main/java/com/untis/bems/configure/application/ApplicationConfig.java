package com.untis.bems.configure.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
class ApplicationConfig {
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	@Bean
	 public int agentMasterIdx() {
		return applicationProperties.getAgentMasterIdx();
    }
	
	@Bean
	 public int buildingMasterIdx() {
		return applicationProperties.getBuildingMasterIdx();
   }
}