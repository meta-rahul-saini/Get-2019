import java.util.Date;

/**
 * class to represent polygon class
 * 
 * @author rahul
 *
 */
public class RegularPolygon implements Shape {

	private float lengthOfSide = 0f;
	private float noOfSides = 0f;
	private ShapeType shapeType = ShapeType.POLYGON;
	private Date date = null;
	private float originX = 0;
	private float originY = 0;

	/**
	 * constructor to initialize sides of polygon and date
	 * 
	 * @param lengthOfSide
	 * @param noOfSides
	 */
	public RegularPolygon(float lengthOfSide, float noOfSides) {
		this.date = new Date();
		this.lengthOfSide = lengthOfSide;
		this.noOfSides = noOfSides;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getArea()
	 */
	@Override
	public float getArea() {

		float area = (float) (((lengthOfSide * lengthOfSide) * noOfSides) / 4.0f * Math.tan(180.0f / noOfSides));
		return area;
	}


	@Override
	public boolean isPointEnclosed(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getPerimeter()
	 */
	@Override
	public float getPerimeter() {

		float perimeter = (lengthOfSide * noOfSides);

		return perimeter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getShapeType()
	 */
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
	public float getOriginX() {
		return originX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#setOriginX(float)
	 */
	public void setOriginX(float originX) {
		this.originX = originX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#getOriginY()
	 */
	public float getOriginY() {
		return originY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Shape#setOriginY(float)
	 */
	public void setOriginY(float originY) {
		this.originY = originY;
	}

}
