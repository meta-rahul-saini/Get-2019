import static org.junit.Assert.*;

import org.junit.Test;


public class ExpressionEvaluationNegativeTest {

	@Test
	public void isOperandTestForBoolOperandWhenUserCorrectBoolValues()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		
		assertEquals(false, expressionEvaluation.isOperand("true" ));

		assertEquals(false, expressionEvaluation.isOperand("ffalse" ));
	}
	
	@Test
	public void isNumericTestWhenUserPassesNonNumericValue()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		
		assertEquals(false, expressionEvaluation.isNumeric("df"));
	}

	@Test(expected = AssertionError.class)
	public void infixToPostFixTestWhenUserPassesIncorrectCorrectValue()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		System.out.println(expressionEvaluation.infixToPostFix("True || 5 * 6 / 5 <=**2"));
	}
	

	@Test(expected = AssertionError.class)
	public void evaluateExpressionTestWhenUserPassesInCorrectInfixExpression()
	{
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		expressionEvaluation.evaluateExpression("True || 5 * 6 / 5 <= 2 ** 3");
		
	}
	
}
