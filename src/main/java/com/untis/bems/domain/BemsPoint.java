package com.untis.bems.domain;

public class BemsPoint {
	int pointListIdx;
	String pointId;
	String objectId;
	String primitiveType;
	String deviceId;
	int functionCode;
	int dataType;
	String priority;
	String formula;
	int agentMasterIdx;
	String agentProtocol;
	int agentDDCIdx;
	String privateIp;
	int port;
	
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
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(int functionCode) {
		this.functionCode = functionCode;
	}
	public int getDataType() {
		return dataType;
	}
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public int getAgentMasterIdx() {
		return agentMasterIdx;
	}
	public void setAgentMasterIdx(int agentMasterIdx) {
		this.agentMasterIdx = agentMasterIdx;
	}
	public String getAgentProtocol() {
		return agentProtocol;
	}
	public void setAgentProtocol(String agentProtocol) {
		this.agentProtocol = agentProtocol;
	}
	public int getAgentDDCIdx() {
		return agentDDCIdx;
	}
	public void setAgentDDCIdx(int agentDDCIdx) {
		this.agentDDCIdx = agentDDCIdx;
	}
	public String getPrivateIp() {
		return privateIp;
	}
	public void setPrivateIp(String privateIp) {
		this.privateIp = privateIp;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return "BemsPoint [pointListIdx=" + pointListIdx + ", pointId=" + pointId + ", objectId=" + objectId
				+ ", primitiveType=" + primitiveType + ", priority=" + priority + ", agentMasterIdx=" + agentMasterIdx
				+ ", agentProtocol=" + agentProtocol + ", agentDDCIdx=" + agentDDCIdx + ", privateIp=" + privateIp
				+ ", port=" + port + "]";
	}
}
