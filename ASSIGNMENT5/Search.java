import java.util.Arrays;

public class Search {

	int indexCount = 0;

	/** function to linearly search element in array and return index of that element 
	 * @param 	arrayOfNumbers
	 * @param 	targetElement
	 * @return 	it returns -1 if element not found o/w returns element index in array
	 */
	public  int linearSearch(int arrayOfNumbers[], int targetElement) 
	{
		
		final int NO_OF_ELEMENT_IN_ARRAY = arrayOfNumbers.length;

		if (NO_OF_ELEMENT_IN_ARRAY == 0)
		{
			return -1;
		}
		if (arrayOfNumbers[0] == targetElement) 
		{
			return indexCount;
		} 
		else 
		{
			indexCount++;
			return linearSearch(Arrays.copyOfRange(arrayOfNumbers, 1,
					NO_OF_ELEMENT_IN_ARRAY), targetElement);
		}
	}

	
	/**function to search element in array and return index of that element 
	 * Assumption is that elements passed is sorted
	 * @param 	arrayOfNumbers
	 * @param 	targetElement
	 * @return	returns -1 if element not found o/w returns element index in array
	 */
	public int binarySearch(int arrayOfNumbers[], int targetElement) 
	{
		final int NO_OF_ELEMENT_IN_ARRAY = arrayOfNumbers.length;

		// find the index of mid element
		final int INDEX_OF_MID_ELEMENT = arrayOfNumbers.length / 2;
		
		// return -1 if array is empty
		if (NO_OF_ELEMENT_IN_ARRAY == 0) 
		{
			return -1;
		}
		
		// if element is greater than maximum possible element then simply return -1
		else if(targetElement > arrayOfNumbers[NO_OF_ELEMENT_IN_ARRAY-1])
		{
			return -1;
		}

		// if element is found then return index of mid element
		if (arrayOfNumbers[INDEX_OF_MID_ELEMENT] == targetElement) 
		{
			return INDEX_OF_MID_ELEMENT;
		} 
		
		// if array is found in left sub array then make a recursive call to find element in that left sub array
		
		else if (targetElement < arrayOfNumbers[INDEX_OF_MID_ELEMENT])
		{

			int leftSubArray[] = Arrays.copyOfRange(arrayOfNumbers, 0, INDEX_OF_MID_ELEMENT);
			int indexOfElementInLeftSubArray = binarySearch(leftSubArray, targetElement);
			
			// if element is not found in left sub array then return -1
			if(indexOfElementInLeftSubArray==-1)
				return -1;
			// if element is found in left sub array then return index of element
			else
				return indexOfElementInLeftSubArray;
		}
		
		// search element in right sub array if element is greater than mid element
		else 
		{

			int rightSubArray[] = Arrays.copyOfRange(arrayOfNumbers, INDEX_OF_MID_ELEMENT, NO_OF_ELEMENT_IN_ARRAY);
			int indexOfElementInRightSubArray = binarySearch(rightSubArray, targetElement);
			
			// if element is not found in right sub array then return -1
			if(indexOfElementInRightSubArray==-1)
				return -1;
			
			// if element is found in right sub array then return index of element
			else
				return INDEX_OF_MID_ELEMENT + indexOfElementInRightSubArray;
		}
	}


}