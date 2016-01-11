package com.untis.bems.tasks;

import org.springframework.stereotype.Component;

import com.untis.bems.adaptor.BemsAdaptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class DatabaseAdatorTask {
	
//	@Autowired
//	@Qualifier("ShinYoungDDC")
//	BemsAdaptor bemsAdaptor;
	
	@Autowired
	@Qualifier("TestDDC")
	BemsAdaptor bemsAdaptor;
	
	@Scheduled(cron="10 */15 * * * *")
	public void run() {
		bemsAdaptor.run();
	}
}