package com.untis.bems.mapper.control;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.mapper.support.AgentMapper;

@AgentMapper
public interface DeviceControlMapper {
	public int update(@Param("pointListIdx") int pointListIdx, @Param("value") String value);
}
