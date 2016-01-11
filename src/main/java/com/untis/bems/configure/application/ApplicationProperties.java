package com.untis.bems.configure.application;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ApplicationProperties.PREFIX)
public class ApplicationProperties {
	
	public static final String PREFIX = "bems.application"; 
	
	String ddcName;
	int agentMasterIdx;
	int buildingMasterIdx;
	
	public String getDdcName() {
		return ddcName;
	}
	public void setDdcName(String ddcName) {
		this.ddcName = ddcName;
	}
	public int getAgentMasterIdx() {
		return agentMasterIdx;
	}
	public void setAgentMasterIdx(int agentMasterIdx) {
		this.agentMasterIdx = agentMasterIdx;
	}
	public int getBuildingMasterIdx() {
		return buildingMasterIdx;
	}
	public void setBuildingMasterIdx(int buildingMasterIdx) {
		this.buildingMasterIdx = buildingMasterIdx;
	}
}
