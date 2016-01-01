package com.untis.bems.mapper.bems;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.domain.PointInfo;
import com.untis.bems.mapper.support.MasterMapper;

@MasterMapper
public interface PointMapper {
	public List<PointInfo> getList(@Param("buidMasterIx") int buidMasterIx, @Param("agentMasterIx") int agentMasterIx);
}