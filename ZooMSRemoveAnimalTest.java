import static org.junit.Assert.assertEquals;

import org.junit.Test;


/** this class is used to test removeAnimal function of zooMS class
 * @author Rahul
 *
 */
public class ZooMSRemoveAnimalTest {

	@Test
	public void removeAnimalTest() {
		
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
		
		// adding zones for mammals to zoo
		zooMS.addZone("Mammal", 2, true, true);
		
		// adding cage to zone with mammal type with capacity of 2 animals (here: tiger)
		zooMS.addCage("Mammal", "tiger", 2);
		
		
		assertEquals(true, zooMS.addAnimal(tiger1));
		assertEquals(true, zooMS.addAnimal(tiger2));
		
		// removing animal from mammal zone 
		assertEquals(true, zooMS.removeAnimal("Mammal", "tiger", 1));
		
		// now we have space for above removed animal hence we can add another to that zone
		assertEquals(true, zooMS.addAnimal(tiger2));
	}
}
