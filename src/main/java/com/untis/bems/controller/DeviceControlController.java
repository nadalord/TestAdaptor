package com.untis.bems.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.untis.bems.domain.ControlMessage;
import com.untis.bems.service.control.DeviceControlAlarmService;
import com.untis.bems.service.control.DeviceControlService;

@RestController
public class DeviceControlController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceControlController.class);
	
	@Autowired
	DeviceControlService controlService;
	
	@Autowired
	DeviceControlAlarmService controlAlarmService;
	
    @RequestMapping(value="/device-control", method=RequestMethod.GET)
    public String controlDevice(@RequestParam(value="pointListIdx") int pointListIdx, 
    							@RequestParam(value="value") String value) {
    	
    	logger.debug("DDC Control Start (pointListIdx : {}, value : {})", pointListIdx, value);
    	
    	controlAlarmService.occur(pointListIdx, value);
    	
        return new String("OK");
    }
}