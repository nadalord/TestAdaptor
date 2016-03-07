package com.untis.bems.service.adaptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.adaptor.DevicePointMapper;

@Service("databaseDevicePoint")
public class DatabaseDevicePointServiceImpl implements DevicePointService {
	
	@Autowired
	DevicePointMapper devicePointMapper;
	
	private Map<String, DevicePoint> getPointAll() {
		List<DevicePoint> points = devicePointMapper.getAll();
		Map<String, DevicePoint> maps = new HashMap<String, DevicePoint>();
		for (DevicePoint point : points) {
			maps.put(point.getPointId(), point);
		}
		return maps;
	}
	
	public Map<Integer, DevicePoint> getAll(List<BemsPoint> bemsPoints) {
		Map<String, DevicePoint> devicePoints = getPointAll();	
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
