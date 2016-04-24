package com.untis.bems.parser;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.DevicePoint;

public class BemsExpressionParserTest extends AbstractTestableContext {

	@Test
	public void evaluate() {
		BemsExpressionParser parser = new BemsExpressionParser();
		
		Map<Integer, DevicePoint> deviceMap = new HashMap<Integer, DevicePoint>();
		
		DevicePoint point = new DevicePoint();
		point.setPointValue(1.0);
		deviceMap.put(1, point);
		
		point = new DevicePoint();
		point.setPointValue(2.0);
		deviceMap.put(2, point);
		
		parser.addDataSource("$", deviceMap);
	
		parser.setExpression("10 + XE + Y - XE, XE:$1, Y:$2");
		double result = parser.evaluate();
		
		System.out.println("expression result : " +  result);
		
		parser.setExpression("10 + XE + Y, XE:4, Y:1");
		result = parser.evaluate();
		
		System.out.println("expression result2 : " +  result);
	}
}
