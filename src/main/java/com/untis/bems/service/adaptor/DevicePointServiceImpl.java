package com.untis.bems.service.adaptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.adaptor.DevicePointMapper;

@Service
public class DevicePointServiceImpl implements DevicePointService {
	
	@Autowired
	DevicePointMapper devicePointMapper;
	
	public Map<String, DevicePoint> getAll() {
		List<DevicePoint> points = devicePointMapper.getAll();
		Map<String, DevicePoint> maps = new HashMap<String, DevicePoint>();
		for (DevicePoint point : points) {
			maps.put(point.getPointId(), point);
		}
		return maps;
	}
}
