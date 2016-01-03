package com.untis.bems.mapper.adaptor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.support.AgentMapper;

@AgentMapper
public interface DevicePointMapper {
	public List<DevicePoint> getAll();
}
