package com.untis.bems.domain;

public class BemsHistory {
	String date;
	String time;
	int pointListIdx;
	String pointValue;
	String pointChangeValue;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPointListIdx() {
		return pointListIdx;
	}
	public void setPointListIdx(int pointListIdx) {
		this.pointListIdx = pointListIdx;
	}
	public String getPointValue() {
		return pointValue;
	}
	public void setPointValue(String pointValue) {
		this.pointValue = pointValue;
	}
	public String getPointChangeValue() {
		return pointChangeValue;
	}
	public void setPointChangeValue(String pointChangeValue) {
		this.pointChangeValue = pointChangeValue;
	}
}
