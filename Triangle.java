import java.util.Date;

/**
 * class to represent Triangle shape
 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed() {
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
