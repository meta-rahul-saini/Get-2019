import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ScreenNegativeTest {

	/**
	 * this function has negative test cases for addShape method in screen class
	 */
	@Test
	public void addShape() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters = new ArrayList<>();
		parameters.add(4);

		// test1: passing invalid no. of arguments
		assertEquals(false, screen.addShape(Shape.ShapeType.RECTANGLE, point1, parameters));

		Point point2 = new Point();
		point2.setX(2);
		point2.setY(-2);

		// test2: passing invalid co-ordinates
		assertEquals(false, screen.addShape(Shape.ShapeType.RECTANGLE, point2, parameters));
	}

	/**
	 * this function has negative test cases for deleteShape method in screen class
	 */
	@Test
	public void deleteShape() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(-1);

		List<Integer> parameters = new ArrayList<>();
		parameters.add(4);
		parameters.add(3);

		// test1: passing invalid no. of arguments
		assertEquals(false, screen.addShape(Shape.ShapeType.RECTANGLE, point1, parameters));

		// test2: passing invalid co-ordinates
		assertEquals(false, screen.deleteShape(point1));
	}

}
