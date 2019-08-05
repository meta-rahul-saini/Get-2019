
public class ViratAndBowler 
{
	private int bowlerNum;
	private int viratBats;
	private int[][] bowlArray;
	
	
	/** constructor used to initialize the parameters
	 * @param bowlerNum, #bowlers
	 * @param viratBowls, virat bats no. of bowls
	 * @param bowlArray, array containing each bowler bowls
	 */
	public ViratAndBowler(int bowlerNum, int viratBats , int[][]bowlArray)
	{
		this.bowlerNum = bowlerNum;
		this.viratBats = viratBats;
		this.bowlArray = bowlArray;
	
		int bowlsSum = 0;
		for (int index = 0; index < bowlArray.length; index++) {
			bowlsSum += bowlArray[index][1];
		}
		System.out.println("bowler: " + bowlsSum);
		if(this.viratBats > bowlsSum)
		{
			throw  new AssertionError("Virat can't play more bolws then bowler");
		}
	}
	
	
	/**
	 * @param bArray
	 * @return max heap array
	 */
	public int[][] maxHeapyfy(int[][]bowlArray)
	{
		int arrLength = bowlArray.length;
		
		// in log(n) time we can heapyfy the maximum element on root
		int noOfHeapyfyRequired = (int)Math.log(arrLength);
		
		for(int heapyfyNum = 0; heapyfyNum <= noOfHeapyfyRequired; heapyfyNum++)
		{
			for(int count = 0; count < arrLength/2-2; count++)
			{
				// if left child has greater value than parent then swap the value
				if( bowlArray[count][1] < bowlArray[2*count+1][1])
				{
					int[] temp = bowlArray[count];
					bowlArray[count] = bowlArray[2*count+1];
					bowlArray[2*count+1] = temp;
				}
				
				// if the right child has greater value than parent then swap the value
				
				if(bowlArray[count][1] < bowlArray[2*count+2][1]){
					int[] temp = bowlArray[count];
					bowlArray[count] = bowlArray[2*count+2];
					bowlArray[2*count+2] = temp;
				}
			}
		}
		return bowlArray;
	}
	
	/**
	 * @return order of bowlers
	 * 
	 */
	public int[] getBowlerOrder(){   
		int viratBats = this.viratBats;
		
		int[] bowlerOrder = new int[viratBats];
		
		for(int index = 0; index< viratBats; index++)
		{
			this.bowlArray = maxHeapyfy(this.bowlArray);
			this.bowlArray[0][1]-=1;
			bowlerOrder[index] = bowlArray[0][0];
		}
		return bowlerOrder;
	}
	
	public static void main(String[]args){
		int[][] bowlerArray = new int[][]{
				{0,5},
				{1,15},
				{2,10},
				{3,8},
		};
		
		ViratAndBowler vb = new ViratAndBowler(4,100,bowlerArray);
	}
}