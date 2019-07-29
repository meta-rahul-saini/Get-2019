import java.util.Date;

/**
 * class to represent Squares shape
 * 
 * @author rahul
 *
 */
public class Square implements Shape {

	private float width = 0f;
	private Date date = null;
	private ShapeType shapeType = ShapeType.SQUARE;
	private float originX = 0;
	private float originY = 0;

	/**
	 * constructor to initialize width of square
	 * 
	 * @param width
	 */
	public Square(float width) {
		this.date = new Date();
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public float getArea() {

		float area = width * width;

		return area;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public float getPerimeter() {

		float perimeter = 4 * width;

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
