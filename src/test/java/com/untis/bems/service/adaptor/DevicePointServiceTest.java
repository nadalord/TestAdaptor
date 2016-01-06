package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;

public class DevicePointServiceTest extends AbstractTestableContext {

	@Autowired
	DevicePointService pointService;
		
	@Test
	public void getAll() {
		assertTrue(pointService.getAll().size() > 1);
	}

}
