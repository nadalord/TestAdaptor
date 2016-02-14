package com.untis.bems.service.control;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;

public class DeviceControlAlarmTest extends AbstractTestableContext  {

	@Autowired
	DeviceControlAlarmService controlAlarmService;
	
	@Test
	public void add() {
		assertTrue(controlAlarmService.occur(1, "9.0") > 0);
	}
}
