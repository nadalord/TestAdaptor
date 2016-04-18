package com.untis.bems.adaptor;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;

public class BemsAdaptorTest extends AbstractTestableContext  {
	
	@Autowired
	BemsAdaptor bemsAdaptor;
	
	@Test
	public void addBemsHistory() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String date = dateFormat.format(new Date()); 
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
		String time = timeFormat.format(new Date()); 
		
		DevicePoint devicePoint = new DevicePoint();
		devicePoint.setPointId("999");
		devicePoint.setPointName("TestPoint");
		devicePoint.setPointValue(999.0);
		
		assertTrue(bemsAdaptor.addBemsHistory(date, time, 1, devicePoint) > 0);
	}
	
	@Test
	public void evaluateBemsformula() {
		
		List<BemsPoint> bemsPoints = new ArrayList<BemsPoint>();
		BemsPoint point = new BemsPoint();
		point.setPointListIdx(1);
		point.setFormula("X+1, X:1");
		
		Map<Integer, DevicePoint> devicePoints = new HashMap<Integer, DevicePoint>();
		DevicePoint devicePoint = new DevicePoint();
		devicePoint.setPointId("1");
		devicePoint.setPointName("TEST");
		devicePoint.setPointValue(10.0);
		devicePoints.put(1, devicePoint);
		
		bemsAdaptor.evaluateformula(bemsPoints, devicePoints);
		assertEquals(devicePoints.get(1).getPointValue(), 2.0);
		
		DevicePoint devicePoint2 = new DevicePoint();
		devicePoint.setPointId("2");
		devicePoint.setPointName("TEST2");
		devicePoint.setPointValue(2.0);
		devicePoints.put(2, devicePoint2);
		
		//bemsAdaptor.evaluateBemsformula(bemsPoints, devicePoints);
	}
}
