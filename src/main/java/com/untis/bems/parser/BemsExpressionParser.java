package com.untis.bems.parser;

import java.util.HashMap;
import java.util.Map;

import com.untis.bems.domain.DevicePoint;

public class BemsExpressionParser {
	private Map<String, Map<Integer, DevicePoint>> dataSourceMap = new HashMap<String, Map<Integer, DevicePoint>>();
	private String expression = null;
	
	public void addDataSource(String identifier, Map<Integer, DevicePoint> deviceMap) {
		this.dataSourceMap.put(identifier, deviceMap);
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public double evaluate() throws IllegalArgumentException {
		ExpressionParser parser = new ExpressionParser(this.expression);
		Map<String, String> varMap = parser.parseVariables();
		for (Map.Entry<String, String> entry : varMap.entrySet()) {
			String value = entry.getValue();
			Map<Integer, DevicePoint> dataMap = this.dataSourceMap.get(String.valueOf(value.charAt(0)));
			if (dataMap != null) {
				DevicePoint point = dataMap.get(Integer.parseInt(value.substring(1)));
				if (point == null) {
					throw new IllegalArgumentException("device value not found");
				}
				parser.setVariable(entry.getKey(), point.getPointValue());	
			} else {
				parser.setVariable(entry.getKey(), value);	
			}
		}
		return parser.evaluate();
	}

}
