package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.adaptor.BemsPointMapperTest;

public class DatabaseDevicePointServiceTest extends AbstractTestableContext {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseDevicePointServiceTest.class);
	
	@Autowired
	BemsPointService bemsPointService;
	
	@Autowired
	@Qualifier("databaseDevicePoint")
	DevicePointService devicePointService;
		
	@Test
	public void getAll() {
		logger.info("Test getAll");
		
		List<BemsPoint> bemsPoints = bemsPointService.getList(1, 1);
		assertTrue(bemsPoints.size() > 1);
		
		Map<Integer, DevicePoint> maps = devicePointService.getAll(bemsPoints);
		assertTrue(maps.size() > 1);
		
		for (Map.Entry<Integer, DevicePoint> entry : maps.entrySet()){
			logger.debug("DDC Bems Point [{} : {} : {}]", 
					entry.getValue().getPointId(), 
					entry.getValue().getPointName(),
					entry.getValue().getPointValue());
		}
	}
}