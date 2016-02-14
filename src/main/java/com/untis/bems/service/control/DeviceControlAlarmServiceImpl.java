package com.untis.bems.service.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.mapper.control.DeviceControlAlarmMapper;

@Service
public class DeviceControlAlarmServiceImpl implements DeviceControlAlarmService {

	@Autowired
	DeviceControlAlarmMapper controlAlarmMapper;
	
	@Override
	public int occur(int pointListIdx, String value) {
		 if (controlAlarmMapper.add(pointListIdx, value) > 0) {
			 return controlAlarmMapper.updateStatus(pointListIdx, "01");
		 }
		 return 0;
	}
}