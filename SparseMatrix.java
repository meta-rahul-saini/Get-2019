// Java code to perform add, 
// multiply and transpose on sparse matrices 

public class SparseMatrix {

	final private int MAX = 1000;

	int data[][];
	// dimensions of matrix
	private int rowLength, columnLength;

	// total number of elements in matrix
	int lenghtOfArray;

	public SparseMatrix(int rowLength, int columnLength) 
	{

		// initialize rowLength
		this.rowLength = rowLength;

		// initialize column
		this.columnLength = columnLength;
		
		data = new int[MAX][3]; 
		
		// initialize length to 0
		lenghtOfArray = 0;
	}

	// insert elements into sparse matrix
	/**
	 * insert the entry of sparse matrix into 3D array, throws AssertionError if wrong entry is passed;
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
			throw new AssertionError("Wrong Entry");
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
				|| this.columnLength != b.getcolumnLength()) 
		{
			System.out.println("Matrices can't be added");
			throw new AssertionError("Matrices have different dimensions, so they can't be added");
		}

		else 
		{

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

				// if a's rowLength is smaller
				else if (data[indexOfA][rowIndex] < b.data[indexOfB][rowIndex]
						|| (data[indexOfA][rowIndex] == b.data[indexOfB][0] && data[indexOfA][columnIndex] < b.data[indexOfB][columnIndex]))
				{
					// insert smaller value into result
					result.insert(data[indexOfA][0], data[indexOfA][1],
							data[indexOfA][2]);
					indexOfA++;
				}
				
				// if both's matrices have value on same index then simply add them and insert to results
				else {
					// add the values as rowLength and column is same
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

		final int ROW_INDEX = 0;
		final int COLUMN_INDEX = 1;
		final int VALUE = 2;
		
		SparseMatrix result = new SparseMatrix(this.columnLength, this.rowLength);

		int data[];
		for(int index1 = 0 ; index1 < this.getLenghtOfArray(); index1++)
		{
			data = this.data[index1];
			
			result.insert(data[COLUMN_INDEX], data[ROW_INDEX], data[VALUE]);
		}
		return result;
	}


	 public SparseMatrix multiply(SparseMatrix b)
	 {
	
		 final int LENGTH_OF_A = this.getLenghtOfArray();
		 
		 final int LENGTH_OF_B = b.getLenghtOfArray();
		 
		 SparseMatrix mul = new SparseMatrix(4, 4);
		 
		 int index_mul = 0;
//		 for( int index1 = 0; index1 < LENGTH_OF_A; index1++ )
//		 {
//			 for (int index2 = 0; index2 < LENGTH_OF_B; index2++ )
//			 {
//				 int row1 = this.data[index1][0];
//				 int col1 = this.data[index1][1];
//				 
//				 int row2 = b.data[index2][0];
//				 int col2 = b.data[index2][1];
//				 if(col1==row2)
//				 {
//					 mul.data[index_mul][0] = row1;
//					 mul.data[index_mul][1] = col2;
//					 mul.data[index_mul][2] = this.data[index1][2]*b.data[index2][2];  
//				}
//			 }
	 return mul;
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

		System.out.println("normal matrix");
		a.print();
		SparseMatrix c = a.transpose();

		System.out.println("transpose");
		c.print();

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
