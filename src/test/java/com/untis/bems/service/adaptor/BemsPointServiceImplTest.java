package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

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
import com.untis.bems.service.adaptor.DevicePointService;

public class BemsPointServiceImplTest extends AbstractTestableContext {

	private static final Logger logger = LoggerFactory.getLogger(BemsPointServiceImplTest.class);
	
	@Autowired
	BemsPointService pointService;
	
	@Test
	public void testGetList() {
		List<BemsPoint> bemsPoints = pointService.getList(1, 1);
		for (BemsPoint point : bemsPoints) {		
			logger.debug("Bems Point [poit_list_ix : {}," +
						 "point_id : {}, " +
						 "agent_master_idx : {}, " +
						 "agent_agent_ddc_idx : {}" +
						 "]", 
					point.getPointListIdx(), 
					point.getPointId(), 
					point.getAgentMasterIdx(),
					point.getAgentDDCIdx());
		}
	}
}
