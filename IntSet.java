
public final class IntSet {
	
	private final int[] intSet;
	private final int  maxSize = 1000;
	
	
	public IntSet(int[] arr){
		this.intSet = arr;
	}
	
	/** checks linearly weather x is member of intSet or not
	 * @param x, element to be checked
	 * @return true if element is member of set o/w return false;
	 */
	public boolean isMember(int x){
		for (int index = 0; index < this.intSet.length; index++){
			if(x == this.intSet[index]){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @return size of intSet
	 */
	public int size(){
		return this.intSet.length;
	}
	
	
	/** checks weather the passed targetSet is subset of current set or not
	 * @param targetSet
	 * @return returns true if targetSet is subset of current set o/w not
	 */
	public boolean isSubSet(IntSet targetSet){
		
		int size = targetSet.size();
		int universalSetSize = this.size();
		int sizeOfTargetSet = targetSet.size(); 
		int noOfMatchedElements = 0;
		
		for (int index = 0; index < sizeOfTargetSet; index++)
		{
			for(int index2 = 0; index2 < universalSetSize; index2++ )
			{
				if(targetSet.intSet[index] == this.intSet[index2])
				{
				noOfMatchedElements++;
				break;
				}
			}
		}
		
		if(noOfMatchedElements == size)
		{
			return true;
		}
		return false;
	}
	
	
	/** it returns complement of current integer set from range of (1, 1000)
	 * @return returns complemented intSet
	 */
	public  IntSet getComplement(){
		int targetSetLength = this.size();
		int[] complementArray = new int [maxSize - targetSetLength];
		int complementArrayIndex = 0;
		boolean flag;
		
		for (int value = 1; value <= maxSize; value++){
			
			flag=false;
			
			for(int index = 0; index < this.size(); index++)
			{
				if(this.intSet[index]==value)
				{
					flag=true;
					break;
				}
			}
			if(flag!=true)
			{
				complementArray[complementArrayIndex] = value;
				complementArrayIndex++;
			}	
		}
		IntSet complementIntSet = new IntSet(complementArray);
		
		return complementIntSet;
	}

	
	/** this method returns the union of current set and passed set
	 * @param set2 
	 * @return returns union of both of the set
	 */
	public  IntSet union(IntSet set2){
		int set1Length = this.size(), set2Length = set2.size();
		int unionLength = set1Length+set2Length;
		int[] unionArray = new int [unionLength];
		int index = 0;
		int indexUnionArray = 0;
		int number1 = 0;
		int noOfCommon = 0;
		
		// adding the unique elements in set2 to unionArray
		while(index < set2.size())
		{
			number1 = set2.intSet[index];
			// if number1 in set2 is not member of set1, add it to union set
			if(!this.isMember(number1))
			{
				unionArray[indexUnionArray]=number1;
				indexUnionArray++;
			}
			else{
				noOfCommon++;
			}
		index++;
		}
		
		index = 0;
		// adding the elements of current se to unionArray
		while(index < this.size())
		{
			
			unionArray[indexUnionArray] = this.intSet[index];
			index++;
			indexUnionArray++;
		}
		
		
		// creating a new array with length equal to no of elements in union of both set
		
		int unionArray1[]  = new int [unionLength - noOfCommon];
		
		for(index =0; index < unionLength - noOfCommon ; index++ )
		{
			unionArray1[index] = unionArray[index];
		}
		
		// creating an intSet from array
		IntSet unionSet = new IntSet(unionArray1);
		
		return unionSet;
	}
	
	/**
	 * prints current integer set 
	 */
	public void showIntSet()
	{
		int length = this.size();
		for(int index = 0; index < length; index++)
		{
			System.out.println(this.intSet[index]);
		}
	}
	
	public static void main(String[] args){
		IntSet s1 = new IntSet(new int[] {1,2,3,4,5,5, 6, 7,8,9});
		IntSet s2 = new IntSet(new int[] {1,2,120});
		
//		boolean s3 = s1.isSubSet(s2);
//		IntSet s4 = s1.getComplement();
//		s4.showIntSet();
//		IntSet s5 = s1.union(s2);
//		
//		s5.showIntSet();
//		
		System.out.println(s1.isSubSet(s2));
	}
}
