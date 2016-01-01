package com.untis.bems.mapper.adaptor;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.BemsAdaptorApplication;
import com.untis.bems.domain.CurrentPoint;
import com.untis.bems.domain.PointInfo;

public class CurrentPointMapperTest extends AbstractTestableContext {
		
	private static final Logger logger = LoggerFactory.getLogger(BemsAdaptorApplication.class);
	
	@Autowired
	CurrentPointMapper currentPointMapper;

	@Test
	public void selectList() {
		List<CurrentPoint> points = currentPointMapper.getAll();	
		
		System.out.println("TEST");

	}
}
