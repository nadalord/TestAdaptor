package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.bems.BemsPointMapperTest;

public class DevicePointServiceTest extends AbstractTestableContext {

	private static final Logger logger = LoggerFactory.getLogger(DevicePointServiceTest.class);
	
	@Autowired
	DevicePointService pointService;
		
	@Test
	public void getAll() {
		logger.info("Test getAll");
	
		Map<String, DevicePoint> maps = pointService.getAll();
		assertTrue(maps.size() > 1);
		
		for (Map.Entry<String, DevicePoint> entry : maps.entrySet()){
			logger.debug("DDC Bems Point [{} : {} : {}]", 
					entry.getValue().getPointId(), 
					entry.getValue().getPointName(),
					entry.getValue().getPointValue());
		}
	}
}
