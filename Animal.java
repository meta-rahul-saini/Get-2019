
/**
 * this is our base animal class
 * @author Rahul
 *
 */
/**
 * @author Rahul
 *
 */
public abstract class Animal {

	private static int id;
	
	private int animalID = 0;

	private String name = "";

	private float age = 0;

	private float weight = 0;

	private String gender = "";
	
	private String genericName;

	private String animalType = "";
	
	/**
	 * constructor we used to assign unique id to each new animal automatically
	 */
	Animal() {
		this.animalID = id++;
	}

	
	/**
	 * @return returns sound of animal e.g. tiger sound is 'roar'
	 */
	public abstract String getSound();

	/**
	 * @return  returns food lists of animal 
	 */
	public abstract String[] getFood();
	
	/**we use it to determine weather animal can fly or not
	 * @return true, if animal can fly, o/w return false
	 */
	public abstract boolean canFly();

	
	/**
	 * @return returns place where animal live or found
	 */
	public abstract String getPlace();
	
	/**
	 * @return food type like Carnivore, Herbivore etc.
	 */
	public abstract String getFoodType();


	/**
	 * @return no. of legs of animal, if animal don't have legs it returns 0
	 */
	public abstract int getNoOfLegs();
	
	/**
	 * @return if animal have backbone it returns true, o/w false
	 */
	public abstract boolean isVertebrates();

	/**
	 * @return , if animal is warmBlooded it return true o/w false
	 */
	public abstract boolean isWarmBlooded();

	/**
	 * @return  if animal is coldBlooded it return true o/w false
	 */
	public abstract boolean isColdBlooded();

	/**
	 * @return, it return true if animal has feathers like birds, o/w return false
	 */
	public abstract boolean hasFeathers();
	
	
	/**
	 * @return, return true if animal layEggs o/w return false
	 */
	public abstract boolean layEggs();

	// getters and setters
	
	/** this function is used to get generic name of animal like generic name of tiger is "tiger"
	 * @return, return generic name of animal
	 */
	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	
	public String getAnimalType(){
		return this.animalType;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAge() {
		return this.age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public float getWeight() {
		return this.age;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAnimalID(){
		return this.animalID;
	}


}
