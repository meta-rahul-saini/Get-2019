
/** tiger is subclass of Mammal hence it inherits all the properties of superclass 'Mammal' and super super class 'Animal'
 * @author Rahul
 *
 */
public class Tiger extends Mammal {

	@Override
	public String getGenericName()
	{
		return "tiger";
	}
	
	@Override
	public String getSound() {
		return "Roar";
	}

	@Override
	public String[] getFood() {
		
		String [] food = {"Boars", "Wild Pigs", "Bears", "Buffalo", "Birds", "Lizards", "Crabs", "Fish", "Berries", "Plants"};

		return food;
	}

	@Override
	public String getPlace() {
		return "Rain Forests";
	}

	@Override
	public String getFoodType() {
		return "Carnivore";
	}

	
}
