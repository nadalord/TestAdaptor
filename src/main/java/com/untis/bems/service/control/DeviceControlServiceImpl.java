package com.untis.bems.service.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.mapper.control.DeviceControlMapper;

@Service
public class DeviceControlServiceImpl implements DeviceControlService {
	
	@Autowired
	DeviceControlMapper controlMapper;
	
	@Override
	public int control(int pointListIdx, String value) {
		return controlMapper.update(pointListIdx, value);
	}
}