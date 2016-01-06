package com.untis.bems.mapper.bems;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.BemsHistory;


public class BemsHistoryMapperTest extends AbstractTestableContext {
	
	private static final Logger logger = LoggerFactory.getLogger(BemsHistoryMapperTest.class);
	
	@Autowired
	BemsHistoryMapper historyMapper;	
	
	@Resource
	int buildingMasterIdx;

	@Test
	public void add() {
		BemsHistory history = new BemsHistory();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String date = dateFormat.format(new Date()); 
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
		String time = timeFormat.format(new Date()); 
		
		history.setDate(date);
		history.setTime(time);
		history.setPointListIdx(11);
		history.setPointValue("100.005");
		
		assertEquals(historyMapper.add(buildingMasterIdx, history), 1);
	}

}
