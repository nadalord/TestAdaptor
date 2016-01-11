package com.untis.bems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.untis.bems.adaptor.BemsAdaptor;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableScheduling
@EnableJms
@SpringBootApplication
@ComponentScan(basePackages = "com.untis.bems")
public class BemsAdaptorApplication {
	private static final Logger logger = LoggerFactory.getLogger(BemsAdaptorApplication.class);
	
//	@Autowired
//	@Qualifier("ShinYongDDC")
//	BemsAdaptor bemsAdaptor;
	
	@PostConstruct
	public void running() {
		logger.info("running");
//		bemsAdaptor.run();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(BemsAdaptorApplication.class, args);
    }
}
