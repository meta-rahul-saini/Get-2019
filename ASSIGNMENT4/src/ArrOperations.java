public class ArrOperations {

	/**
	 * this function finds the maxMirror in the array
	 * @param nums
	 *            array of integers
	 * @return length of maxMirror, and throw assertion error if array is empty.
	 */
	public int findMaxMirror(int[] nums) {
		int maxLengthMirror = 0;
		int mirrorLength = 0;
		
		if(nums.length==0)
		{
			throw new AssertionError("Assertion Error Occured: Please don't pass an empty array");
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j >= 0
					&& i + mirrorLength < nums.length; j--) {
				if (nums[i + mirrorLength] == nums[j]) {
					mirrorLength++;
				} else {
					if (maxLengthMirror < mirrorLength) {
						maxLengthMirror = mirrorLength;   
					}
					mirrorLength = 0;
				}
			}
			if (maxLengthMirror < mirrorLength) {
				maxLengthMirror = mirrorLength;
			}
			mirrorLength = 0;
		}
		return maxLengthMirror;
	}

	
	/** returns the number of clumps in input array, throws assertion error if array is empty 
	 * @param nums, array of integers
	 * @return noOfClumps, throws assertion error if array is empty
	 */
	public int countClumps(int[] nums) {
		final int len = nums.length;
		int count = 0;
		if(nums.length==0)
		{
			throw new AssertionError("Assertion Error Occured: an empty array passed");
		}
		for (int i = 0; i <= len - 2; i++) {
			if (nums[i] == nums[i + 1]) {
				count++;
				i++;
			}
			while (i<len-2 && nums[i] ==nums[i+1]) {
				i++;
			}

		}    
		return count;
	}

	/**returns the split index so that sum of the number on one side is 
	 * equal to the sum of the numbers on the other side
	 * @param nums, array of Integers
	 * @return splitIndex, if found any split position then return split position o/w
	 *         returns -1
	 */
	public int findSplitArrayIndex(int nums[]) {
		int leftOfSplitSum = 0;
		int rightOfSplitSum = 0;
		int arrayLength = nums.length;
		
		if(nums.length==0)
		{
			throw new AssertionError("Assertion Error Occured: an empty array passed");
		}
		for (int index = 1; index < arrayLength; index++) {
			
			// sum of left side
			for (int currentIndexOfLeftSplit = 0; currentIndexOfLeftSplit < index; currentIndexOfLeftSplit++)
				leftOfSplitSum += nums[currentIndexOfLeftSplit];

			// sum of elements on rigth sid                      e
			for (int currentIndexOfRightSplit = index; currentIndexOfRightSplit < arrayLength; currentIndexOfRightSplit++)
				rightOfSplitSum += nums[currentIndexOfRightSplit];

			// check if left side sum is equal to right side
			if (leftOfSplitSum == rightOfSplitSum)
				return index ;
			else {
				rightOfSplitSum = 0;
				leftOfSplitSum = 0;
			}
		}
		// if it is not possible to split array into
		// two parts
		return -1;
	}

	
	/**
	 * returns an array that contains exactly the same numbers as the input array,
	 * ,but rearranged so that every X is immediately followed by a Y, requires that X is fixed at its position 
	 * we can move Y from its position.
	 * @param nums, array of integers
	 * @param x, X value
	 * @param y, Y value
	 * @return returns rearranged array according to above specification
	 */
	public int[] fixXY(int[] nums, int x, int y) {
		int j = 1;
		int noOfX = 0;
		int noOfY = 0;
		if(nums.length==0)
		{
			throw new AssertionError("Assertion Error Occured: an empty array passed");
		}
		
		// count noOfX and noOfY
		for (int index = 0; index < nums.length;index++)
		{
			if(nums[index]==x)
			{
				noOfX++;
				
				// if adjacent X values are found throw error
				if(nums[index]==nums[index+1])
				{
					throw new AssertionError("Assertion Error occured: adjacent X values are there");
				}
			}
			if(nums[index]==y)
			{
				noOfY++;
			}
			
		}
		
		// if unequal number of X and Y occurs throw error
		if(noOfX!=noOfY){
			throw new AssertionError("Assertion Error Occured: unequal number of X and Y ");
		}
		
		// if X occurs at last index of array throw Assertion error
		if(nums[nums.length-1]==x)
		{
			throw new AssertionError("Asertion Error occured: x occurs at the last index of array");
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == x && nums[i + 1] != y) {
				while (nums[j] != y) {
					// finds the index of y
					if (j >= nums.length - 1)
						j = 0;
					else
						j++;

				}
				nums[j] = nums[i + 1];
				nums[i + 1] = y;
			}
		}
		return nums;
	}
}
