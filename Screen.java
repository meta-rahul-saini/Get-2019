import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * screen class, that supports following methods Add a shape object to the
 * screen at a specified location with default orientation. Delete a shape
 * object from the screen Delete all shape objects of a specific type Return the
 * shape objects on the screen sorted in desired ascending order based on area,
 * perimeter, timestamp or origin distance (distance of the origin of the shape
 * from the origin of the screen). Consider various design options for this
 * method. Return the list of shape objects enclosing a specified point.
 * 
 * @author rahul
 */
public class Screen {

	private Map<Point, Shape> shapeMap = new HashMap<>();
	private float X_MAX = 100;
	private float Y_MAX = 100;

	/**
	 * function to add shape to screen at point specified by Point class
	 * 
	 * @param shapeType,
	 *            specifies type of shape
	 * @param point,
	 *            specifies origin of shape
	 * @param parameters,
	 *            specifies parameters of shape like width, height, etc.
	 */
	public boolean addShape(Shape.ShapeType shapeType, Point point, List<Integer> parameters) {
		try {
			Shape shape = ShapeFactory.createShape(shapeType, parameters);
			float xCordinate = point.getX();
			float yCordinate = point.getY();
			// if points is outside the range of screen return false
			if (xCordinate > X_MAX || yCordinate > Y_MAX || xCordinate < 0 || yCordinate < 0)
				return false;

			shape.setOriginX(point.getX());
			shape.setOriginY(point.getY());
			shapeMap.put(point, shape);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * function to delete a specific shape from screen
	 * 
	 * @param shape,
	 *            shape object to be removed @return, true if object removed
	 *            successfully o/w return false
	 */
	public boolean deleteShape(Point point) {
		if (shapeMap.containsKey(point)) {
			shapeMap.remove(point);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * function to delete all the shapes of specified type
	 * 
	 * @param shapeType,
	 *            type of shapes
	 * @return true if shape is successfully removed o/w false is returned
	 */
	public boolean deleteAll(Shape.ShapeType shapeType) {
		boolean flag = false;
		for (Point point : shapeMap.keySet()) {
			if (shapeMap.get(point).getShapeType() == shapeType) {
				shapeMap.remove(point);
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * function to sorts shapes by their area and return list of shapes
	 * 
	 * @return list of shapes is returned
	 */
	public List<Shape> getShapesSortedByArea() {

		// getting shapeList from hashMAP
		List<Map.Entry<Point, Shape>> shapeList = new LinkedList<Map.Entry<Point, Shape>>(shapeMap.entrySet());

		// sorting the list by using the comparator method
		Collections.sort(shapeList, new Comparator<Map.Entry<Point, Shape>>() {
			public int compare(Map.Entry<Point, Shape> entry1, Map.Entry<Point, Shape> entry2) {
				return ((Float) entry1.getValue().getArea()).compareTo((Float) entry2.getValue().getArea());
			}
		});

		// convert from list of map entries to list of shapes sorted by area
		List<Shape> shapeList1 = new ArrayList<>();
		for (Map.Entry<Point, Shape> entry : shapeList) {
			shapeList1.add(entry.getValue());
		}

		return shapeList1;
	}

	/**
	 * function to sorts shapes by their perimeter area and return list of shapes
	 * 
	 * @return list of shapes is returned
	 */
	public List<Shape> getShapesSortedByPerimeter() {
		// getting shapeList from hashMAP
		List<Map.Entry<Point, Shape>> shapeList = new LinkedList<Map.Entry<Point, Shape>>(shapeMap.entrySet());

		// sorting the list by using the comparator method
		Collections.sort(shapeList, new Comparator<Map.Entry<Point, Shape>>() {
			public int compare(Map.Entry<Point, Shape> entry1, Map.Entry<Point, Shape> entry2) {
				return ((Float) entry1.getValue().getPerimeter()).compareTo((Float) entry2.getValue().getPerimeter());
			}
		});

		// convert from list of map entries to list of shapes sorted by perimeter
		List<Shape> shapeList1 = new ArrayList<>();
		for (Map.Entry<Point, Shape> entry : shapeList) {
			shapeList1.add(entry.getValue());
		}

		return shapeList1;
	}

	/**
	 * function to sorts shapes by their timeStamp and return list of shapes
	 * 
	 * @return list of shapes is returned
	 */
	public List<Shape> getShapesSortedByTimeStamp() {
		// converting into list from hashMap
		List<Map.Entry<Point, Shape>> shapeList = new LinkedList<Map.Entry<Point, Shape>>(shapeMap.entrySet());

		// sorting the list by using the comparator method
		Collections.sort(shapeList, new Comparator<Map.Entry<Point, Shape>>() {
			public int compare(Map.Entry<Point, Shape> entry1, Map.Entry<Point, Shape> entry2) {
				return entry1.getValue().getDate().compareTo(entry2.getValue().getDate());
			}
		});

		List<Shape> shapeList1 = new ArrayList<>();

		// convert from list of map entries to list of shapes sorted by timeStamp
		for (Map.Entry<Point, Shape> entry : shapeList) {
			shapeList1.add(entry.getValue());
		}

		return shapeList1;
	}

	/**
	 * function to sorts shapes by their distance from their origin to screen origin
	 * and return list of shapes
	 * 
	 * @return list of shapes is returned
	 */
	public List<Shape> getShapesSortedByOrigin() {
		// converting into list from hashMap

		List<Map.Entry<Point, Shape>> shapeList = new LinkedList<Map.Entry<Point, Shape>>(shapeMap.entrySet());

		// sorting the list by using the comparator method
		Collections.sort(shapeList, new Comparator<Map.Entry<Point, Shape>>() {
			public int compare(Map.Entry<Point, Shape> entry1, Map.Entry<Point, Shape> entry2) {
				Float distOrigin1 = null;
				Float distOrigin2 = null;
				float x1 = 0;
				float x2 = 0;
				float y1 = 0;
				float y2 = 0;

				x1 = entry1.getKey().getX();
				y1 = entry1.getKey().getY();

				x2 = entry2.getKey().getX();
				y2 = entry2.getKey().getY();

				distOrigin1 = (float) Math.sqrt((x1 * x1 + y1 * y1));
				distOrigin2 = (float) Math.sqrt((x2 * x2 + y2 * y2));

				return (distOrigin1).compareTo(distOrigin2);
			}
		});

		// convert from list of map entries to list of shapes sorted by distance from
		// origin
		List<Shape> shapeList1 = new ArrayList<>();
		for (Map.Entry<Point, Shape> entry : shapeList) {
			shapeList1.add(entry.getValue());
		}

		return shapeList1;
	}

}
