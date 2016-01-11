
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

import com.untis.bems.BemsAdaptorApplication;
import com.untis.bems.domain.BemsHistory;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.service.adaptor.DevicePointService;
import com.untis.bems.service.bems.BemsHistoryService;
import com.untis.bems.service.bems.BemsPointService;

@Service("ShinYoungDDC")
public class ShinYoungBemsAdaptor implements BemsAdaptor {
	
	private static final Logger logger = LoggerFactory.getLogger(ShinYoungBemsAdaptor.class);
	
	@Resource
	int agentMasterIdx;
	
	@Resource
	int buildingMasterIdx;
	
	@Autowired
	BemsPointService bemsPointService;
	
	@Autowired
	BemsHistoryService historyService;
	
	@Autowired
	DevicePointService devicePointService;
	
	public void run ()
	{
		logger.info("ShinYoung DDC Monitoring Started");
		
		List<BemsPoint> bemsPoints = bemsPointService.getList(buildingMasterIdx, agentMasterIdx);
		Map<String, DevicePoint> devicePoints = devicePointService.getAll();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
		String date = dateFormat.format(new Date()); 
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss"); 
		String time = timeFormat.format(new Date()); 
		
		// TODO 서비스 코드 추
	}
}
