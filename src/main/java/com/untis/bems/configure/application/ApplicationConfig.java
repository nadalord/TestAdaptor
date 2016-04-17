package com.untis.bems.configure.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
class ApplicationConfig {

	@Autowired
	private ApplicationProperties applicationProperties;

	@Bean
	public int buildingMasterIdx() {
		return applicationProperties.getBuildingMasterIdx();
	}
	
	@Bean
	public int agentMasterIdxForShinyoung() {
		return applicationProperties.getAgentMasterIdxForShinyoung();
	}
	
	@Bean
	public int agentMasterIdxForOmni() {
		return applicationProperties.getAgentMasterIdxForOmni();
	}
	
	@Bean
	public int agentMasterIdxForJunghoTLC() {
		return applicationProperties.getAgentMasterIdxForJunghoTLC();
	}
}