import java.util.regex.Pattern;

/**here we assume user passes polynomial string in the form e.g. 8x^1y^2z + 8x^2 + 8z
 * @author Rahul
 *
 */
public class MultiPoly {

	CoefNode rootNode = null;

	/**this constructor splits user passed polynomial string and convert into nested list and initializes the rootNode
	 * @param poly
	 */
	public MultiPoly(String poly) {

		this.rootNode = splitAndConvertIntoNestedLinkedList(poly);

	}

	/** this function splits the user passed polynomial string and convert into nested list and return root element
	 * @param poly, polynomial string
	 * @return root element
	 */
	private CoefNode splitAndConvertIntoNestedLinkedList(String poly) 
	{
		
		int coef = 0;
		CoefNode coefNode = null;
		VarNode varNode = null;
		VarNode prevVarNode = null;
		CoefNode prevCoefNode = null;
		CoefNode rootNode = null;
		int varIndex = 0;
		String polynomialTerm = null;
		int currentIndexOfTerm = 0;
		
		// split string by +/- sign
		String polyTerms[] = poly.split("[\\+|\\-]");

		for (int currentPolynomialTermIndex = 0; currentPolynomialTermIndex < polyTerms.length; currentPolynomialTermIndex++) 
		{
			
			coefNode = new CoefNode();
			
			polynomialTerm = polyTerms[currentPolynomialTermIndex].trim();
			
			if (isInteger(polynomialTerm.charAt(0))) 
			{
				currentIndexOfTerm = 1;
				coef = Integer.valueOf(polynomialTerm.charAt(0) + "");
			} 
			else 
			{
				currentIndexOfTerm = 0;
				coef = 1;
			}
			
			coefNode.coef = coef;

			// if rootNode is null then initialize it with coef node
			if (rootNode == null) 
			{
				rootNode = coefNode;
				prevCoefNode = coefNode;
			} 
			else 
			{
				prevCoefNode.referenceToNextCoefNode = coefNode;
				prevCoefNode = coefNode;
			}

			varIndex = 0;
			
			for (; currentIndexOfTerm < polynomialTerm.length(); currentIndexOfTerm++) 
			{
				varNode = new VarNode();
				
				if(polynomialTerm.charAt(currentIndexOfTerm) == '^')
				{
					throw new AssertionError("Please pass a valid expression");
				}

				if (!isInteger(polynomialTerm.charAt(currentIndexOfTerm))) 
				{
					varNode.varIndex = varIndex;
					
					varIndex++;
					
					if (polynomialTerm.charAt(currentIndexOfTerm + 1) == '^') 
					{
						currentIndexOfTerm = currentIndexOfTerm + 2;
						
						// set power of node to this;
						
						if(!isInteger(polynomialTerm.charAt(currentIndexOfTerm)))
						{
							throw new AssertionError("Please pass a valid expression");
						}
						varNode.degree = Integer.valueOf(polynomialTerm.charAt(currentIndexOfTerm) + "");
						
						System.out.println("degree: " + varNode.degree);
						
						if (coefNode.referenceToNextVarNode == null) 
						{
							coefNode.referenceToNextVarNode = varNode;
							prevVarNode = varNode;
						} 
						else 
						{
							prevVarNode.referenceToNextVarNode = varNode;
							prevVarNode = varNode;
						}
					} 
					else 
					{
						throw new AssertionError("Please pass a valid expression");
					}

				}
				else{
					throw new AssertionError("Please pass a valid expression");
				}
			}
		}
		return rootNode;
	}

	
	/** #drive controller function
	 * @param args
	 */
	public static void main(String... args) {
		
		String poly = "8x^2y^1z^1 + 4y^2z^1 + 8x^2";

		MultiPoly multiPoly = new MultiPoly(poly);

		System.out.println(" degree is: " + multiPoly.getDegree());

		multiPoly.showMultiPoly();
	}

	/**function to calculate degree of polynomial
	 * @return, degree of polynomial
	 */
	public int getDegree() 
	{
		CoefNode root = this.rootNode;
		VarNode varNode = null;
		int maxDegree = 0;
		int degree = 0;
		
		while (root != null) 
		{
			varNode = root.referenceToNextVarNode;
			
			while (varNode != null) 
			{
				degree += varNode.degree;
				varNode = varNode.referenceToNextVarNode;
			}

			if (maxDegree < degree) 
			{
				maxDegree = degree;
			}

			degree = 0;
			root = root.referenceToNextCoefNode;
		}
		return maxDegree;
	}

	/**
	 * function to show polynomial
	 */
	public void showMultiPoly() {

		CoefNode coefIterator = this.rootNode;
		VarNode varIterator = null;

		while (coefIterator != null) 
		{
			varIterator = coefIterator.referenceToNextVarNode;
			while (varIterator != null) 
			{
				System.out.println(varIterator.varIndex + " "
						+ varIterator.degree);
				varIterator = varIterator.referenceToNextVarNode;
			}
			coefIterator = coefIterator.referenceToNextCoefNode;
		}
	}

	/** function to check weather given characeter is integer or not
	 * @param s
	 * @return
	 */
	public static boolean isInteger(char character) 
	{

		if (character >= 48 && character <= 57) 
		{
			return true;
		} else
			return false;
	}
	
}
