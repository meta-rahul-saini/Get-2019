public class ExpressionEvaluation {

	/**
	 * function to find precedence of operator, greater the return value higher the precedence
	 * 
	 * @param symbol
	 * @return integer value showing precedence where higher the value higher
	 *         the precedence
	 */
	public int precedence(String symbol) {
		if (symbol.equals("^")) {
			return 7;
		} else if (symbol.equals("*") || symbol.equals("/")) {
			return 6;
		} else if (symbol.equals("+") || symbol.equals("-")) {
			return 5;
		} else if (symbol.equals("==")) {
			return 4;
		} else if (symbol.equals("<") || symbol.equals("<=")
				|| symbol.equals(">") || symbol.equals(">=")) {
			return 3;
		} else if (symbol.equals("&&")) {
			return 2;
		} else if (symbol.equals("||")) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * function to check weather given character is operand or not or not e.g. True, 1, 3 etc.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isOperand(String operand) {
		operand = operand.trim();
		try {
			Float.parseFloat(operand);
		} catch (Exception e) {
			if (operand.equals("True") || operand.equals("False"))
				return true;
			else
				return false;
		}
		return true;
	}

	/**function to check weather given character is operator or not or not e.g. + , -, / etc.
	 * @param operator 
	 * @return true if passed operator is operator o/w false is returned
	 */
	public boolean isOperator(String operator) {
		
		operator = operator.trim();
		if (operator.equals("*") || operator.equals("/") || operator.equals("+")
				|| operator.equals("-") || operator.equals("^")
				|| operator.equals(">=") || operator.equals("==")
				|| operator.equals(">") || operator.equals("<=")
				|| operator.equals("<") || operator.equals("||") || operator.equals("&&")) {
			return true;
		} else {
			throw new AssertionError("invalid expression passed");
		}
	}

	/**
	 * function to check weather given character is numeric or not
	 * @return true if string is numeric o/w false is returned
	 */
	public boolean isNumeric(String string) {
		string = string.trim();
		try {
			Float.parseFloat(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/** function to convert infix string into postfix string using stack
	 * @param infixString
	 * @return, postfix string 
	 */
	public String infixToPostFix(String infixString) {

		String currentElement;
		Stack stack1 = new Stack();

		String postfix = "";
		String charArray[] = infixString.split("\\s");
		for (int currentELementIndex = 0; currentELementIndex < charArray.length; currentELementIndex++) {

			currentElement = charArray[currentELementIndex];

			if (isOperand(currentElement)) {
				System.out.println("y.push: " + currentElement);
				postfix += currentElement + " ";
			} else if (currentElement.equals("(")) {
				System.out.println("stack1.push: " + "(");
				stack1.push(currentElement);
			}

			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered.
			else if (currentElement.equals(")")) {
				while (!stack1.isEmpty() && !stack1.peek().equals("(")) {
					postfix += stack1.pop() + " ";
				}
			} else // an operator is encountered
			{
				if (isOperator(currentElement)) {
					while (!stack1.isEmpty()
							&& precedence(currentElement) <= precedence(stack1
									.peek())) {
						postfix += stack1.pop() + " ";

					}
					stack1.push(currentElement);
				}
			}
		}
		// pop all the operators from the stack
		while (!stack1.isEmpty()) {
			postfix += stack1.pop() + " ";
		}

		return postfix.trim();
	}

	/**evaluate the infix string by converting to post-fix using stack using above function and return resultant value in string
	 * @param infix, infix expression
	 * @return result of infix expression
	 */
	public String evaluateExpression(String infix) {
		String postfix = infixToPostFix(infix);
		String stringVal1;
		String stringVal2;
		
		// create a stack
		Stack stack = new Stack();

		String postfixArray[] = postfix.split("\\s");

		// Scan all characters one by one
		for (int currentELementIndex = 0; currentELementIndex < postfixArray.length; currentELementIndex++) {
			String currentElement = postfixArray[currentELementIndex];

			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (isOperand(currentElement)) {
				System.out.println("\n" + currentElement
						+ " element puuushedddd");
				stack.push(currentElement);
				stack.display();
			}
			// If the scanned character is an operator, pop two
			// elements from stack apply the operator
			else {
				try{
					stringVal1 = stack.pop();
					stringVal2 = stack.pop();
				}
				catch(Exception e)
				{
					throw new AssertionError("please pass valid infix expression");
				}
				float floatVal1 = 0;
				float floatVal2 = 0;

				// if popped values are numeric then we store them into float variable o/w store them in string variable
				
				if (isNumeric(stringVal1)) {
					floatVal1 = Float.valueOf(stringVal1);
				}
				if (isNumeric(stringVal2)) {
					floatVal2 = Float.valueOf(stringVal2);
				}
				System.out.println("\n" + floatVal1 + " element popped"
						+ stringVal1);

				System.out.println("\n" + floatVal2 + " element popped"
						+ stringVal2);

				// if currentOperator is "+" then perform addition 
				
				if (currentElement.equals("+")) {
					stack.push((floatVal2 + floatVal1) + "");
					stack.display();
				} else if (currentElement.equals("-")) {
					stack.push((floatVal2 - floatVal1) + "");
					stack.display();
				} else if (currentElement.equals("/")) {
					stack.push((floatVal2 / floatVal1) + "");
					stack.display();
				} else if (currentElement.equals("*")) {
					stack.push((floatVal2) * (floatVal1) + "");
					stack.display();
				} else if (currentElement.equals("^")) {
					stack.push((Math.pow(floatVal2, floatVal1)) + "");
					stack.display();
				} else if (currentElement.equals("==")) {
					if (Float.compare(floatVal2, floatVal1) == 0)
						stack.push("True");
					else
						stack.push("False");
					stack.display();
				} else if (currentElement.equals(">=")) {
					if (Float.compare(floatVal2, floatVal1) >= 0)
						stack.push("True");
					else
						stack.push("False");
					stack.display();
				} else if (currentElement.equals("<=")) {
					if (Float.compare(floatVal2, floatVal1) <= 0)
						stack.push("True");
					else
						stack.push("False");
					stack.display();
				} else if (currentElement.equals("!=")) {
					if (Float.compare(floatVal2, floatVal1) != 0)
						stack.push("True");
					else
						stack.push("False");
					stack.display();
				} else if (currentElement.equals("||")) {
					if (!stringVal1.equals(stringVal2)
							|| stringVal1.equals("True")
							|| stringVal2.equals("True")) {
						stack.push("True");
					} else {
						stack.push("False");
					}
				} else if (currentElement.equals("&&")) {
					if ((stringVal1.equals("True") && stringVal2.equals("True"))) {
						stack.push("True");
					} else {
						stack.push("False");
					}
				}
			}
		}
		return stack.pop();
	}

	public static void main(String... args) {

		// String infix =
		// "( ( 68 ) == ( ( 2 * 3 - ( 4 / 5 ^ 6 ) * 7 ) * 8 + 10 * 2 ) )";

		String infix = "True || 5 * 6 / 5 <= 2 * 3";
		// String infix = "True || True";

		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		String result = expressionEvaluation.evaluateExpression(infix);

		System.out.println("result is: " + result);
	}

}
