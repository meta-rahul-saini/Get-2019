import java.util.HashMap;
import java.util.Map;

/** this is our zone class which contains (has-a relationship) cages with their id
 * @author Rahul
 */
public class Zone {

	private Map<Integer, Cage> cages = new HashMap<Integer, Cage>();
	
	private String zoneType;
	
	private int cageID = 0;
	
	private int noOfCages = 0;
	
	private int limitOfCages = 0;
	
	private boolean hasPark = false;
	
	private boolean hasCanteen = false;
	
	
	/** add animal to cage it contains
	 * @param animal, animal object passed
	 * @return true, if animal added successfully o/w AssertionError is thrown
	 */
	public boolean addAnimal(Animal animal)
	{
		Cage cage = null;
		
		System.out.println("in zone class");
		for(Integer cageID : cages.keySet() )
		{
			cage = cages.get(cageID);
			
			if(cage.getCageType() == animal.getGenericName())
			{
				
				boolean isAdded = cage.addAnimal(animal);
				return isAdded;
			}
		}
		throw new AssertionError("Cage not available ");
	}
	
	
	/**remove animal from cage it contains
	 * @param animalGenericName
	 * @param animalID
	 * @return true, if animal removed successfully o/w AssertionError is thrown
	 */
	public boolean removeAnimal(String animalGenericName, int animalID)
	{
		Cage cage = null;
		animalGenericName = animalGenericName.toLowerCase();
		
		for(Integer cageID : cages.keySet() )
		{
			cage = cages.get(cageID);
			
			if(cage.getCageType().equals(animalGenericName))
			{
				System.out.println("removing animal from zone");
				boolean isRemoved = cage.removeAnimal(animalID);
				System.out.println("++++++++++++++");
				return isRemoved;
			}
		}
		
		throw new AssertionError("Please Enter a valid generic name");
	}
	
	/**adds cage to zone 
	 * @param animalGenericName, animal generic name like Tiger has generic name "tiger"
	 * @param capacity, capacity of cage to be added
	 */
	public void addCage(String animalGenericName, int capacity)
	{
		if(this.noOfCages >= limitOfCages)
		{
			throw new AssertionError("Sorry we don't have much space");
		}
		else
		{
			cageID++;
			noOfCages = noOfCages + 1;
			Cage cage = new Cage();
			cage.setCageType(animalGenericName);
			cage.setCapacity(capacity);
			cages.put(cageID, cage);
			System.out.println(animalGenericName + " with cageID: " + cageID + "successfully added"  );
		}
	}
	
	
	// getters and setters 
	
	public String getZoneType() {
		return zoneType;
	}

	public void setZoneType(String zoneType) {
		this.zoneType = zoneType;
	}
	
	public int getNoOfCages() {
		return noOfCages;
	}

	public int getLimitOfCages() {
		return limitOfCages;
	}

	public void setLimitOfCages(int limitOfCages) {
		this.limitOfCages = limitOfCages;
	}

	public boolean hasPark() {
		return hasPark;
	}

	public void setPark(boolean hasPark) {
		this.hasPark = hasPark;
	}

	public boolean hasCanteen() {
		return hasCanteen;
	}

	public void setCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}
}
