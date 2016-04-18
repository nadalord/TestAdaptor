package com.untis.bems.domain;

public class BemsHistory {
	String date;
	String time;
	int pointListIdx;
	double pointValue;
	double pointChangeValue;
	
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
	public double getPointValue() {
		return pointValue;
	}
	public void setPointValue(double pointValue) {
		this.pointValue = pointValue;
	}
	public double getPointChangeValue() {
		return pointChangeValue;
	}
	public void setPointChangeValue(double pointChangeValue) {
		this.pointChangeValue = pointChangeValue;
	}
}
