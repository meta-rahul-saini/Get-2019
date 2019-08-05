import static org.junit.Assert.*;

import org.junit.Test;


public class MolecularMassTest {

	@Test
	public void getMass_CH3H3CHO2H3_79()
	{
		MolecularMass molecular = new MolecularMass();
		int expectedOutput = 79;
		int computedOutput = molecular.getMass("CH3H3(CHO)2H3");
				
		assertEquals(expectedOutput, computedOutput);
	}
	
	@Test
	public void getMass_NestedFormula_79()
	{
		MolecularMass molecular = new MolecularMass();
		int expectedOutput = 431;
		int computedOutput = molecular.getMass("(C2(H10)10C)2C2C2(HH10)10H");
				
		assertEquals(expectedOutput, computedOutput);
	}
}
