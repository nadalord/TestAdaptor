package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.service.adaptor.DevicePointService;

public class BemsPointServiceImplTest extends AbstractTestableContext {

	private static final Logger logger = LoggerFactory.getLogger(BemsPointServiceImplTest.class);
	
	@Autowired
	BemsPointService pointService;
	
	@Autowired
	DevicePointService devicePointService;
	
	@Test
	public void testGetList() {
		List<BemsPoint> bemsPoints = pointService.getList(1, 1);
		Map<Integer, DevicePoint> devicePoints = devicePointService.getAll(bemsPoints);
		
		for (Map.Entry<Integer, DevicePoint> entry : devicePoints.entrySet()) {		
			logger.debug("Bems Point [{} : {}]", entry.getKey(), entry.getValue().getPointId());
		}
	}
}
