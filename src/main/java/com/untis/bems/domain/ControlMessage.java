package com.untis.bems.domain;

public class ControlMessage {
	int pointListIdx;
	String value;
	
	public int getPointListIdx() {
		return pointListIdx;
	}
	public void setPointListIdx(int pointListIdx) {
		this.pointListIdx = pointListIdx;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}