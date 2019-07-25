


import static org.junit.Assert.*;

import org.junit.Test;

/**class to test negative test cases of zooMS
 * @author Rahul
 */
public class ZooMSNegativeTest {

	
		/**
		 * function to test addAnimal function of ZooMS 
		 */
		@Test(expected = AssertionError.class)
		public void addAnimalTest() {
			ZooMS zooMS = new ZooMS();

			Animal tiger1 = new Tiger();
			tiger1.setAge(10);
			tiger1.setGender("male");
			tiger1.setWeight(70);
			tiger1.setName("Singham");
			
			// here we are adding animal without having zone and cage that can contains it
			zooMS.addAnimal(tiger1);
		}
		
		/**
		 * function to test addZone function of ZooMS 
		 */
		@Test(expected = AssertionError.class)
		public void addZoneTest() {
			ZooMS zooMS = new ZooMS();
			
			// here we are passing a wrong zoneType value hence it should throw Assertion Error
			zooMS.addZone("#######", 2, true, true);
		}
		
		
		/**
		 * function to test addCage function of ZooMS 
		 */
		@Test(expected = AssertionError.class)
		public void addCageTest () {
			
			ZooMS zooMS = new ZooMS();
			
			// here we are adding cage without having specifies zone, hence it should throw Assertion Error
			zooMS.addCage("reptile", "tiger", 2);
		}
		
	}

