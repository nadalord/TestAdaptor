package com.untis.bems.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.ControlMessage;
import com.untis.bems.service.adaptor.BemsPointService;
import com.untis.bems.service.control.DeviceControlAlarmService;
import com.untis.bems.service.control.DeviceControlService;

@RestController
public class DeviceControlController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceControlController.class);
	
	@Autowired
	BemsPointService bemsPoistService;
	
	@Autowired
	DeviceControlService controlService;
	
	@Autowired
	DeviceControlAlarmService controlAlarmService;
	
	@Resource
	int buildingMasterIdx;
	
    @RequestMapping(value="/device-control", method=RequestMethod.POST)
    @ResponseBody
    public String controlDevice(@RequestBody ControlMessage controlMessage) {
    	
    	logger.debug("[POST] DDC Control Start (pointListIdx : {}, value : {})", 
    			controlMessage.getPointListIdx(), 
    			controlMessage.getValue());
    	
    	BemsPoint bemsPoint = bemsPoistService.get(buildingMasterIdx, controlMessage.getPointListIdx());
    	if (bemsPoint == null) {
    		logger.error("Invalid Point List Index : {}", controlMessage.getPointListIdx());
    		return new String("Invalid Point List Index");
    	}
    	
    	if (controlService.control(bemsPoint.getPointId(), controlMessage.getValue()) <= 0) {
    		return new String("DDC Control Fail");
    	}
    	
    	controlAlarmService.occur(controlMessage.getPointListIdx(), controlMessage.getValue());
        return new String("OK");
    }
   
    @RequestMapping(value="/device-control", method=RequestMethod.GET)
    public String controlDevice2(@RequestParam(value="pointListIdx") int pointListIdx, 
    							@RequestParam(value="value") String value) {
    	
    	logger.debug("[POST] DDC Control Start (pointListIdx : {}, value : {})", 
    			pointListIdx, 
    			value);
    	
    	BemsPoint bemsPoint = bemsPoistService.get(buildingMasterIdx, pointListIdx);
    	if (bemsPoint == null) {
    		logger.error("Invalid Point List Index : {}", pointListIdx);
    		return new String("Invalid Point List Index");
    	}
    	
    	if (controlService.control(bemsPoint.getPointId(), value) <= 0) {
    		return new String("DDC Control Fail");
    	}
    	
    	controlAlarmService.occur(pointListIdx, value);
        return new String("OK");
    }
}