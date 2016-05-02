package com.untis.bems.tasks;

import org.springframework.stereotype.Component;

import com.untis.bems.adaptor.BemsAdaptor;
import com.untis.bems.service.adaptor.DevicePointService;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class BemsAdatorTask {
	
	@Autowired
	BemsAdaptor bemsAdaptor;
	
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
	
	@Scheduled(cron="0 */15 * * * *")
	public void run() {
		bemsAdaptor.setCurrentdate();
		bemsAdaptor.run(agentMasterIdxForShinyoung, shinyoungDatabaseDevicePointService);
		bemsAdaptor.run(agentMasterIdxForOmni, omniDatabaseDevicePointService);
		bemsAdaptor.run(agentMasterIdxForJunghoTlc, modbusDevicePointService);
	}
}