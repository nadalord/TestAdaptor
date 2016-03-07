
package com.untis.bems.adaptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsHistory;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.service.adaptor.BemsHistoryService;
import com.untis.bems.service.adaptor.BemsPointService;
import com.untis.bems.service.adaptor.DevicePointService;

@Service
public class BemsAdaptor {
	
	@Resource
	int buildingMasterIdx;
	
	@Autowired
	BemsPointService bemsPointService;
	
	@Autowired
	BemsHistoryService historyService;
	
	public List<BemsPoint> getBemsPointList(int agentMasterIdx) {
		return  bemsPointService.getList(buildingMasterIdx, agentMasterIdx);
	}
	
	public int addBemsHistory(String date, String time, int pointListIdx, DevicePoint point) {
		BemsHistory history = new BemsHistory();
		history.setDate(date);
		history.setTime(time);
		history.setPointListIdx(pointListIdx);
		history.setPointValue(point.getPointValue());		
		return historyService.add(buildingMasterIdx, history);
	}
	
	public void run (int agentMasterIdx, DevicePointService devicePointService) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String date = dateFormat.format(new Date()); 
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
		String time = timeFormat.format(new Date()); 
		
		List<BemsPoint> bemsPoints = getBemsPointList(agentMasterIdx);
		Map<Integer, DevicePoint> devicePoints = devicePointService.getAll(bemsPoints);	
		for (Map.Entry<Integer, DevicePoint> entry : devicePoints.entrySet()) {		
			addBemsHistory(date, time, entry.getKey(), entry.getValue());
		}
	}
}
