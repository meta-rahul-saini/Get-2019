import java.util.HashMap;


public class Poly {

	private final HashMap<Integer, Float> poly = new HashMap<>();
	
	
	/**	insert the polynomial terms into poly hasMap, if term with same power is exists then it adds their coefficient;
	 * @param coeficient, coefficient to be added
	 * @param power, power to be added
	 */
	public void insert(final float coeficient, final int power)
	{
		if(poly.containsKey(power))
		{
			poly.put(power, (coeficient + poly.get(power)));
		}
		else
		{
			poly.put(power, coeficient);
		}
	}
	
	/** returns size of polynomial
 	 * @return
	 */
	public int size()
	{
		return poly.size();
	}
	
	
	/** evaluates polynomial expression given the x parameter
	 * @param x, value on which polynomial is evaluated
	 * @return returns evaluated result
	 */
	public float evaluate(float x)
	{
		float result = 0;
		
		for(int currentPower: poly.keySet())
		{
			result += poly.get(currentPower)* Math.pow(x, currentPower);
		}
		return result;
	}
	
	/** returns degree of polynomial
	 * @return
	 */
	public int degree()
	{
		float maxPower = 0;
		
		for(int currentPower: poly.keySet())
		{
			if(currentPower > maxPower)
			{
				maxPower = currentPower;
			}
		}
		return (int)maxPower;
	}
	
	
	/** adds two polynomial, adds coefficient if there power is same o/w add the term into resultant polynomial
	 * @param poly2 polynomial to be added
	 * @return returns polynomial representing addition of polynomial
	 */
	public Poly add(Poly poly2)
	{
		
		Poly poly = new Poly();

		HashMap< Integer, Float> p1Poly = this.getPoly();
		
		HashMap< Integer, Float> p2Poly = poly2.getPoly();
		
		
		for (Integer currentPower: p1Poly.keySet())
		{
			poly.insert(p1Poly.get(currentPower), currentPower);
		}
		
		for(Integer currentPower: p2Poly.keySet())
		{
		 poly.insert(p2Poly.get(currentPower), currentPower);	
		}
		
		return poly;
	}

	
	/** Multiplies current polynomial with passed polynomial
	 * @param poly2
	 * @return returns polynomial representing the multiplication of both polynomial
	 */
	public Poly multiply(Poly poly2)
	{
		
		Poly poly = new Poly();

		HashMap< Integer, Float> p1Poly = this.getPoly();
		
		HashMap< Integer, Float> p2Poly = poly2.getPoly();
		
		if(!(poly2.getPoly().size()==0))
		{
			for (Integer currentPower1: p1Poly.keySet())
			{
				for(Integer currentPower2: p2Poly.keySet())
				{
					poly.insert(p1Poly.get(currentPower1)*p2Poly.get(currentPower2), currentPower1 + currentPower2);		
				}
			}
		}
		return poly;
	}

	
	/**
	 * prints polynomial expression 
	 */
	public void showPoly()
	{
		HashMap<Integer, Float> poly = getPoly();
		
		for(int currentPower: poly.keySet())
		{
			System.out.println(poly.get(currentPower)+ "X^" + currentPower);
		}
		System.out.println("==================");
	}
	
	public static void main(String ... args)
	 {
		 
		 Poly poly1 = new Poly();
			poly1.insert(4, 2);
			poly1.insert(3,  3);
		poly1.showPoly();
		
		 Poly poly2 = new Poly();
			poly2.insert(5,  2);
			poly2.insert(9, 3);
		poly2.showPoly();
		
		Poly poly3 = poly1.add( poly2);
		poly3.showPoly();
		
		Poly poly4 = poly1.multiply(poly2);
		poly4.showPoly();
	 }

	public HashMap<Integer, Float> getPoly() {
		return poly;
	}


}
