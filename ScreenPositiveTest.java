import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * ScreenPositiveTest class has test cases for functions in Screen Class
 * 
 * @author rahul
 *
 */
public class ScreenPositiveTest {

	interface IsSorted {
		boolean check(List<Shape> shapeList);
	}

	/**
	 * this function has Positve test cases for addShape method in Screen class
	 */
	@Test
	public void addShapeTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters1 = new ArrayList<>();
		parameters1.add(3);

		// test1: when we pass all positive co-ordinates
		assertEquals(true, screen.addShape(Shape.ShapeType.CIRCLE, point1, parameters1));

		// creating new co-ordinate
		Point point2 = new Point();
		point2.setX(0);
		point2.setY(0);

		List<Integer> parameters2 = new ArrayList<>();
		parameters2.add(4);
		parameters2.add(5);

		// test2: when we pass some negative (0, 0)
		assertEquals(true, screen.addShape(Shape.ShapeType.RECTANGLE, point2, parameters2));

	}

	/**
	 * this function has Positve test cases for deleteShape method in Screen class
	 */
	@Test
	public void deleteShapeTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters = new ArrayList<>();
		parameters.add(4);
		parameters.add(3);

		// test1: passing valid no. of arguments
		assertEquals(true, screen.addShape(Shape.ShapeType.RECTANGLE, point1, parameters));

		assertEquals(true, screen.deleteShape(point1));

		// since we don't have corresponding shape hence false is returned
		assertEquals(false, screen.deleteShape(point1));

	}

	/**
	 * this function has Positve test cases for deleteAll method in Screen class
	 */
	@Test
	public void deleteAllTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters = new ArrayList<>();
		parameters.add(4);
		parameters.add(3);

		// test1: passing valid no. of arguments
		assertEquals(true, screen.addShape(Shape.ShapeType.RECTANGLE, point1, parameters));

		assertEquals(true, screen.deleteAll(Shape.ShapeType.RECTANGLE));

		// sicne we don't have Rectangle shapes more hence false is returned
		assertEquals(false, screen.deleteAll(Shape.ShapeType.RECTANGLE));

	}

	/**
	 * this function tests getShapesSortedByArea function of Screen class
	 */
	@Test
	public void getShapesSortedByAreaTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters1 = new ArrayList<>();
		parameters1.add(4);

		Point point2 = new Point();
		point2.setX(13);
		point2.setY(15);

		List<Integer> parameters2 = new ArrayList<>();
		parameters2.add(4);

		Point point3 = new Point();
		point3.setX(20);
		point3.setY(20);

		List<Integer> parameters3 = new ArrayList<>();
		parameters3.add(4);
		parameters3.add(5);
		parameters3.add(6);
		parameters3.add(7);

		Point point4 = new Point();
		point4.setX(25);
		point4.setY(25);

		List<Integer> parameters4 = new ArrayList<>();
		parameters4.add(4);
		parameters4.add(5);

		Point point5 = new Point();
		point5.setX(25);
		point4.setY(25);

		List<Integer> parameters5 = new ArrayList<>();
		parameters5.add(6);
		parameters5.add(7);
		parameters5.add(8);

		screen.addShape(Shape.ShapeType.CIRCLE, point1, parameters1);

		screen.addShape(Shape.ShapeType.SQUARE, point2, parameters2);

		screen.addShape(Shape.ShapeType.POLYGON, point3, parameters3);

		screen.addShape(Shape.ShapeType.RECTANGLE, point4, parameters4);

		screen.addShape(Shape.ShapeType.TRIANLGE, point5, parameters5);

		List<Shape> computedShapesList = screen.getShapesSortedByArea();

		// using lambda expression
		IsSorted isSorted = (List<Shape> shapeList) -> {
			float prevArea = 0;
			float nextArea = 0;

			for (Shape shape : shapeList) {
				nextArea = shape.getArea();
				if (nextArea < prevArea)
					return false;
				prevArea = nextArea;
			}
			return true;
		};

		assertEquals(true, isSorted.check(computedShapesList));
	}

	/**
	 * this function tests getShapesSortedByPerimeter function of Screen class
	 */
	@Test
	public void getShapesSortedByPerimeterTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters1 = new ArrayList<>();
		parameters1.add(4);

		Point point2 = new Point();
		point2.setX(13);
		point2.setY(15);

		List<Integer> parameters2 = new ArrayList<>();
		parameters2.add(4);

		Point point3 = new Point();
		point3.setX(20);
		point3.setY(20);

		List<Integer> parameters3 = new ArrayList<>();
		parameters3.add(4);
		parameters3.add(5);
		parameters3.add(6);
		parameters3.add(7);

		Point point4 = new Point();
		point4.setX(25);
		point4.setY(25);

		List<Integer> parameters4 = new ArrayList<>();
		parameters4.add(4);
		parameters4.add(5);

		Point point5 = new Point();
		point5.setX(25);
		point4.setY(25);

		List<Integer> parameters5 = new ArrayList<>();
		parameters5.add(6);
		parameters5.add(7);
		parameters5.add(8);

		screen.addShape(Shape.ShapeType.CIRCLE, point1, parameters1);

		screen.addShape(Shape.ShapeType.SQUARE, point2, parameters2);

		screen.addShape(Shape.ShapeType.POLYGON, point3, parameters3);

		screen.addShape(Shape.ShapeType.RECTANGLE, point4, parameters4);

		screen.addShape(Shape.ShapeType.TRIANLGE, point5, parameters5);

		List<Shape> computedShapesList = screen.getShapesSortedByPerimeter();

		IsSorted isSorted = (List<Shape> shapeList) -> {
			float prevPerimeter = 0;
			float nextPerimeter = 0;

			for (Shape shape : shapeList) {
				nextPerimeter = shape.getPerimeter();
				if (nextPerimeter < prevPerimeter) {
					return false;
				} else {
					prevPerimeter = nextPerimeter;
				}
			}
			return true;
		};
		assertEquals(true, isSorted.check(computedShapesList));
	}

	/**
	 * this function tests getShapesSortedByOrigin function of Screen class
	 */
	@Test
	public void getShapesSortedByOriginTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters1 = new ArrayList<>();
		parameters1.add(4);

		Point point2 = new Point();
		point2.setX(13);
		point2.setY(15);

		List<Integer> parameters2 = new ArrayList<>();
		parameters2.add(4);

		Point point3 = new Point();
		point3.setX(20);
		point3.setY(20);

		List<Integer> parameters3 = new ArrayList<>();
		parameters3.add(4);
		parameters3.add(5);
		parameters3.add(6);
		parameters3.add(7);

		Point point4 = new Point();
		point4.setX(25);
		point4.setY(25);

		List<Integer> parameters4 = new ArrayList<>();
		parameters4.add(4);
		parameters4.add(5);

		Point point5 = new Point();
		point5.setX(25);
		point4.setY(25);

		List<Integer> parameters5 = new ArrayList<>();
		parameters5.add(6);
		parameters5.add(7);
		parameters5.add(8);

		screen.addShape(Shape.ShapeType.CIRCLE, point1, parameters1);

		screen.addShape(Shape.ShapeType.SQUARE, point2, parameters2);

		screen.addShape(Shape.ShapeType.POLYGON, point3, parameters3);

		screen.addShape(Shape.ShapeType.RECTANGLE, point4, parameters4);

		screen.addShape(Shape.ShapeType.TRIANLGE, point5, parameters5);

		List<Shape> computedShapesList = screen.getShapesSortedByOrigin();

		IsSorted isSorted = (List<Shape> shapeList) -> {
			float prevDistfromOrigin = 0;
			float nextDistfromOrigin = 0;

			for (Shape shape : shapeList) {

				nextDistfromOrigin = shape.getOrigin();

				if (nextDistfromOrigin < prevDistfromOrigin) {
					return false;
				} else {
					prevDistfromOrigin = nextDistfromOrigin;
				}
			}
			return true;
		};
		assertEquals(true, isSorted.check(computedShapesList));
	}

	/**
	 * this function tests getShapesSortedByTimeStamp function of Screen class
	 */
	@Test
	public void getShapesSortedByTimeStampTest() {
		Screen screen = new Screen();

		Point point1 = new Point();
		point1.setX(1);
		point1.setY(1);

		List<Integer> parameters1 = new ArrayList<>();
		parameters1.add(4);

		Point point2 = new Point();
		point2.setX(13);
		point2.setY(15);

		List<Integer> parameters2 = new ArrayList<>();
		parameters2.add(4);

		Point point3 = new Point();
		point3.setX(20);
		point3.setY(20);

		List<Integer> parameters3 = new ArrayList<>();
		parameters3.add(4);
		parameters3.add(5);
		parameters3.add(6);
		parameters3.add(7);

		Point point4 = new Point();
		point4.setX(25);
		point4.setY(25);

		List<Integer> parameters4 = new ArrayList<>();
		parameters4.add(4);
		parameters4.add(5);

		Point point5 = new Point();
		point5.setX(25);
		point4.setY(25);

		List<Integer> parameters5 = new ArrayList<>();
		parameters5.add(6);
		parameters5.add(7);
		parameters5.add(8);

		screen.addShape(Shape.ShapeType.CIRCLE, point1, parameters1);

		screen.addShape(Shape.ShapeType.SQUARE, point2, parameters2);

		screen.addShape(Shape.ShapeType.POLYGON, point3, parameters3);

		screen.addShape(Shape.ShapeType.RECTANGLE, point4, parameters4);

		screen.addShape(Shape.ShapeType.TRIANLGE, point5, parameters5);

		List<Shape> computedShapesList = screen.getShapesSortedByTimeStamp();

		IsSorted isSorted = (List<Shape> shapeList) -> {
			float prevTimeStamp = 0;
			float nextTimeStamp = 0;

			for (Shape shape : shapeList) {

				nextTimeStamp = shape.getDate().getSeconds();

				if (nextTimeStamp < prevTimeStamp) {
					return false;
				} else {
					prevTimeStamp = nextTimeStamp;
				}
			}
			return true;
		};
		assertEquals(true, isSorted.check(computedShapesList));
	}
}
