package com.untis.bems.tasks;

import org.springframework.stereotype.Component;

import com.untis.bems.adaptor.BemsAdaptor;
import com.untis.bems.service.adaptor.DevicePointService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class BemsAdatorTask {
	
	@Autowired
	BemsAdaptor bemsAdaptor;
	
	@Resource
	int agentMasterIdx;

	@Autowired
	@Qualifier("databaseDevicePoint")
	DevicePointService databaseDevicePointService;
	
	@Autowired
	@Qualifier("modbusDevicePoint")
	DevicePointService modbusDevicePointService;
	
	@Scheduled(cron="0 */15 * * * *")
	public void run() {
		bemsAdaptor.run(agentMasterIdx, databaseDevicePointService);
	}
}