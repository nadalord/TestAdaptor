package com.untis.bems.service.adaptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;

@Service("modbusDevicePoint")
public class ModbusDevicePointServiceImpl implements DevicePointService {
	public Map<Integer, DevicePoint> getAll(List<BemsPoint> bemsPoints) {
		Map<Integer, DevicePoint> maps = new HashMap<Integer, DevicePoint>();
		return maps;
	}
}
