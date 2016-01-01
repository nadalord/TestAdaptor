package com.untis.bems.service.bems;

import java.util.List;

import com.untis.bems.domain.PointInfo;

public interface PointService {
	public List<PointInfo> getList(int buidMasterIx, int angetMasterIx);
}
