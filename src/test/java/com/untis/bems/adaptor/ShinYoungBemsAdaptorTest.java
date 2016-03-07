package com.untis.bems.adaptor;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.DevicePoint;

public class ShinYoungBemsAdaptorTest extends AbstractTestableContext  {
	
	@Autowired
	BemsAdaptor bemsAdaptor;
	
	@Test
	public void testAddBemsHistory() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String date = dateFormat.format(new Date()); 
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
		String time = timeFormat.format(new Date()); 
		
		DevicePoint devicePoint = new DevicePoint();
		devicePoint.setPointId("999");
		devicePoint.setPointName("TestPoint");
		devicePoint.setPointValue("999");
		
		assertTrue(bemsAdaptor.addBemsHistory(date, time, 1, devicePoint) > 0);
	}
}
