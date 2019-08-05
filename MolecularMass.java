import java.util.HashMap;
import java.util.Stack;

/**
 *we use this class to calculate the molecular mass of a compound chemistry formula
 */
public class MolecularMass {
	
	public HashMap<Character, Integer> elements = new HashMap<Character, Integer>();
	

	/** returns the total mass of given string formula
	 * @param string
	 * @return
	 */
	public int getMass(String formula)
	{
		int mass = 0;
		int index = 0;
		char currentChar = 0;

		formula = formula.toUpperCase();
		
		// initializing weights of map
		elements.put('C', 12);
		elements.put('O', 16);
		elements.put('H', 1);
		
		Stack<Integer> stack1 = new Stack<Integer>();

		while ( index < formula.length()) 
		{
			
			currentChar = formula.charAt(index);
			
			// if current char is non-numeric then simply push it on the stack
			if ( (currentChar >= 65 && currentChar <= 90))
			{
				stack1.push(elements.get(currentChar));
				index ++;
			}
			// if current char is numeric then find the whole numeric terms and 
			else if (currentChar >= 48 && currentChar <= 57) 
			{
				int dist = index;
				
				while( dist < formula.length() && isInteger(formula.charAt(dist)))
				{
					dist++;
				}
				int temp = stack1.pop();

				int numeric = Integer.valueOf(formula.substring(index, dist));
				
				index = dist;
			
				stack1.push(temp*numeric);
			}
			// if we find open parenthesis then we find the corresponding closing parenthesis using stack and recursively call the elements in the middle 
			else if (currentChar=='(')
			{
				index++;
				int distFromOpenToCurrentchar = index;
				
				Stack<Character> stack2 = new Stack<Character>();
				stack2.push('(');
				String stringInParenthesis = "";
				while(!stack2.isEmpty())
				{
					if (formula.charAt(distFromOpenToCurrentchar) == '(') 
					{
						stringInParenthesis += '(';
						stack2.push('(');
					}
					else if (formula.charAt(distFromOpenToCurrentchar) == ')') 
					{
						stack2.pop();
						stringInParenthesis +=')';
					}
					else
					{
						stringInParenthesis += formula.charAt(distFromOpenToCurrentchar);
					}
					distFromOpenToCurrentchar++;
				}
				
				stringInParenthesis = stringInParenthesis.substring(0, stringInParenthesis.length()-1);

				int dist2 = distFromOpenToCurrentchar;
				while (dist2 < formula.length() && isInteger(formula.charAt(dist2))) {
					dist2++;
				}
				
				// recursive call to function
				mass += (getMass(stringInParenthesis)* Integer.valueOf( formula.substring(distFromOpenToCurrentchar, dist2)) + getMass(formula.substring(dist2)));
				
				index = formula.length();
			
			}
		}
		while(!stack1.isEmpty())
		{
			int currentMass = stack1.pop();
			mass += currentMass;
			
		}
		return mass;
	}
	

	/**function to check weather the given char is integer or not?
	 * @param currentChar, 
	 * @return true if given char is integer o/w returns false
	 */
	public boolean isInteger(char currentChar) {

		if (currentChar >= 48 && currentChar <= 57) {
			return true;
		}
		return false;
	}
	
	public static void main(String ... args){
		
		MolecularMass molecular = new MolecularMass();
		System.out.println("total mass: " + molecular.getMass("(C2(H10)10C)2C2C2(HH10)10H"));
		
		
	}
}
