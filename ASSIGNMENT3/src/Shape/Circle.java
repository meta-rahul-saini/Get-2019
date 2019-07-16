package Shape;

public class Circle implements Shape {


	private double width =0;
	
	/**
	 * @param width in double
	 * @param height in double
	 */
	public Circle(double width)
	{
		this.width = width;
	}
	
	
	/* 
	 * Find area of Triangle
	 * @return area in double
	 */
	@Override
	public double getArea() {
		
		double area = ((double)22/(double)7)*width*width;
		return area;
	}

}

