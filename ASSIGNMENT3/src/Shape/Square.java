package Shape;


public class Square implements Shape {

	private double width =0;
	
	/**constructor to initialize Square parameters
	 * @param width in double
	 * @param height in double
	 */
	public Square(double width)
	{
		this.width = width;
	}
	
	
	/* 
	 * Find area of Square
	 * @return area in double
	 */
	@Override
	public double getArea() {
		
		double area = width*width;
		return area;
	}

}
