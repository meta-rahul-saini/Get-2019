
/** Mammal is subclass of base class 'Animal', hence it inherits all the properties of base class 'Animal'
 * @author Rahul
 *
 */
public abstract class Mammal extends Animal {
	
	@Override
	public String getAnimalType()
	{
		return "mammal";
	}
	
	@Override
	public boolean canFly() {
		return false;
	}

	@Override
	public int getNoOfLegs() {
		return 4;
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
		return false;
	}
	
	@Override
	public boolean layEggs()
	{
		return false;
	}
}
