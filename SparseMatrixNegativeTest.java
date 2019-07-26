
import static org.junit.Assert.*;

import org.junit.Test;

/**SparseMatrices negative test cases class
 * @author rahul
 *
 */
public class SparseMatrixNegativeTest {


		/**
		 * function to test for addition of different dimension
		 */
		@Test(expected = AssertionError.class)
		public void addTest(){
			
			SparseMatrix sparseMatrix1 = new SparseMatrix(3, 3);
			
			sparseMatrix1.insert(0, 0, 1);

			sparseMatrix1.insert(0, 2, 2);

			sparseMatrix1.insert(2, 0, 2);
			
			SparseMatrix sparseMatrix2 = new SparseMatrix(2, 2);
			
			sparseMatrix2.insert(0, 0, 1);

			sparseMatrix2.insert(0, 1, 2);

			sparseMatrix2.insert(1, 0, 2);
			
			sparseMatrix1.add(sparseMatrix2);		
		}
		
		/**
		 * function to test for multiplication of different dimension
		 */
		@Test(expected = AssertionError.class)
		public void multiplyTest(){
			
			SparseMatrix sparseMatrix1 = new SparseMatrix(3, 3);
			
			sparseMatrix1.insert(0, 0, 1);

			sparseMatrix1.insert(0, 2, 2);

			sparseMatrix1.insert(2, 0, 2);
			
			SparseMatrix sparseMatrix2 = new SparseMatrix(2, 2);
			
			sparseMatrix2.insert(0, 0, 1);

			sparseMatrix2.insert(0, 1, 2);

			sparseMatrix2.insert(1, 0, 2);
			
			sparseMatrix1.multiply(sparseMatrix2);		
		}

	}
