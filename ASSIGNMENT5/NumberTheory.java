
public class NumberTheory {

	int lcm =0;
	boolean flag = true;
	
	/** this function computes least common multiple of two numbers passed x and y
	 * @param x		first integer number
	 * @param y		second integer number
	 * @return 		returns Least Common Factor of passed two numbers
	 */
	public int lcm(int x, int y)
	{
		// first initialize the LCM with max element
		if(flag==true)
		{
			flag=false;
			lcm = Math.max(x, y);
		}
		
		// base case
		if(lcm%x ==0 && lcm%y==0)
		{
			return lcm;
		}
		
		// divide problem into subproblem and make a recursive call
		else{
			lcm = lcm+1;
			return lcm(x, y);
		}
	}
	
	
	/** function to return highest common factor which is divisible by both parameter x and y
	 * @param x		first integer number
	 * @param y		second integer number
	 * @return 		returns Highest Common Factor of above two numbers
	 */
	public int hcf(int x, int y)
	{
		// check if x is greater
		if(x<y)
		{	
			// base case
			if(y%x==0)
				return x;
			// divide problem into subproblem and make a recursive call
			else 
				return hcf(y%x, (y/x)*x);
		}
		else
		{	
			// base case
			if(x%y==0)
				return y;
			// divide problem into subproblem and make a recursive call
			else 
				return hcf(x%y, (x/y)*y);
		}
	}
	
}
