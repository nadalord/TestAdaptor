package com.untis.bems.parser;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.untis.bems.AbstractTestableContext;
import com.untis.bems.domain.DevicePoint;

public class ExpressionParserTest extends AbstractTestableContext {

	@Test
	public void evaluate() {
		ExpressionParser parser = new ExpressionParser("10 + 1 + X + Y,X:$1,Y:$2");
		Map<String, String> varMap = parser.parseVariables();
		for (Map.Entry<String, String> entry : varMap.entrySet()) {	
			parser.setVariable(entry.getKey(), "1");
			System.out.println(entry.getKey());
		}
		Double result = parser.evaluate();
		assertEquals(result, new Double(13));
		
		String test = " tt	aa ";
		System.out.println("TTT :" + test.trim() + "|");
	}

}
