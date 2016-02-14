package com.untis.bems.mapper.adaptor;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.service.adaptor.BemsPointService;

public class BemsPointMapperTest extends AbstractTestableContext {
	
	private static final Logger logger = LoggerFactory.getLogger(BemsPointMapperTest.class);
	
	@Resource
	int agentMasterIdx;
	
	@Resource
	int buildingMasterIdx;
	
	@Autowired
	BemsPointService pointService;	

	@Test
	public void getList() {
		List<BemsPoint> points = pointService.getList(1, 1);
		assertTrue("Point Count", points.size() > 0);
		
		logger.info("Test getList");
	
//		for (BemsPoint point : points) {
//			logger.info("point_id : {}", point.getPointId());
//		}
	}

}
