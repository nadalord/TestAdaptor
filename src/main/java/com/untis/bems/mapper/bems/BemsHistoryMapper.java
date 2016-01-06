package com.untis.bems.mapper.bems;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.untis.bems.domain.BemsHistory;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.mapper.support.MasterMapper;

@MasterMapper
public interface BemsHistoryMapper {
	public int add(@Param("buildingMasterIdx") int buildingMasterIdx, @Param("history") BemsHistory bemsHistory);
}