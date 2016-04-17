package com.untis.bems.configure.application;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ApplicationProperties.PREFIX)
public class ApplicationProperties {
	
	public static final String PREFIX = "bems.application"; 
	
	int buildingMasterIdx;
	int agentMasterIdxForShinyoung;
	int agentMasterIdxForOmni;
	int agentMasterIdxForJunghoTLC;
	
	public int getBuildingMasterIdx() {
		return buildingMasterIdx;
	}
	public void setBuildingMasterIdx(int buildingMasterIdx) {
		this.buildingMasterIdx = buildingMasterIdx;
	}
	public int getAgentMasterIdxForShinyoung() {
		return agentMasterIdxForShinyoung;
	}
	public void setAgentMasterIdxForShinyoung(int agentMasterIdxForShinyoung) {
		this.agentMasterIdxForShinyoung = agentMasterIdxForShinyoung;
	}
	public int getAgentMasterIdxForOmni() {
		return agentMasterIdxForOmni;
	}
	public void setAgentMasterIdxForOmni(int agentMasterIdxForOmni) {
		this.agentMasterIdxForOmni = agentMasterIdxForOmni;
	}
	public int getAgentMasterIdxForJunghoTLC() {
		return agentMasterIdxForJunghoTLC;
	}
	public void setAgentMasterIdxForJunghoTLC(int agentMasterIdxForJunghoTLC) {
		this.agentMasterIdxForJunghoTLC = agentMasterIdxForJunghoTLC;
	}
}
