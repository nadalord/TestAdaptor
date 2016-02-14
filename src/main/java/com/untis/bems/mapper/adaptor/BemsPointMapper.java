package com.untis.bems.mapper.adaptor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.mapper.support.MasterMapper;

@MasterMapper
public interface BemsPointMapper {
	public List<BemsPoint> getList(@Param("buidMasterIx") int buidMasterIx, @Param("agentMasterIx") int agentMasterIx);
}