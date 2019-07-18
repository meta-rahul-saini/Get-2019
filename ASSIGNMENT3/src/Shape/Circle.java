package Shape;

public class Circle implements Shape {


	private double circle =0;
	
	/**
	 * constructor which initialize the radius of circle
	 * @param circle in double
	 * @param circle in double
	 */
	public Circle(double circle)
	{
		this.circle = circle;
	}
	
	
	/* 
	 * Find area of circle
	 * @return double, area of circle
	 */
	@Override
	public double getArea() {
		
		double area = ((double)22/(double)7)*circle*circle;
		return area;
	}

}

