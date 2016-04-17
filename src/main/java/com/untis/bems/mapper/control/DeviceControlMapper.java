package com.untis.bems.mapper.control;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.mapper.support.ShinyoungDDCMapper;

@ShinyoungDDCMapper
public interface DeviceControlMapper {
	public int update(@Param("pointId") String pointId, @Param("value") String value);
	public int add(@Param("pointId") String pointId, @Param("value") String value);
}
