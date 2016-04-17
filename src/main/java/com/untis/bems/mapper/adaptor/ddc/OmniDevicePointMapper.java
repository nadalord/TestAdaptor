package com.untis.bems.mapper.adaptor.ddc;

import java.util.List;

import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.support.OmniMeterMapper;

@OmniMeterMapper
public interface OmniDevicePointMapper {
	public List<DevicePoint> getAll();
}