package com.untis.bems.adaptor;

import org.springframework.stereotype.Component;

import com.untis.bems.service.bems.BemsPointService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class DatabaseAdatorTask {
	
	@Resource
	int agentMasterIdx;
	
	@Resource
	int buildingMasterIdx;
	
	@Autowired
	BemsPointService pointService;
	
	@Scheduled(cron="*/5 * * * * *")
	public void run() {
		System.out.println("[Adaptor] running ");
		pointService.getList(buildingMasterIdx, agentMasterIdx);
	}
}
