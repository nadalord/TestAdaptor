package com.untis.bems.adaptor;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.service.adaptor.DevicePointService;

public class BemsAdaptorTest extends AbstractTestableContext  {
	
	@Resource
	int agentMasterIdxForShinyoung;

	@Autowired
	@Qualifier("shinyoungDatabaseDevicePoint")
	DevicePointService shinyoungDatabaseDevicePointService;
	
	@Resource
	int agentMasterIdxForOmni;
	
	@Autowired
	@Qualifier("omniDatabaseDevicePoint")
	DevicePointService omniDatabaseDevicePointService;
	
	@Resource
	int agentMasterIdxForJunghoTlc;
	
	@Autowired
	@Qualifier("modbusDevicePoint")
	DevicePointService modbusDevicePointService;
	
	@Autowired
	BemsAdaptor bemsAdaptor;
	
//	@Test
//	public void addBemsHistory() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
//		String date = dateFormat.format(new Date()); 
//		
//		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
//		String time = timeFormat.format(new Date()); 
//		
//		DevicePoint devicePoint = new DevicePoint();
//		devicePoint.setPointId("999");
//		devicePoint.setPointName("TestPoint");
//		devicePoint.setPointValue(999.0);
//		
//		assertTrue(bemsAdaptor.addBemsHistory(date, time, 1, devicePoint) > 0);
//	}
//	
	@Test
	public void run() {
		bemsAdaptor.setCurrentdate();
		bemsAdaptor.run(agentMasterIdxForShinyoung, shinyoungDatabaseDevicePointService);
		bemsAdaptor.run(agentMasterIdxForOmni, omniDatabaseDevicePointService);
		bemsAdaptor.run(agentMasterIdxForJunghoTlc, modbusDevicePointService);
	}
}
