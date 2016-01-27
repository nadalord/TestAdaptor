package com.untis.bems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.untis.bems.domain.ControlMessage;

@RestController
public class DeviceControlController {
	
    @RequestMapping("/test")
    public ControlMessage getTest() {
        ControlMessage message =  new ControlMessage();
        message.setPointListIdx(1);
        message.setValue("10");
        return message;
    }
    
    @RequestMapping("/device-control")
    public String controlDevice() {
        return new String("OK");
    }
}
