package com.untis.bems.mapper.adaptor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.domain.CurrentPoint;
import com.untis.bems.mapper.support.AgentMapper;

@AgentMapper
public interface CurrentPointMapper {
	public List<CurrentPoint> getAll();
}
