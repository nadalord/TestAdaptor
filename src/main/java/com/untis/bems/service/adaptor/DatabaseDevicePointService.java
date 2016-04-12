package com.untis.bems.service.adaptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;


public abstract class DatabaseDevicePointService implements DevicePointService {

	protected abstract Map<String, DevicePoint> getAll();
	
	public DevicePoint get(BemsPoint bemsPoint) {
		Map<String, DevicePoint> devicePoints = getAll();		
		DevicePoint devicePoint = devicePoints.get(bemsPoint.getPointId());
		return devicePoint;
	}
	
	public Map<Integer, DevicePoint> getAll(List<BemsPoint> bemsPoints) {
		Map<String, DevicePoint> devicePoints = getAll();	
		
		Map<Integer, DevicePoint> maps = new HashMap<Integer, DevicePoint>();
		for (BemsPoint point : bemsPoints) {
			DevicePoint devicePoint = devicePoints.get(point.getPointId());
			if (devicePoint != null) {				
				maps.put(point.getPointListIdx(), devicePoint);
			}
		}
		return maps;
	}
}
