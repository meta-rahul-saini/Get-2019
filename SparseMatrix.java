//**
 *sparseMatrix class to perform matrix operations using sparse data 
 @author Rahul
 *
 */
public class SparseMatrix {

	final private int MAX = 1000;

	int data[][];
	// dimensions of matrix
	private int rowSize, columnSize;

	// total number of elements in matrix
	int lenghtOfArray;

	/**
	 * constructor to initialize dimension parameters
	 * @param rowSize
	 * @param columnSize
	 */
	public SparseMatrix(int rowSize, int columnSize) {
		// initialize rowSize
		this.rowSize = rowSize;
		// initialize column
		this.columnSize = columnSize;
		data = new int[MAX][3];
		// initialize length to 0
		lenghtOfArray = 0;
	}

	// insert elements into sparse matrix
	/**
	 * insert the entry of sparse matrix into 3D array, throws AssertionError if
	 * wrong entry is passed;
	 * 
	 * @param rowSize
	 *            , rowSizeIndex of value in sparse matrix
	 * @param columnSize
	 *            , columnSizeIndex of value in sparse matrix
	 * @param value
	 *            , value in sparse matrix
	 */
	public void insert(final int rowIndex, final int columnIndex,
			final int value) {

		// invalid entry
		if (rowIndex > this.rowSize || columnIndex > this.columnSize) {

			System.out.println("Wrong entry");
			throw new AssertionError("Wrong Entry");
		}

		else {

			// insert rowSizeIndex value
			data[lenghtOfArray][0] = rowIndex;

			// insert columnSize value
			data[lenghtOfArray][1] = columnIndex;

			// insert element's value
			data[lenghtOfArray][2] = value;

			// increment number of data in matrix
			lenghtOfArray++;
		}
	}

	/**
	 * function to check for symmetry
	 * 
	 * @return true if matrices are symmetry o/w return false;
	 */
	public boolean isSymmetry() {
		for (int i = 0; i < this.lenghtOfArray; i++) {
			if (!contains(this.data[i][1], this.data[i][0])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * helper function, we used to find weather the our sparse matrix contains
	 * non-zero element on given index
	 * 
	 * @param colIndex
	 * @param rowIndex
	 * @return
	 */
	public boolean contains(int colIndex, int rowIndex) {
		for (int index = 0; index < this.lenghtOfArray; index++) {
			if (this.data[index][0] == colIndex
					&& this.data[index][1] == rowIndex)
				return true;
		}
		return false;
	}

	/**
	 * function to add two matrices
	 * 
	 * @param b
	 *            , second matrix to which we add current matrix
	 * @return addition of two matrices if they have same dimension o/w throw
	 *         AssertionError
	 */
	public SparseMatrix add(SparseMatrix b) {
		SparseMatrix result = new SparseMatrix(this.rowSize, this.columnSize);
		;
		// if matrices don't have same dimensions
		if (this.rowSize != b.rowSize || this.columnSize != b.columnSize) {
			throw new AssertionError("matrices can't be added, they have different dimensions");
		}

		else {

			int indexOfA = 0, indexOfB = 0;

			while (indexOfA < this.lenghtOfArray && indexOfB < b.lenghtOfArray) {

				// if b's row and col is smaller
				if (data[indexOfA][0] > b.data[indexOfB][0]
						|| (data[indexOfA][0] == b.data[indexOfB][0] && data[indexOfA][1] > b.data[indexOfB][1])) {
					// insert smaller value into result
					result.insert(b.data[indexOfB][0], b.data[indexOfB][1],
							b.data[indexOfB][2]);

					indexOfB++;
				}
				// if a's row and col is smaller
				else if (data[indexOfA][0] < b.data[indexOfB][0]
						|| (data[indexOfA][0] == b.data[indexOfB][0] && data[indexOfA][1] < b.data[indexOfB][1]))

				{
					// insert smaller value into result
					result.insert(data[indexOfA][0], data[indexOfA][1],
							data[indexOfA][2]);

					indexOfA++;
				} else {

					// add the values as row and col is same
					int addedval = data[indexOfA][2] + b.data[indexOfB][2];

					if (addedval != 0)
						result.insert(data[indexOfA][0], data[indexOfA][1],
								addedval);
					// then insert
					indexOfA++;
					indexOfB++;
				}
			}

			// insert remaining elements
			while (indexOfA < this.lenghtOfArray)
				result.insert(data[indexOfA][0], data[indexOfA][1],
						data[indexOfA++][2]);

			while (indexOfB < b.lenghtOfArray)
				result.insert(b.data[indexOfB][0], b.data[indexOfB][1],
						b.data[indexOfB++][2]);

			// print result

		}
		return result;
	}

	
	/**this function checks weather two Sparse matrix are equal or not
	 * @param sparseMatrix
	 * @return, true if matrices are equal o/w false
	 */
	public boolean isEquals(SparseMatrix sparseMatrix)
	{
		int matchedElements = 0;
		int noOfNonZeroElements = this.getLenghtOfArray();
		
		if(this.getColumnSize() != sparseMatrix.getColumnSize() && this.getRowSize() != sparseMatrix.getRowSize())
		{
		return false;
		}
		for (int index1 = 0; index1 < this.getLenghtOfArray(); index1++) 
		{
		for (int index2 = 0; index2 < this.getLenghtOfArray(); index2++) 
		{
			if( (this.data[index1][0] == sparseMatrix.data[index2][0]) && (this.data[index1][1] == sparseMatrix.data[index2][1]) 
					&& this.data[index1][2] == sparseMatrix.data[index2][2])
			{
				matchedElements++;
			}
		}
		}
		
		if(noOfNonZeroElements == matchedElements)
			return true;
		else 
			return false;
	}
	
	
	public SparseMatrix getTranspose() {

		final int ROW_INDEX = 0;
		final int COLUMN_INDEX = 1;
		final int VALUE = 2;

		SparseMatrix result = new SparseMatrix(this.columnSize, this.rowSize);

		int data[];
		for (int index1 = 0; index1 < this.getLenghtOfArray(); index1++) {
			data = this.data[index1];

			result.insert(data[COLUMN_INDEX], data[ROW_INDEX], data[VALUE]);
		}
		return result;
	}

	public SparseMatrix multiply(SparseMatrix b) {
		
		if(this.columnSize == b.getRowSize())
		{
		final int LENGTH_OF_A = this.getLenghtOfArray();
		final int LENGTH_OF_B = b.getLenghtOfArray();
		int result[][] = new int[this.getRowSize()][this.getColumnSize()];
		int rowSize = result.length;
		int colSize = result[0].length;
		int currentValue = 0;
		SparseMatrix transposeOfB = b.getTranspose();

		for (int index1 = 0; index1 < LENGTH_OF_A; index1++) {
			for (int index2 = 0; index2 < LENGTH_OF_B; index2++) {
				if (this.data[index1][1] == transposeOfB.data[index2][1])
					// multiply elements of matrix
					result[this.data[index1][0]][transposeOfB.data[index2][0]] += this.data[index1][2]
							* transposeOfB.data[index2][2];
			}
		}

		SparseMatrix sparseMatrixOfResult = new SparseMatrix(rowSize, colSize);

		for (int rowIndex = 0; rowIndex < this.rowSize; rowIndex++) {
			for (int colIndex = 0; colIndex < this.columnSize; colIndex++) {
				currentValue = result[rowIndex][colIndex];

				if (currentValue != 0) {
					sparseMatrixOfResult.insert(rowIndex, colIndex,
							currentValue);
					currentValue = 0;
				}
			}
		}

		System.out.println(" before return");
		return sparseMatrixOfResult;
		}
		else
		{
				throw new AssertionError("multiply condition not satisfied");
		}
	}

	// // printing matrix
	public void print() {
		System.out.println("Dimension: " + rowSize + "x" + this.columnSize);
		System.out.println("Sparse Matrix: \nrowSize columnSize Value");

		for (int i = 0; i < this.lenghtOfArray; i++) {

			System.out
					.println(data[i][0] + " " + data[i][1] + " " + data[i][2]);
		}
	}

	public static void main(String args[]) {

		// create two sparse matrices and insert values
		SparseMatrix a = new SparseMatrix(3, 3);
		SparseMatrix b = new SparseMatrix(3, 3);

		a.insert(0, 0, 1);
		a.insert(0, 1, 2);
		a.insert(1, 0, 2);
		a.insert(2, 2, 3);

		b.insert(0, 1, 1);
		b.insert(1, 2, 3);
		b.insert(2, 2, 2);

		System.out.println(" SYMMETRY" + a.isSymmetry());
		a.print();

		b.print();
		System.out.println("ADDITION");
		SparseMatrix d = a.add(b);

		d.print();

		System.out.println("MULTIPLY");
		SparseMatrix mul = a.multiply(b);
		mul.print();

	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
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
