package com.untis.bems.mapper.control;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.mapper.support.MasterMapper;

@MasterMapper
public interface DeviceControlAlarmMapper {
	public int updateStatus(@Param("pointListIdx") int pointListIdx, @Param("status") String status);
	public int add(@Param("pointListIdx") int pointListIdx, @Param("value") String value);
}
