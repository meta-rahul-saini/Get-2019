import static org.junit.Assert.*;

import org.junit.Test;


public class SparseMatrixTest {
	
	/**
	 * this function test for isSymmetry function in sparse matrices
	 */
	@Test
	public void isSymmetryTest(){
		SparseMatrix sparseMatrix1 = new SparseMatrix(3, 3);
		
		sparseMatrix1.insert(0, 0, 1);

		sparseMatrix1.insert(0, 2, 2);

		sparseMatrix1.insert(2, 0, 2);
		
		assertEquals(true, sparseMatrix1.isSymmetry());	
	
		SparseMatrix sparseMatrix2 = new SparseMatrix(3, 3);
		
		sparseMatrix2.insert(0, 0, 1);

		sparseMatrix2.insert(0, 1, 5);

		sparseMatrix2.insert(2, 0, 2);
		
		assertEquals(false, sparseMatrix2.isSymmetry());
	}
	
	/**
	 * this function test for transpose function weather computed is equal to actual  or not
	 */
	@Test
	public void getTransposeTest(){
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(3, 3);
		
		sparseMatrix1.insert(0, 0, 1);

		sparseMatrix1.insert(0, 2, 2);

		sparseMatrix1.insert(2, 0, 2);
		
		SparseMatrix sparseMatrix2 = new SparseMatrix(3, 3);
		
		sparseMatrix2.insert(0, 0, 1);

		sparseMatrix2.insert(0, 2, 2);

		sparseMatrix2.insert(2, 0, 2);
		
		assertEquals(true, sparseMatrix1.isEquals(sparseMatrix2));	
		
		SparseMatrix sparseMatrix3 = new SparseMatrix(3, 3);
		
		sparseMatrix3.insert(0, 0, 1);

		sparseMatrix3.insert(0, 1, 5);

		sparseMatrix3.insert(2, 0, 2);
		
		assertEquals(false, sparseMatrix1.isEquals(sparseMatrix3));
			
	}
	
	/**
	 * this function tests weather computed addition is equal to actual or not
	 */
	@Test
	public void addTest(){
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(3, 3);
		
		sparseMatrix1.insert(0, 0, 1);

		sparseMatrix1.insert(0, 2, 2);

		sparseMatrix1.insert(2, 0, 2);
		
		SparseMatrix sparseMatrix2 = new SparseMatrix(3, 3);
		
		sparseMatrix2.insert(0, 0, 1);

		sparseMatrix2.insert(0, 2, 2);

		sparseMatrix2.insert(2, 0, 2);
		
		SparseMatrix computedAddition1 = sparseMatrix1.add(sparseMatrix2);
		
		SparseMatrix actualAddition1  = new SparseMatrix(3, 3);
		actualAddition1.insert(0, 0, 2);
		actualAddition1.insert(0, 2, 4);
		actualAddition1.insert(2, 0, 4);
		
		assertEquals(true, computedAddition1.isEquals(actualAddition1));	
		
		SparseMatrix sparseMatrix3 = new SparseMatrix(3, 3);
		
		sparseMatrix3.insert(0, 0, 1);

		sparseMatrix3.insert(0, 1, 5);

		sparseMatrix3.insert(2, 0, 2);
		
		SparseMatrix computedAddition2 = sparseMatrix3.add(sparseMatrix2);
		SparseMatrix actualAddition2  = new SparseMatrix(3, 3);
		actualAddition2.insert(0, 0, 2);
		actualAddition2.insert(0, 1, 5);
		actualAddition2.insert(0, 2, 2);
		actualAddition2.insert(2, 0, 4);
		
		assertEquals(true, computedAddition2.isEquals(actualAddition2));
	
	}
	
	/**
	 * this function tests weather computed multiplication is equal to actual or not
	 */
	@Test
	public void multiplyTest(){
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(3, 3);
		
		sparseMatrix1.insert(0, 0, 1);

		sparseMatrix1.insert(0, 2, 2);

		sparseMatrix1.insert(2, 0, 2);
		
		SparseMatrix sparseMatrix2 = new SparseMatrix(3, 3);
		
		sparseMatrix2.insert(0, 0, 1);

		sparseMatrix2.insert(0, 2, 2);

		sparseMatrix2.insert(2, 0, 2);
		
		SparseMatrix computedMultiplication1 = sparseMatrix1.multiply(sparseMatrix2);
		
		SparseMatrix actualMultiplication1  = new SparseMatrix(3, 3);
		actualMultiplication1.insert(0, 0, 5);
		actualMultiplication1.insert(0, 2, 2);
		actualMultiplication1.insert(2, 0, 2);
		actualMultiplication1.insert(2, 2, 4);
		
		assertEquals(true, computedMultiplication1.isEquals(actualMultiplication1));	
		
	}

}
