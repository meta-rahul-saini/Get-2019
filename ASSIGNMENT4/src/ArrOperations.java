public class ArrOperations {

	/**
	 * this function finds the maxMirror in the array
	 * @param arrayOfIntegers, array of integers
	 * @return length of maxMirror, and throw assertion error if array is empty.
	 */
	public int findMaxMirror(int[] arrayOfIntegers) {
		int maxLengthMirror = 0;
		int mirrorLength = 0;
		final int LENGTH_OF_ARRAY = arrayOfIntegers.length;

		if (LENGTH_OF_ARRAY == 0) 
		{
			throw new AssertionError("Assertion Error Occured: Please don't pass an empty array");
		}
		
		// finding length of max mirror
		
		for (int indexFromLeft = 0; indexFromLeft < LENGTH_OF_ARRAY; indexFromLeft++) 
		{
			for (int indexFromRight = LENGTH_OF_ARRAY - 1; indexFromRight >= 0
					&& indexFromLeft + mirrorLength < LENGTH_OF_ARRAY; indexFromRight--) 
			{
				if (arrayOfIntegers[indexFromLeft + mirrorLength] == arrayOfIntegers[indexFromRight]) 
				{
					mirrorLength++;
				} 
				else 
				{
					if (maxLengthMirror < mirrorLength) 
					{
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

	/**
	 * returns the number of clumps in input array, throws assertion error if array
	 * is empty
	 * @param arrayOfIntegers, array of integers
	 * @return noOfClumps, throws assertion error if array is empty
	 */
	public int countClumps(int[] arrayOfIntegers) {
		
		final int LENGTH_OF_ARRAY = arrayOfIntegers.length;
		int noOfClumps = 0;
		
		if (LENGTH_OF_ARRAY == 0) 
		{
			throw new AssertionError("Assertion Error Occured: an empty array passed");
		}
		
		// find no. of clumps
		for (int index = 0; index <= LENGTH_OF_ARRAY - 2; index++) 
		{
			if (arrayOfIntegers[index] == arrayOfIntegers[index + 1]) 
			{
				noOfClumps++;
				index++;
			}
			while (index < LENGTH_OF_ARRAY - 2 && arrayOfIntegers[index] == arrayOfIntegers[index + 1]) 
			{
				index++;
			}

		}
		return noOfClumps;
	}

	/**
	 * returns the split index so that sum of the number on one side is equal to the
	 * sum of the numbers on the other side
	 * @param arrayOfIntegers, array of Integers
	 * @return splitIndex, if found any split position then return split position
	 * o/w returns -1
	 */
	public int findSplitArrayIndex(int arrayOfIntegers[]) {
		
		int sumOfLeftOfSplit = 0;
		int sumOfRightFromSplit = 0;
		int LENGTH_OF_ARRAY = arrayOfIntegers.length;

		if (arrayOfIntegers.length == 0) 
		{
			throw new AssertionError("Assertion Error Occured: an empty array passed");
		}
		for (int index = 1; index < LENGTH_OF_ARRAY; index++) 
		{

			// sum of left side
			for (int currentIndexOfLeftSplit = 0; currentIndexOfLeftSplit < index; currentIndexOfLeftSplit++)
				sumOfLeftOfSplit += arrayOfIntegers[currentIndexOfLeftSplit];

			// sum of elements on rigth side
			for (int currentIndexOfRightSplit = index; currentIndexOfRightSplit < LENGTH_OF_ARRAY; currentIndexOfRightSplit++)
				sumOfRightFromSplit += arrayOfIntegers[currentIndexOfRightSplit];

			// check if left side sum is equal to right side
			if (sumOfLeftOfSplit == sumOfRightFromSplit)
				return index;
			else 
			{
				sumOfRightFromSplit = 0;
				sumOfLeftOfSplit = 0;
			}
		}
		
		/* if it is not possible to split array into
		two parts with equal sum on both side then simply return -1 */
		return -1;
	}
	

	/**
	 * returns an array that contains exactly the same numbers as the input array,
	 * ,but rearranged so that every X is immediately followed by a Y, requires that
	 * X is fixed at its position we can move Y from its position.
	 * @param arrayOfIntegers, array of integers
	 * @param x, X value
	 * @param y, Y value
	 * @return returns rearranged array according to above specification
	 */
	public int[] fixXY(int[] arrayOfIntegers, int x, int y) {
		int index2 = 1;
		int noOfX = 0;
		int noOfY = 0;
		final int LENGTH_OF_ARRAY = arrayOfIntegers.length;
		if (LENGTH_OF_ARRAY == 0) 
		{
			throw new AssertionError("Assertion Error Occured: an empty array passed");
		}

		// count noOfX and noOfY
		for (int index = 0; index < LENGTH_OF_ARRAY; index++) 
		{
			if (arrayOfIntegers[index] == x) 
			{
				noOfX++;
				
				// if adjacent X values are found throw error
				if (arrayOfIntegers[index] == arrayOfIntegers[index + 1])
				{
					throw new AssertionError("Assertion Error occured: adjacent X values are there");
				}
			}
			if (arrayOfIntegers[index] == y) 
			{
				noOfY++;
			}

		}

		// if unequal number of X and Y occurs throw error
		if (noOfX != noOfY) 
		{
			throw new AssertionError("Assertion Error Occured: unequal number of X and Y ");
		}

		// if X occurs at last index of array throw Assertion error
		if (arrayOfIntegers[LENGTH_OF_ARRAY - 1] == x) 
		{
			throw new AssertionError("Asertion Error occured: x occurs at the last index of array");
		}

		// rearranging array according to above specification
		
		index2 = 1;
		
		for (int index1 = 0; index1 < LENGTH_OF_ARRAY - 1; index1++) 
		{
			if (arrayOfIntegers[index1] == x && arrayOfIntegers[index1 + 1] != y) 
			{
				while (arrayOfIntegers[index2] != y) 
				{
					// finds the index of y
					if ( index2 >= LENGTH_OF_ARRAY - 1)
						index2 = 0;
					else
						index2++;

				}
				arrayOfIntegers[index2] = arrayOfIntegers[index1 + 1];
				arrayOfIntegers[index1 + 1] = y;
			}
		}
		return arrayOfIntegers;
	}
}
