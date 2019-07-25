
/** this is our main controller class
 * @author Rahul
 *
 */
public class MainControllerClass {

		public static void main(String[] args) {

			// create zooMS (zoo management system) object
			ZooMS zooMS = new ZooMS();

			// creating animal instances
			
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
			
			Animal horse1 = new Tiger();
			horse1.setAge(20);
			horse1.setGender("male");
			horse1.setWeight(100);
			horse1.setName("badal1");
			
			Animal horse2 = new Tiger();
			horse2.setAge(10);
			horse2.setGender("male");
			horse2.setWeight(100);
			horse2.setName("badal2");
			
			Animal horse3 = new Tiger();
			horse3.setAge(10);
			horse3.setGender("male");
			horse3.setWeight(30);
			horse3.setName("badal3");
			
			Animal lizard1 = new Lizard();
			lizard1.setAge(1);
			lizard1.setGender("male");
			lizard1.setWeight(0.5F);
			lizard1.setName("rani");
			
			Animal pigeon1 = new Pigeon();
			pigeon1.setAge(10);
			pigeon1.setGender("male");
			pigeon1.setWeight(30);
			pigeon1.setName("Kabutar1");
			
			Animal pigeon2 = new Pigeon();
			pigeon2.setAge(2);
			pigeon2.setGender("male");
			pigeon2.setWeight(1.5F);
			pigeon2.setName("Kabutar2");
			
			// creating zone object and add to zoo 
			zooMS.addZone("Reptile", 2, true, true);
			
			zooMS.addZone("Mammal", 2, true, true);
			
			// adding cage to zone 
			zooMS.addCage("Reptile", "lizard", 2);
			
			zooMS.addCage("Mammal", "horse", 2);
			
			zooMS.addCage("Mammal", "tiger", 2);
			
			
			// adding animal to zoo
			boolean isAdded = zooMS.addAnimal(tiger1);
			
			
			zooMS.addAnimal(tiger2);

			zooMS.addAnimal(lizard1);
			
			// removing animal from zoo
			
			zooMS.removeAnimal("Mammal", "tiger", 0);

			zooMS.addAnimal(tiger2);
			
			System.out.println("Added: "  + isAdded);
			
			System.out.println(" FINISH ");
		}

}
