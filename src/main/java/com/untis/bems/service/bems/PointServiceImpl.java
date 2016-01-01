package com.untis.bems.service.bems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.PointInfo;
import com.untis.bems.mapper.bems.PointMapper;

@Service
public class PointServiceImpl implements PointService {
	
	@Autowired
	PointMapper pointMapper;	

	@Override
	public List<PointInfo> getList(int buidMasterIx, int angetMasterIx) {		
		return pointMapper.getList(buidMasterIx, angetMasterIx);
	}

}