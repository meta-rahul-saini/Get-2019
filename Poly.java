import java.util.HashMap;


/**polynomial class which has member functions to addition, multiplication, isSubset etc.
 * @author rahul
 *
 */
public class Poly {

	private final HashMap<Integer, Float> polyMap = new HashMap<>();
	
	
	/**	insert the polynomial terms into poly hasMap, if term with same power is exists then it adds their coefficient;
	 * @param coeficient, coefficient to be added
	 * @param power, power to be added
	 */
	public void insert(final float coeficient, final int power)
	{
		if(power < 0 )
		{
			throw new AssertionError(" Please pass an positive power value");
		}
		
		if(coeficient == 0)
		{
			return;
		}
		if(this.polyMap.containsKey(power))
		{
			this.polyMap.put(power, (coeficient + this.polyMap.get(power)));
		}
		else
		{
			this.polyMap.put(power, coeficient);
		}
	}
	
	/** returns size of polynomial
 	 * @return
	 */
	public int size()
	{
		return this.polyMap.size();
	}
	
	
	/** evaluates polynomial expression given the x parameter
	 * @param x, value on which polynomial is evaluated
	 * @return returns evaluated result
	 */
	public float evaluate(float x)
	{
		float result = 0;
		float currentCoefficient = 0;
		
		System.out.println(" XXXXXXXXXXXXXXXXX: " + x);
		for(int currentPower: this.polyMap.keySet())
		{
			currentCoefficient  = this.polyMap.get(currentPower);
			System.out.println(" current power: " + currentPower);
			
			System.out.println(" x == "+ x + " and " + 0.0f + " equals: " + (x==0.0f));
			if(x == 0.0f && currentPower == 0)
			{
				System.out.println(" =========");
				return result = currentCoefficient;
			}
			else
			{
				result += currentCoefficient* Math.pow(x, currentPower);
			}
		}
		System.out.println(result);
		return result;
	}
	
	/** returns degree of polynomial
	 * @return
	 */
	public int getDegree()
	{
		float maxPower = 0;
		
		for(int currentPower: this.polyMap.keySet())
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

		HashMap< Integer, Float> p1Poly = this.getPolyMap();
		
		HashMap< Integer, Float> p2Poly = poly2.getPolyMap();
		
		
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
	
	/**function to check weather two  polynomial are equal or not
	 * @param poly2
	 * @return true if equal o/w false
	 */
	public boolean isEquals(Poly poly2)
	{
		HashMap< Integer, Float> poly1Map = this.getPolyMap();

		HashMap< Integer, Float> poly2Map = poly2.getPolyMap();
		
		if(poly1Map.size() != poly2Map.size())
		{
			System.out.println("SIZE NOT EQUAL");
			return false;
		}
		else 
		{
			System.out.println(" ELSE BLOCK");
			for (Integer currentPower : poly1Map.keySet())
			{
				if( Float.compare(poly1Map.get(currentPower), poly2Map.get(currentPower)) !=  0)
					return false;
			}
		}
		return true;
	}

	
	/** Multiplies current polynomial with passed polynomial
	 * @param poly2
	 * @return returns polynomial representing the multiplication of both polynomial
	 */
	public Poly multiply(Poly poly2)
	{
		
		Poly poly = new Poly();

		HashMap< Integer, Float> p1Poly = this.getPolyMap();
		
		HashMap< Integer, Float> p2Poly = poly2.getPolyMap();
		
		if(!(poly2.getPolyMap().size()==0))
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
		HashMap<Integer, Float> poly = getPolyMap();
		
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

	public HashMap<Integer, Float> getPolyMap() {
		return this.polyMap;
	}


}
