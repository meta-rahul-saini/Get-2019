import static org.junit.Assert.*;

import org.junit.Test;

/** this class is used to test functions of zooMS 
 * @author Rahul
 *
 */
public class ZooMSTest {

	/**
	 * this function is used to addZone function of zooMS
	 */
	@Test
	public void addZoneTest() {
		ZooMS zooMS = new ZooMS();
		
		// we are able to successfully add zone to zoo if we pass right value
		assertEquals(true, zooMS.addZone("Mammal", 2, true, true));
	}

	/**
	 * function to test addAnimal function of zooMS 
	 */
	@Test
	public void addAnimalTest() {
		
		ZooMS zooMS = new ZooMS();

		Animal tiger1 = new Tiger();
		tiger1.setAge(10);
		tiger1.setGender("male");
		tiger1.setWeight(70);
		tiger1.setName("Singham");

		Animal tiger2 = new Tiger();
		tiger2.setAge(20);
		tiger2.setGender("male");
		tiger2.setWeight(60);
		tiger2.setName("Simba");

		zooMS.addZone("Mammal", 2, true, true);
		zooMS.addCage("Mammal", "tiger", 2);

		// testing addAnimal function output
		assertEquals(true, zooMS.addAnimal(tiger1));
		assertEquals(true, zooMS.addAnimal(tiger2));
	}

	/**
	 * function to test addCage function of zooMS
	 */
	@Test
	public void addCageTest () {
		
		ZooMS zooMS = new ZooMS();
		
		zooMS.addZone("reptile", 2, true, true);
		
		// testing addCage function
		assertEquals(true, zooMS.addCage("reptile", "tiger", 2));
	}

	


}
