package com.untis.bems.adaptor;

import org.springframework.stereotype.Component;

import com.untis.bems.mapper.bems.PointMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class DatabaseAdatorTask {
	
	@Autowired
	PointMapper pointMapper;	
	
	@Scheduled(cron="*/5 * * * * *")
	public void run() {
		System.out.println("[Adaptor] running ");
		pointMapper.getList(1, 1);
	}
}
