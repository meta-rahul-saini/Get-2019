
/** pigeon is subclass of bird hence it inherits all the properties of superclass 'bird' and super super class 'Animal'
 * @author Rahul
 *
 */
public class Pigeon extends Bird {

	@Override
	public String getGenericName()
	{
		return "pigeon";
	}
	
	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return "oh-oo-oor";
	}

	@Override
	public String[] getFood() {
		
		String [] food = {"Popcorn", "rice", "peas", "barley", "kasha"};
		return food;
	}

	@Override
	public String getFoodType() {
		return "Herbivore";
	}

	@Override
	public String getPlace() {
		return "nest";
	}

}
