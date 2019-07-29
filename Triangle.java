import java.util.Date;

/**
 * class to represent Triangle shape, here we assume Right angle triangle where point A is on 90 degree, 
 * sideA is parallel to X and sideB is parallel to Y and other is sideC
 * @author rahul
 *
 */
public class Triangle implements Shape {

	private float sideA = 0f;
	private float sideB = 0f;
	private float sideC = 0f;
	private ShapeType shapeType = ShapeType.TRIANLGE;
	private Date date = null;
	private float originX = 0;
	private float originY = 0;

	/**
	 * constructor to initialize parameters of triangle
	 * 
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	public Triangle(float sideA, float sideB, float sideC) {
		this.date = new Date();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public float getArea() {

		float p = (sideA + sideB + sideC) / 2.0F;
		float area = (float) (Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)));
		return area;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public float getPerimeter() {

		float perimeter = (sideA + sideB + sideC);

		return perimeter;
	}

	/* (non-Javadoc)
	 * @see Shape#isPointEnclosed(float, float)
	 */
	@Override
	public boolean isPointEnclosed(float x, float y) {
		
		float xCoordOfA = this.originX;
		float yCoordOfA = this.originY;
		
		float xCoordOfB = this.originX;
		float yCoordOfB = this.originY + this.sideB;
		
		float xCoordOfC  = this.originX + this.sideA;
		float yCoordOfC  = this.originY;
		
		float distFromA = (float) Math.sqrt((Math.pow((x - xCoordOfA), 2)) + Math.pow((y - yCoordOfA), 2));
		System.out.println("distFromA: " + distFromA);
		float distFromB = (float) Math.sqrt((Math.pow((x - xCoordOfB), 2)) + Math.pow((y - yCoordOfB), 2));
		float distFromC = (float) Math.sqrt((Math.pow((x - xCoordOfC), 2)) + Math.pow((y - yCoordOfC), 2));
		
		float pAPB = (distFromA + distFromB + this.sideB) / 2.0F;
		float areaOfAPB = (float) (Math.sqrt(pAPB * (pAPB - distFromA) * (pAPB - distFromB) * (pAPB - this.sideB)));
		
		float pAPC = (this.sideA + distFromA + distFromC) / 2.0F;
		float areaOfAPC = (float) (Math.sqrt(pAPC * (pAPC - sideA) * (pAPC - distFromB) * (pAPC -distFromC)));
		
		float pBPC = (distFromB + this.sideC + distFromC) / 2.0F;
		float areaOfBPC = (float) (Math.sqrt(pBPC * (pBPC - distFromB) * (pBPC - sideC) * (pBPC -distFromC)));
		
		float areaOfABC = this.getArea();
		
		System.out.println("area of ABC: "+ Math.round(this.getArea()) + "area of computed Sides" + Math.round(areaOfAPB + areaOfAPC + areaOfBPC));
		
		// if point is enclosed by triangle then following area is equal o/w not equal 
		if(  Math.round(areaOfABC) == Math.round((areaOfAPB + areaOfAPC + areaOfBPC)))
			return true;
		else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getShapeType()
	 */
	@Override
	public ShapeType getShapeType() {
		return shapeType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getDate()
	 */
	public Date getDate() {
		return date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getOrigin()
	 */
	@Override
	public float getOrigin() {

		return (float) Math.sqrt((this.originX * this.originX + this.originY * this.originY));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getOriginX()
	 */
	@Override
	public float getOriginX() {
		return originX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#setOriginX(float)
	 */
	@Override
	public void setOriginX(float originX) {
		this.originX = originX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getOriginY()
	 */
	@Override
	public float getOriginY() {
		return originY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#setOriginY(float)
	 */
	@Override
	public void setOriginY(float originY) {
		this.originY = originY;
	}
}
