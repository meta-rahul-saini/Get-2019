package Shape;


public class Triangle implements Shape {

	private double width =0;
	private double height =0;
	
	
	/**
	 * @param width in double
	 * @param height in double
	 */
	public Triangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	
	/* 
	 * Find area of Triangle
	 * @return area in double
	 */
	@Override
	public double getArea() {
		
		double area = ((double)1/(double)2)*width*height;
		return area;
	}

}
