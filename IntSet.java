
import java.util.Arrays;
import java.util.TreeSet;

/**
 * this is our intSet immutable class which accepts integer set in range [1,
 * 1000]
 * 
 * @author rahul
 */
public class IntSet {

	private Integer[] intSet;
	private final int MAX_VALUE = 1000;
	private final int MIN_VALUE = 1;

	private final TreeSet<Integer> sortedSet;

	public IntSet(Integer[] array) {
		int index = 0;
		Integer array1[];

		// sort and remove duplicates from array
		sortedSet = new TreeSet<Integer>(Arrays.asList(array));

		if (sortedSet.last() > MAX_VALUE || sortedSet.first() < MIN_VALUE)
			throw new AssertionError(" Can't handle value more than 1000 and less than 1");

		int length = sortedSet.size();

		array1 = new Integer[length];

		index = 0;
		// convert back to array
		for (int element : sortedSet) {
			array1[index] = element;
			index++;
		}
		this.intSet = array1;
	}

	/**
	 * checks weather x is member of intSet or not
	 * 
	 * @param x,
	 *            element to be checked
	 * @return true if element is member of set o/w return false;
	 */
	public boolean isMember(int x) {
		System.out.println(" binary search result: " + binarySearch(this.intSet, x));

		if (binarySearch(this.intSet, x) == -1)
			return false;
		else
			return true;
	}

	/**
	 * function to search element using binary search in sorted set
	 * 
	 * @param input,
	 *            input sorted array
	 * @param number,
	 *            element to be search
	 * @return return index if element is found o/w return -1;
	 */
	public int binarySearch(Integer[] input, int number) {
		int first = 0;
		int last = input.length - 1;
		int middle = (first + last) / 2;
		while (first <= last) {
			if (input[middle] == number) {
				return middle;
			} else if (input[middle] < number) {
				first = middle + 1;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		return -1;
	}

	/**
	 * @return size of intSet
	 */
	public int size() {
		return this.intSet.length;
	}

	/**
	 * checks weather the passed targetSet is subset of current set or not
	 * 
	 * @param targetSet
	 * @return returns true if targetSet is subset of current set o/w not
	 */
	public boolean isSubSet(IntSet targetSet) {

		final int SIZE_OF_TARGET_SET = targetSet.size();

		System.out.println(SIZE_OF_TARGET_SET);

		if (SIZE_OF_TARGET_SET == 0)
			return true;

		for (int index = 0; index < SIZE_OF_TARGET_SET; index++) {
			if (binarySearch(this.intSet, targetSet.intSet[index]) < 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * it returns complement of current integer set from range of (1, 1000)
	 * 
	 * @return returns complemented intSet
	 */
	public IntSet getComplement() {

		Integer[] complementArray = new Integer[MAX_VALUE - this.size()];
		int index = 0;
		final Integer MAX_VALUE_IN_SET = this.sortedSet.last();

		final Integer MIN_VALUE_IN_SET = this.sortedSet.first();

		int value = 0;

		// adding elements which are lesser than minimum in current set without checking
		for (value = MIN_VALUE; value < MIN_VALUE_IN_SET; value++) {
			complementArray[index] = value;
			index++;
		}

		// adding elements which are greater than maximum in current set without
		// checking
		for (value = MAX_VALUE_IN_SET + 1; value <= MAX_VALUE; value++) {
			complementArray[index] = value;
			index++;
		}

		// adding elements which are greater than minimum and lesser than maximum in
		// current set with checking
		for (value = MIN_VALUE_IN_SET; value <= MAX_VALUE_IN_SET; value++) {
			if (!this.sortedSet.contains(value)) {
				complementArray[index++] = value;
			}
		}

		return new IntSet(complementArray);
	}

	/**
	 * this method returns the union of current set and passed set
	 * 
	 * @param set2
	 * @return returns union of both of the set
	 */
	public IntSet union(IntSet set2) {
		int SET1_SIZE = this.size(), SET2_SIZE = set2.size();
		int TOTAL_SIZE = SET1_SIZE + SET2_SIZE;

		int[] uniqueElements = new int[TOTAL_SIZE];

		int index = 0;
		int indexOfUniqueElements = 0;
		int number = 0;
		int noOfCommon = 0;
		int UNION_SIZE = 0;
		Integer unionArray[];
		int uniqueElementsSize = 0;
		int indexOfCurrentArray = 0;

		// if set2 is empty then simply return first current set
		if (SET2_SIZE == 0) {
			return new IntSet(this.intSet);
		}

		index = 0;
		// adding the unique elements in set2 to unionArray
		while (index < SET2_SIZE) {
			number = set2.intSet[index];
			// if number1 in set2 is not member of set1, add it to union set
			if (!this.isMember(number)) {
				uniqueElements[indexOfUniqueElements] = number;
				indexOfUniqueElements++;
			} else {
				noOfCommon++;
			}
			index++;
		}

		uniqueElementsSize = indexOfUniqueElements;

		// creating a new array with length equal to no of elements in union of both set
		UNION_SIZE = TOTAL_SIZE - noOfCommon;
		unionArray = new Integer[UNION_SIZE];

		// adding unique elements to union Array
		for (index = 0; index < uniqueElementsSize; index++) {
			unionArray[index] = uniqueElements[index];
		}

		// adding remaining elements in current array to union array
		index = uniqueElementsSize;
		indexOfCurrentArray = 0;

		while (index < UNION_SIZE) {
			unionArray[index] = this.intSet[indexOfCurrentArray];
			index++;
			indexOfCurrentArray++;
		}

		return new IntSet(unionArray);
	}

	/**
	 * this function check weather tow intSet are equal or not
	 * 
	 * @param intSet
	 * @return
	 */
	public boolean isEqual(IntSet intSet) {
		Integer currentIntSetArray[] = this.intSet;

		Integer intSetArray[] = intSet.intSet;

		if (currentIntSetArray.length != intSet.intSet.length) {
			return false;
		} else {
			for (int index = 0; index < intSet.size(); index++) {
				if (currentIntSetArray[index] != intSetArray[index])
					return false;
			}
		}
		return true;
	}

	/**
	 * prints current integer set
	 */
	public void showIntSet() {
		int length = this.size();
		for (int index = 0; index < length; index++) {
			System.out.println(this.intSet[index]);
		}
	}

	public static void main(String[] args) {
		IntSet s1 = new IntSet(new Integer[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 });
		IntSet s2 = new IntSet(new Integer[] { 10, 11 });

		IntSet s3 = s1.getComplement();
		s3.showIntSet();

		IntSet s4 = s1.union(s2);
		s4.showIntSet();
		IntSet s5 = s1.getComplement();
		s5.showIntSet();
	}
}
