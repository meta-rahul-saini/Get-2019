import java.util.Date;

/**
 * class to represent circle shape
 * 
 * @author rahul
 *
 */
public class Circle implements Shape {

	private float radius = 0f;
	private Date date = null;
	private float originX = 0;
	private float originY = 0;

	private ShapeType shapeType = ShapeType.CIRCLE;

	/**
	 * constructor to initialize parameters of circle
	 * 
	 * @param radius
	 */
	public Circle(float radius) {
		date = new Date();
		this.radius = radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public float getArea() {

		float area = (float) (Math.PI * this.radius * this.radius);
		return area;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public float getPerimeter() {

		float perimeter = (float) (2 * Math.PI * this.radius);

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
