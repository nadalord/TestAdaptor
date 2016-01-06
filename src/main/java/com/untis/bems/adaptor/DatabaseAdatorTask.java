package com.untis.bems.adaptor;

import org.springframework.stereotype.Component;

import com.untis.bems.domain.BemsHistory;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.service.adaptor.DevicePointService;
import com.untis.bems.service.bems.BemsHistoryService;
import com.untis.bems.service.bems.BemsPointService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	BemsPointService bemsPointService;
	
	@Autowired
	BemsHistoryService historyService;
	
	@Autowired
	DevicePointService devicePointService;
	
	@Scheduled(cron="*/5 * * * * *")
	public void run() {
		System.out.println("[Adaptor] running ");
		List<BemsPoint> bemsPoints = bemsPointService.getList(buildingMasterIdx, agentMasterIdx);
		Map<String, DevicePoint> devicePoints = devicePointService.getAll();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String date = dateFormat.format(new Date()); 
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
		String time = timeFormat.format(new Date()); 
		
		for (BemsPoint point : bemsPoints) {
			DevicePoint devicePoint = devicePoints.get(point.getPointId());
			if (devicePoint != null) {
				BemsHistory history = new BemsHistory();
				
				history.setDate(date);
				history.setTime(time);
				history.setPointListIdx(point.getPointListIdx());
				history.setPointValue(Integer.toString(point.getPointListIdx()));
				historyService.add(buildingMasterIdx, history);
			}
		}
	}
}
