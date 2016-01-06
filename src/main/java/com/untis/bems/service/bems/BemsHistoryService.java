package com.untis.bems.service.bems;

import com.untis.bems.domain.BemsHistory;

public interface BemsHistoryService {
	public int add(int buildingMasterIdx, BemsHistory bemsHistory);
}
