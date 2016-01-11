package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.mapper.bems.BemsPointMapperTest;

public class DevicePointServiceTest extends AbstractTestableContext {

	private static final Logger logger = LoggerFactory.getLogger(DevicePointServiceTest.class);
	
	@Autowired
	DevicePointService pointService;
		
	@Test
	public void getAll() {
		logger.info("Test getAll");
		assertTrue(pointService.getAll().size() > 1);
	}

}
