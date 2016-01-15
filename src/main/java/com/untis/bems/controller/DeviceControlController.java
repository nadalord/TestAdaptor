package com.untis.bems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceControlController {
	
    @RequestMapping("/device-control")
    public String controlDevice() {
        return new String("Test");
    }

}
