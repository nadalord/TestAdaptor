package com.untis.bems.service.bems;

import java.util.List;

import com.untis.bems.domain.BemsPoint;

public interface BemsPointService {
	public List<BemsPoint> getList(int buidMasterIx, int angetMasterIx);
}
