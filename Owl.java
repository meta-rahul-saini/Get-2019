
/**Owl is subclass of Bird hence it inherits all the properties of superclass 'Bird'and super super class 'Animal'
 * @author Rahul
 *
 */
public class Owl extends Bird {

	@Override
	public String getGenericName()
	{
		return "owl";
	}
	
	@Override
	public String getSound() {
		return "Hoots";
	}

	@Override
	public String[] getFood() {
		
		String[] food = { "Rodents", "Leporids", "Shrews", "Voles", "Birds",
				"Bats", "Insects", "Reptiles" };

		return food;
	}

	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return "tree";
	}

	@Override
	public String getFoodType() {
		return "Omnivore";
	}

	
}
