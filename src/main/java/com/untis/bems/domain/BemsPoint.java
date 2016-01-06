package com.untis.bems.domain;

public class BemsPoint {
	int pointListIdx;
	String pointId;
	String objectId;
	String primitiveType;
	String priority;
	String agentProtocol;
	String privateIp;

	public int getPointListIdx() {
		return pointListIdx;
	}

	public void setPointListIdx(int pointListIdx) {
		this.pointListIdx = pointListIdx;
	}
	
	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getPrimitiveType() {
		return primitiveType;
	}

	public void setPrimitiveType(String primitiveType) {
		this.primitiveType = primitiveType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAgentProtocol() {
		return agentProtocol;
	}

	public void setAgentProtocol(String agentProtocol) {
		this.agentProtocol = agentProtocol;
	}	

	public String getPrivateIp() {
		return privateIp;
	}

	public void setPrivateIp(String privateIp) {
		this.privateIp = privateIp;
	}

	@Override
	public String toString() {
		return "PointList [pointId=" + pointId + ", objectId=" + objectId + ", primitiveType=" + primitiveType
				+ ", priority=" + priority + ", agentProtocol=" + agentProtocol + "]";
	}
}
