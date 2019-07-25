import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZooMS {

	Map<Integer, Zone> zones = new HashMap<>();

	List<String> species = Arrays.asList(new String[]{"mammal", "reptile", "bird"});
	private static int zoneID;
	
	
	/**this function is used to add zone to zoo
	 * @param zoneType, specifies zoneType like "reptile", "mammal", etc.
	 * @param limitOfCages, specifies limit of Cages that it may contains
	 * @param hasPark, true if zone has park o/w false
	 * @param hasCanteen, true if zone has canteen o/w false
	 * @return 1 if zone added successfully o/w AssertionError is thrown
	 */
	public boolean addZone(String zoneType, Integer limitOfCages, boolean hasPark, boolean hasCanteen)
	{
	// generating a new ID
	zoneType = zoneType.toLowerCase();
	
	if(!species.contains(zoneType))
	{
		throw new AssertionError("Please specify a valid zone type");
	}
	zoneID++;
	
	Zone zone = new Zone();
	zone.setZoneType(zoneType);
	zone.setLimitOfCages(limitOfCages);
	zone.setPark(hasPark);
	zone.setCanteen(hasCanteen);
	zones.put(zoneID, zone);
	System.out.println(zoneType + " zoneID: " + zoneID + "successfully added"  );
	return true;
	}
	
	/** add animal to zone 
	 * @param animal, animal object
	 * @return true if animal added successfully o/w AssertionError is thrown
	 */
	public boolean addAnimal(Animal animal)
	{
		Zone zone;
		for(Integer zoneID : zones.keySet())
		{
			zone = zones.get(zoneID);
			
			System.out.println(" zoneType: " + zone.getZoneType() + " animalType: " + animal.getAnimalType());
			
			if(zone.getZoneType().equals(animal.getAnimalType()))
			{	
				boolean isAdded = zone.addAnimal(animal);
				return isAdded;
			}					
		}
		
		throw new AssertionError("Zone with given animal Type is not found");
	}
	
	/** function to remove animal 
	 * @param animalType, specifies animal type e.g. 'mammal', 'reptile', etc.
	 * @param animalGenericName, specifies generic name é.g. 'tiger', 'lizard', etc.
	 * @param animalID, specifies animalID
	 * @return, true if animal removed successfully o/w AssertionError is thrown
	 */
	public boolean removeAnimal(String animalType, String animalGenericName, int animalID)
	{
		animalType = animalType.toLowerCase();
		Zone zone;
		for(Integer zoneID : zones.keySet())
		{
			zone = zones.get(zoneID);
			
			System.out.println(" zoneType: " + zone.getZoneType() + " animalType: " + animalType);
			
			if(zone.getZoneType().equals(animalType))
			{
				System.out.println("removing animal");
				boolean isRemoved = zone.removeAnimal(animalGenericName, animalID);
				System.out.println("Removeing............");
				return isRemoved;
			}					
		}
		
		throw new AssertionError("Zone with given animal Type is not found");
	}
	
	/** function to add cage to zone
	 * @param zoneType, specifies type  of zone e.g. 'mammal', 'reptile', etc.
	 * @param animalGenericName, specifies generic name of animal to be added e.g. 'tiger', 'lizard', etc.
	 * @param capacity, specifies capacity of cage
	 * @return true if cage added to zone successfully o/w AssertionError is thrown
	 */
	public boolean addCage(String zoneType, String animalGenericName, int capacity)
	{
		zoneType = zoneType.toLowerCase();
		animalGenericName = animalGenericName.toLowerCase();
		Zone zone = null;
		for(Integer zoneID: zones.keySet())
		{
			zone = zones.get(zoneID);
			
			if(zone.getZoneType().toLowerCase().equals(zoneType))
			{
				System.out.println("============");
				zone = zones.get(zoneID);
				zone.addCage(animalGenericName, capacity);
				System.out.println("CAGE ADDED SUCCESSFULLY");
				return true;
			}
		}
		
		// if user passes an invalid zoneType
		throw new AssertionError("Please Specify a valid ZoneType");
		
	}

}

