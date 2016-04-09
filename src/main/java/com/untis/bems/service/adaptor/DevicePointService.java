package com.untis.bems.service.adaptor;

import java.util.List;
import java.util.Map;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;

public interface DevicePointService {
	public DevicePoint get(BemsPoint bemsPoint);
	public Map<Integer, DevicePoint> getAll(List<BemsPoint> bemsPoints);
}
