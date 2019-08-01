import static org.junit.Assert.*;

import org.junit.Test;


public class ExpressionEvaluationTest {

	@Test
	public void isOperandTestForNumericOperandForFloatValue()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		assertEquals(true, expressionEvaluation.isOperand("25.00035" ));
	}

	@Test
	public void isOperandTestForNumericOperandForIntegerValue()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		assertEquals(true, expressionEvaluation.isOperand("25" ));
	}
	
	@Test
	public void isOperandTestForBoolOperandWhenUserPassesCorrectBoolValues()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		
		assertEquals(true, expressionEvaluation.isOperand("True" ));

		assertEquals(true, expressionEvaluation.isOperand("False" ));
	}
	
	@Test
	public void isNumericTestWhenUserPassesNumericValue()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		
		assertEquals(true, expressionEvaluation.isNumeric("234"));
	}
	
	@Test
	public void infixToPostFixTestWhenUserPassesCorrectValue()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		String resultedOuput = expressionEvaluation.infixToPostFix("True || 5 * 6 / 5 <= 2 * 3");
		String expectedOutput = "True 5 6 * 5 / 2 3 * <= ||";
		assertEquals(true, expectedOutput.equals(resultedOuput));
	}
	
	@Test
	public void evaluateExpressionTestWhenUserPassesCorrectInfixExpression()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		String resultedOuput = expressionEvaluation.evaluateExpression("True || 5 * 6 / 5 <= 2 * 3");
		String expectedOutput = "True";
		assertEquals(true, expectedOutput.equals(resultedOuput));
	}

}
