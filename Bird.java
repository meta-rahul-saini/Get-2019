/** bird is subclass of base class 'Animal', hence it inherits all the properties of base class 'Animal'
 * @author Rahul
 *
 */
public abstract class Bird extends Animal {
	
	@Override
	public String getAnimalType()
	{
		return "bird";
	}
	
	@Override
	public boolean canFly() {
		return true;
	}

	@Override
	public int getNoOfLegs() {
		return 2;
	}

	@Override
	public boolean isVertebrates() {
		return true;
	}

	@Override
	public boolean isWarmBlooded() {
		return true;
	}

	@Override
	public boolean isColdBlooded() {
		return false;
	}

	@Override
	public boolean hasFeathers() {
		return true;
	}
	
	@Override
	public boolean layEggs()
	{
		return true;
	}
}
