
/** reptile is subclass of base class 'Animal', hence it inherits all the properties of base class 'Animal'
 * @author Rahul
 *
 */
public abstract class Reptile extends Animal {


	@Override
	public String getAnimalType()
	{
		return "reptile";
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
		return false;
	}

	@Override
	public boolean isColdBlooded() {
		return true;
	}

	@Override
	public boolean hasFeathers() {
		return false;
	}
	
	@Override
	public boolean layEggs()
	{
		return true;
	}
}
