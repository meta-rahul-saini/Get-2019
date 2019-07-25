import java.util.HashMap;
import java.util.Map;


/** this class represents cage in zoo
 * @author Rahul
 *
 */
public class Cage {

	private String cageType = null;

	private int capacity = 0;
	
	private int available = 0;
	
	// we maintains list of animals in animalList in current Cage
	
	private Map<Integer, Animal> animalList = new HashMap<>();
	

	/** this function adds animal into currentAvailable Cage
	 * @param animal, animal object to be added
	 * @return return true if animal added successfully, o/w false
	 */
	public boolean addAnimal(Animal animal)
	{
		if(available < capacity)
		{	
			
			animalList.put(available, animal);
			available++;
			return true;
		}
		else
		{
			throw new AssertionError("no space available, we can't add animal");
		}
	}
	
	/** this function used remove animal from zoo
	 * @param animalID, 
	 * @return return true if animal removed successfully, o/w false
	 */
	public boolean removeAnimal(int animalID)
	{

		for(Integer animalNo: animalList.keySet())
		{
			System.out.println("animal ID" + " " + animalList.get(animalNo).getAnimalID());
			
			if(animalList.get(animalNo).getAnimalID() == animalID)
			{
				available--;
				animalList.remove(animalID);
				System.out.println("animal removed successfully");
				return true;
			}
		}
		
		throw new AssertionError("no space available, we can't add animal");
	}
	
	
	// getters and setters
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailable() {
		return available;
	}


	public String getCageType() {
		return cageType;
	}

	public void setCageType(String cageType) {
		this.cageType = cageType;
	}
}
