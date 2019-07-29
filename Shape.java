import java.util.Date;

/**
 * Shape interface specifies general methods that all of its subclasses
 * implements
 * 
 * @author rahul
 */
public interface Shape {

	static enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANLGE, POLYGON
	}

	/**
	 * this function calculates Area of shape
	 * 
	 * @return return area in float
	 */
	public float getArea();

	/**
	 * this function calculates Perimeter of shape
	 * 
	 * @return perimeter in float
	 */
	public float getPerimeter();

	/**
	 * function to check weather shape is enclosed or not
	 * 
	 * @return true if shape is enclosed o/w false is returned
	 */
	public boolean isPointEnclosed();

	/**
	 * @return type of shape e.g. RECTANGLE, SQUARE etc.
	 */
	public ShapeType getShapeType();

	/**
	 * @return timeStamp of shape
	 */
	public Date getDate();

	/**
	 * @return, distance of origin of shape from (0, 0) point of screen
	 */
	public float getOrigin();

	/**
	 * @return x co-ordinate of shape
	 */
	public float getOriginX();

	/**
	 * function to seting x co-ordinate of shape
	 * 
	 * @param originX
	 */
	public void setOriginX(float originX);

	/**
	 * @return y co-ordinate of shape
	 */
	public float getOriginY();

	/**
	 * function to set Y co-ordinate of shape
	 * 
	 * @param originY
	 */
	public void setOriginY(float originY);

}
