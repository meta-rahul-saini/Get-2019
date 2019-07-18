package Shape;

public class Rectangle  implements Shape {

	private double width =0;
	private double height =0;
	
	
	/**constructor which initialize rectangle width and height value
	 * @param width in double, width of rectangle
	 * @param height in double, height of rectangle
	 */
	public Rectangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	
	/* 
	 * Find area of Rectangle
	 * @return area in double
	 */
	@Override
	public double getArea() {
		
		double area = width*height;
		return area;
	}

}
