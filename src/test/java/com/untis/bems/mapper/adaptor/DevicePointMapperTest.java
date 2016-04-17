package com.untis.bems.mapper.adaptor;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.BemsAdaptorApplication;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.adaptor.ddc.ShinyoungDevicePointMapper;

public class DevicePointMapperTest extends AbstractTestableContext {
		
	private static final Logger logger = LoggerFactory.getLogger(BemsAdaptorApplication.class);
	
	@Autowired
	ShinyoungDevicePointMapper devicePointMapper;

	@Test
	public void selectList() {
		List<DevicePoint> points = devicePointMapper.getAll();	
		
		System.out.println("TEST");
	}
}
