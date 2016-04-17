package com.untis.bems.parser;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.untis.bems.AbstractTestableContext;

public class ExpressionParserTest extends AbstractTestableContext {

	@Test
	public void evaluate() {
		ExpressionParser parser = new ExpressionParser("10 + XE + XE + Y + Y, XE:$5, Y:$10");
		Map<String, String> varMap = parser.parseVariables();
		for (Map.Entry<String, String> entry : varMap.entrySet()) {
			String value = entry.getValue();
			if (value.charAt(0) == '$') {
				System.out.println("$ 변수");
				parser.setVariable(entry.getKey(), value.substring(1));
			} else {
				parser.setVariable(entry.getKey(), value);
			}
			System.out.println(entry.getKey());
		}
		Double result = parser.evaluate();
		System.out.println("Expression : " + result);
		// assertEquals(result, new Double(16));
	}
}
