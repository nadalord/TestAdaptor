
package com.untis.bems.adaptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsHistory;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.parser.BemsExpressionParser;
import com.untis.bems.service.adaptor.BemsHistoryService;
import com.untis.bems.service.adaptor.BemsPointService;
import com.untis.bems.service.adaptor.DevicePointService;

@Service
public class BemsAdaptor {
	
	private static final Logger logger = LoggerFactory.getLogger(BemsAdaptor.class);
	
	@Resource
	int buildingMasterIdx;
	
	@Autowired
	BemsPointService bemsPointService;
	
	@Autowired
	BemsHistoryService historyService;
	
	String date;
	String time;
	
	public void setDate(String date, String time) {
		this.date = date;
		this.time = time;
	}
	
	public void setCurrentdate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 	
		setDate(dateFormat.format(new Date()), timeFormat.format(new Date()));
	}
	
	public List<BemsPoint> getBemsPointList(int agentMasterIdx) {
		return  bemsPointService.getList(buildingMasterIdx, agentMasterIdx);
	}
	
	public void addBemsHistory(Map<Integer, DevicePoint> devicePoints) {
		for (Map.Entry<Integer, DevicePoint> entry : devicePoints.entrySet()) {		
			BemsHistory history = new BemsHistory();
			history.setDate(date);
			history.setTime(time);
			history.setPointListIdx(entry.getKey());
			history.setPointValue(entry.getValue().getPointValue());		
			historyService.add(buildingMasterIdx, history);
		}
	}
	
	public void evaluateformula(List<BemsPoint> bemsPoints, Map<Integer, DevicePoint> devicePoints) {
		BemsExpressionParser parser = new BemsExpressionParser();
		parser.addDataSource("$", devicePoints);
		
		for (BemsPoint bemsPoint : bemsPoints) {
			DevicePoint devicePoint = devicePoints.get(bemsPoint.getPointListIdx());
			if (devicePoint == null) {
				logger.debug("device point id not found. {}", bemsPoint.getPointListIdx());
				continue;
			}
			if (bemsPoint.getFormula() == null || bemsPoint.getFormula().isEmpty() == true) {
				continue;
			}
			
			String formula  = Double.toString(devicePoint.getPointValue()) + bemsPoint.getFormula();
			parser.setExpression(formula);
			double pointValue = parser.evaluate();
			devicePoint.setPointValue(parser.evaluate());
			
			logger.debug("bems formula evaluate. [point_list_idx : {}, formula : {}, point_value : {}", 
					bemsPoint.getPointListIdx(), formula, pointValue);
		}
	}
	
	public void run (int agentMasterIdx, DevicePointService devicePointService) {
		
		// Get BEMS Point Information 
		List<BemsPoint> bemsPoints = getBemsPointList(agentMasterIdx);
		
		// Get Point Value From Device
		Map<Integer, DevicePoint> devicePoints = devicePointService.getAll(bemsPoints);	
		
		// Evaluate Formula
		evaluateformula(bemsPoints, devicePoints);
		
		// Save Point Value To BEMS Database
		addBemsHistory(devicePoints);
	}
}
