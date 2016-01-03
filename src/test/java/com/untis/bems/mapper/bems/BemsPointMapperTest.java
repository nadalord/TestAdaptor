package com.untis.bems.mapper.bems;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.BemsAdaptorApplication;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.mapper.adaptor.DevicePointMapper;
import com.untis.bems.service.bems.BemsPointService;

public class BemsPointMapperTest extends AbstractTestableContext {
	
	private static final Logger logger = LoggerFactory.getLogger(BemsAdaptorApplication.class);
	
	@Autowired
	BemsPointService pointService;	

	@Test
	public void getList() {
		List<BemsPoint> points = pointService.getList(1, 1);
		
		for (BemsPoint point : points) {
			logger.info("point_id : {}", point.getPointId());
		}
	}

}
