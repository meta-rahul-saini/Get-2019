// Java code to perform add, 
// multiply and transpose on sparse matrices 

public class SparseMatrix {

	final private int MAX = 1000;

	int data[][] = new int[MAX][3];
	// dimensions of matrix
	private int rowLength, columnLength;

	// total number of elements in matrix
	int lenghtOfArray;

	public SparseMatrix(int rowLength, int columnLength) {

		// initialize rowLength
		this.rowLength = rowLength;

		// initialize column
		this.columnLength = columnLength;

		// initialize length to 0
		lenghtOfArray = 0;
	}

	// insert elements into sparse matrix
	/**
	 * insert the entry of sparse matrix into 3D array
	 * 
	 * @param rowLength
	 *            , rowLengthIndex of value in sparse matrix
	 * @param columnLength
	 *            , columnLengthIndex of value in sparse matrix
	 * @param value
	 *            , value in sparse matrix
	 */
	public void insert(final int rowLength, final int columnLength,
			final int value) {

		// invalid entry
		if (rowLength > this.rowLength || columnLength > this.columnLength) {
			System.out.println("Wrong entry");
		}

		else {

			// insert rowLengthIndex value
			data[lenghtOfArray][0] = rowLength;

			// insert columnLength value
			data[lenghtOfArray][1] = columnLength;

			// insert element's value
			data[lenghtOfArray][2] = value;

			// increment number of data in matrix
			lenghtOfArray++;
		}
	}

	public void add(SparseMatrix b) {

		final int rowIndex = 0;
		final int columnIndex = 0;
		// if matrices don't have same dimensions
		if (this.rowLength != b.getcolumnLength()
				|| this.columnLength != b.getcolumnLength()) {
			System.out.println("Matrices can't be added");
		}

		else {

			int indexOfA = 0, indexOfB = 0;
			SparseMatrix result = new SparseMatrix(this.rowLength,
					this.columnLength);

			while (indexOfA < this.lenghtOfArray && indexOfB < b.lenghtOfArray) {

				// if b's rowIndex and columnIndex is smaller
				if (this.data[indexOfA][rowIndex] > b.data[indexOfB][rowIndex]
						|| (this.data[indexOfA][rowIndex] == b.data[indexOfB][rowIndex] && this.data[indexOfA][columnIndex] > b.data[indexOfB][columnIndex]))

				{

					// insert smaller value into result
					result.insert(b.data[indexOfB][0], b.data[indexOfB][1],
							b.data[indexOfB][2]);

					indexOfB++;
				}

				// if a's rowLength and col is smaller
				else if (data[indexOfA][rowIndex] < b.data[indexOfB][rowIndex]
						|| (data[indexOfA][rowIndex] == b.data[indexOfB][0] && data[indexOfA][columnIndex] < b.data[indexOfB][columnIndex]))

				{

					// insert smaller value into result
					result.insert(data[indexOfA][0], data[indexOfA][1],
							data[indexOfA][2]);

					indexOfA++;
				}

				else {

					// add the values as rowLength and col is same
					int addedval = data[indexOfA][2] + b.data[indexOfB][2];

					if (addedval != 0)
						result.insert(data[indexOfA][0], data[indexOfA][1],
								addedval);
					// then insert
					indexOfA++;
					indexOfB++;
				}
			}

			result.print();
		}
	}

	public SparseMatrix transpose() {

		// new matrix with inversed rowLength X col
		SparseMatrix result = new SparseMatrix(this.columnLength,
				this.rowLength);

		// same number of elements
		result.lenghtOfArray = this.lenghtOfArray;

		// to count number of elements in each columnLength
		int count[] = new int[this.columnLength + 1];

		// initialize all to 0
		for (int i = 1; i <= this.columnLength; i++)
			count[i] = 0;

		for (int i = 0; i < this.lenghtOfArray; i++)
			count[data[i][1]]++;

		int[] index = new int[this.columnLength + 1];

		// to count number of elements having col smaller
		// than particular i

		// as there is no col with value < 1
		index[1] = 0;

		// initialize rest of the indices
		for (int i = 2; i <= this.columnLength; i++)

			index[i] = index[i - 1] + count[i - 1];

		for (int i = 0; i < this.lenghtOfArray; i++) {

			// insert a data at rpos and increment its value
			int rpos = index[data[i][1]]++;

			// transpose rowLength=col
			result.data[rpos][0] = data[i][1];

			// transpose col=rowLength
			result.data[rpos][1] = data[i][0];

			// same value
			result.data[rpos][2] = data[i][2];
		}
		return result;
	}

	// the above method ensures
	// sorting of transpose matrix
	// according to rowLength-col value

	// }
	//
	 public SparseMatrix multiply(SparseMatrix b)
	 {
	
	 if (this.lenghtOfArray != b.rowLength) {
	
	 // Invalid multiplication
	 System.out.println("Can't multiply, "
	 + "Invalid dimensions");
	 }
	
	 // transpose b to compare rowLength
	 // and col values and to add them at the end
	 b = b.transpose();
	 int apos, bpos;
	
	 // result matrix of dimension rowLength X b.col
	 // however b has been transposed, hence rowLength X b.rowLength
	 SparseMatrix result = new SparseMatrix(rowLength, b.rowLength);
	
	 // iterate over all elements of A
	 for (apos = 0; apos < this.lenghtOfArray;) {
	
	 // current rowLength of result matrix
	 int r = data[apos][0];
	
	 // iterate over all elements of B
	 for (bpos = 0; bpos < b.lenghtOfArray;) {
	
	 // current columnLength of result matrix
	 // data[][0] used as b is transposed
	 int c = b.data[bpos][0];
	
	 // temporary pointers created to add all
	 // multiplied values to obtain current
	 // element of result matrix
	 int tempa = apos;
	 int tempb = bpos;
	
	 int sum = 0;
	
	 // iterate over all elements with
	 // same rowLength and col value
	 // to calculate result[r]
	 while (tempa < this.columnLength && data[tempa][0] == r
	 && tempb < b.lenghtOfArray && b.data[tempb][0] == c) {
	
	 if (data[tempa][1] < b.data[tempb][1])
	
	 // skip a
	 tempa++;
	
	 else if (data[tempa][1] > b.data[tempb][1])
	
	 // skip b
	 tempb++;
	 else
	
	 // same col, so multiply and increment
	 sum += data[tempa++][2] * b.data[tempb++][2];
	 }
	
	 // insert sum obtained in result[r]
	 // if its not equal to 0
	 if (sum != 0)
	 result.insert(r, c, sum);
	
	 while (bpos < b.lenghtOfArray && b.data[bpos][0] == c)
	
	 // jump to next columnLength
	 bpos++;
	 }
	
	 while (apos < this.lenghtOfArray && data[apos][0] == r)
	
	// jump to next rowLength
	 apos++;
	 }
	
	 return result;
	 }
	//
	// // printing matrix
	public void print() {
		System.out.println("Dimension: " + rowLength + "x" + this.columnLength);
		System.out.println("Sparse Matrix: \nrowLength columnLength Value");

		for (int i = 0; i < this.lenghtOfArray; i++) {

			System.out
					.println(data[i][0] + " " + data[i][1] + " " + data[i][2]);
		}
	}

	public static void main(String args[]) {

		// create two sparse matrices and insert values
		SparseMatrix a = new SparseMatrix(4, 4);
		SparseMatrix b = new SparseMatrix(4, 4);

		a.insert(1, 2, 10);
		a.insert(1, 4, 12);
		a.insert(3, 3, 5);
		a.insert(4, 1, 15);
		a.insert(4, 2, 12);

		b.insert(1, 3, 8);
		b.insert(2, 4, 23);
		b.insert(3, 3, 9);
		b.insert(4, 1, 20);
		b.insert(4, 2, 25);

		SparseMatrix c = a.transpose();
		// Output result
		a.add(b);
		// System.out.println("\nMultiplication: ");
		// a.multiply(b);
		// System.out.println("\nTranspose: ");
		// sparse_matrix atranspose = a.transpose();
		// atranspose.print();
		c = a.transpose();
		
		SparseMatrix d  = a.multiply(b);
		d.print();
	}

	public int getrowLength() {
		return rowLength;
	}

	public void setrowLength(int rowLength) {
		this.rowLength = rowLength;
	}

	public int getcolumnLength() {
		return columnLength;
	}

	public void setcolumnLength(int columnLength) {
		this.columnLength = columnLength;
	}

	public int getLenghtOfArray() {
		return lenghtOfArray;
	}

	public void setLenghtOfArray(int lenghtOfArray) {
		this.lenghtOfArray = lenghtOfArray;
	}

	public int getMAX() {
		return MAX;
	}
}