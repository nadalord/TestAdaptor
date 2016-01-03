package com.untis.bems.configure.application;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.untis.bems.AbstractTestableContext;

public class ApplicationConfigTest extends AbstractTestableContext {

	@Resource
	int agentMasterIdx;
	
	@Resource
	int buildingMasterIdx;
	
	@Test
	public void testAgentMasterIdx() {
		assertTrue(agentMasterIdx == 1);
	}

	@Test
	public void testBuildingMasterIdx() {
		assertTrue(buildingMasterIdx == 1);
	}

}
