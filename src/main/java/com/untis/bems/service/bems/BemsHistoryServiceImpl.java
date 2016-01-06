package com.untis.bems.service.bems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsHistory;
import com.untis.bems.mapper.bems.BemsHistoryMapper;

@Service
public class BemsHistoryServiceImpl implements BemsHistoryService {
	
	@Autowired
	BemsHistoryMapper historyMapper;
	
	public int add(int buildingMasterIdx, BemsHistory bemsHistory) {
		return historyMapper.add(buildingMasterIdx, bemsHistory);
	}
}
