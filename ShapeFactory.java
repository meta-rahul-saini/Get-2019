import java.util.List;

/**
 * factory class to create object of shape type by using shapeType enum passed
 * by user
 * 
 * @author rahul
 *
 */
public class ShapeFactory {

	/**
	 * factory function to create shape of type determined by shapeTyp enum passed
	 * by user
	 * 
	 * @param shapeType,
	 *            enum which is used to determine type of shape
	 * @param parameterList,
	 *            parameters used to initialize shape parameters @return, reference
	 *            to created shape
	 */
	public static Shape createShape(Shape.ShapeType shapeType, List<Integer> parameterList) {
		Shape shape = null;

		float width = 0;
		float height = 0;
		float radius = 0;
		float sideA = 0, sideB = 0, sideC = 0;
		float lengthOfSide = 0, noOfSides = 0;

		switch (shapeType) {
		case SQUARE:
			if (parameterList.size() != 1)
				throw new AssertionError(" Please pass valid no. of arguments");
			else {
				width = parameterList.get(0);
				shape = new Square(width);
				break;
			}
		case RECTANGLE:
			if (parameterList.size() != 2)
				throw new AssertionError(" Please pass valid no. of arguments");
			else {
				width = parameterList.get(0);
				height = parameterList.get(1);
				shape = new Rectangle(width, height);
				break;
			}
		case CIRCLE:
			if (parameterList.size() != 1)
				throw new AssertionError(" Please pass valid no. of arguments");
			else {
				radius = parameterList.get(0);
				shape = new Circle(radius);
				break;
			}
		case TRIANLGE:
			if (parameterList.size() != 3)
				throw new AssertionError(" Please pass valid no. of arguments");
			else {
				sideA = parameterList.get(0);
				sideB = parameterList.get(1);
				sideC = parameterList.get(2);
				shape = new Triangle(sideA, sideB, sideC);
				break;
			}
		case POLYGON:
			if (parameterList.size() < 3)
				throw new AssertionError(" Please pass valid no. of arguments");
			else {
				lengthOfSide = parameterList.get(0);
				noOfSides = parameterList.get(1);
				shape = new RegularPolygon(lengthOfSide, noOfSides);

			}
		}
		return shape;
	}
}
