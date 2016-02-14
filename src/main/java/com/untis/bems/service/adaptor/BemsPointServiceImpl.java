package com.untis.bems.service.adaptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untis.bems.domain.BemsPoint;
import com.untis.bems.mapper.adaptor.BemsPointMapper;

@Service
public class BemsPointServiceImpl implements BemsPointService {
	
	@Autowired
	BemsPointMapper pointMapper;	

	@Override
	public List<BemsPoint> getList(int buidMasterIx, int angetMasterIx) {		
		return pointMapper.getList(buidMasterIx, angetMasterIx);
	}
}