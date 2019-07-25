
/** horse is subclass of Mammal hence it inherits all the properties of superclass 'Mammal' and super super class 'Animal'
 * @author Rahul
 *
 */
public class Horse extends Mammal {

	
	@Override
	public String getGenericName()
	{
		return "horse";
	}
	
	@Override
	public String getSound() {
		return "neigh";
	}

	@Override
	public String[] getFood() {
		String [] food = {"coconut", "lemons", "melons", "oranges", "plums", "etc."};
		return food;
	}

	@Override
	public String getFoodType() {
		return "herbivor";
	}

	@Override
	public String getPlace() {
		
		return "any type of place";
	}

}
