import static org.junit.Assert.assertEquals;

import org.junit.Test;


/** this class is used to test removeAnimal function of zooMS
 * @author Rahul
 *
 */
public class ZooMSRemoveAnimalNegativeTest {

	@Test(expected = AssertionError.class)
	public void removeAnimalTest() {
		
		ZooMS zooMS = new ZooMS();
		
		// creating animals instances
		
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
		
		// adding zones to zoo for mammals
		zooMS.addZone("Mammal", 2, true, true);
		
		// adding cage for mammals
		zooMS.addCage("Mammal", "tiger", 2);

		
		assertEquals(true, zooMS.addAnimal(tiger1));
		
		// we are removing tiger with id ==3, whereas we don't have any animal with that id
		
		zooMS.removeAnimal("Mammal", "tiger", 3);
		
		// here we suply a wrong generic name of tiger hence we got an error
		
		zooMS.removeAnimal("Mammal", "tiger2", 3);
	}
}
