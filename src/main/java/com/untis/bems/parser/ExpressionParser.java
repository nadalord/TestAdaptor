package com.untis.bems.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ExpressionParser {
	ExpressionBuilder expressionBuilder;
	String expressionString;
	Expression expression;
	
	public ExpressionParser(String expressionString) {
		this.expressionString = expressionString;
	}

	public Map<String, String> parseVariables() throws IllegalArgumentException {
		StringTokenizer expressions = new StringTokenizer(this.expressionString, ",");
		if (expressions.countTokens() <= 0) {
			return null;
		}
		
		Map<String, String> variableMap = new HashMap<String, String>();
		this.expressionBuilder = new ExpressionBuilder(expressions.nextToken());
		
		while (expressions.hasMoreElements()) {
			StringTokenizer variables = new StringTokenizer(expressions.nextToken().trim(), ":");
			if (variables.countTokens() != 2) {
				throw new IllegalArgumentException("The expression can not be empty");
			}
			String variableName = variables.nextToken();
			this.expressionBuilder = this.expressionBuilder.variable(variableName);
			variableMap.put(variableName, variables.nextToken());
		}
		this.expression = this.expressionBuilder.build();
		return variableMap;
	}
	
	public void setVariable(String variable, String value) {
		double doubleValue = Double.parseDouble(value);
		this.expression = this.expression.setVariable(variable, doubleValue);
	}
	
	public void setVariable(String variable, Double value) {
		this.expression = this.expression.setVariable(variable, value);
	}
	
	public Double evaluate() {
		return this.expression.evaluate();
	}
}
