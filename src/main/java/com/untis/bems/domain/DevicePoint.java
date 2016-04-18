package com.untis.bems.domain;

public class DevicePoint {		
	String pointId;	
	String pointName;
	double pointValue;	

	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public double getPointValue() {
		return pointValue;
	}
	public void setPointValue(double pointValue) {
		this.pointValue = pointValue;
	}
}
