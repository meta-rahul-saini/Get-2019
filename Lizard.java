
/**Lizard is subclass of Reptile hence it inherits all the properties of superclass 'reptile'and super super class 'Animal'
 * @author Rahul
 *
 */
public class Lizard extends Reptile {

	@Override
	public String getGenericName()
	{
		return "lizard";
	}
	
	@Override
	public String getSound() {
		return "low growl Sound";
	}

	@Override
	public String[] getFood() {
		String [] food = {"Insects", "Spiders", "snails"};

		return food;
	}

	@Override
	public String getPlace() {
		return "ground or trees";
	}

	@Override
	public String getFoodType() {
		
		return "Herbivore";
	}

}
