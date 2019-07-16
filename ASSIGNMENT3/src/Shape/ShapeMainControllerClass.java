package Shape;

import java.util.Scanner;

public class ShapeMainControllerClass {

	// this is the utility method we use to display options to user

	public static void displayOptions() {
		System.out.println("1. Area of Triangle");
		System.out.println("2. Area of Rectangle");
		System.out.println("3. Area of Circle");
		System.out.println("4. Area of Square");
		System.out.println("5. Exit");

	}

	public static void main(String[] args) {

		boolean flag = true;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		double width = 0;
		double height = 0;
		double area = 0;
		double radius = 0;

		while (flag) {
			displayOptions();
			System.out.println("Enter your choice:");
			try {
				choice = sc.nextInt();
				if (choice < 0 & choice > 5) {
					System.out.println("Please input a valid choice");
				}
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Please input a valid choice");

			}

			switch (choice) {

			// area of triangle

			case 1:

				try {

					// taking the input from user

					System.out.println("Enter width of Triangle");
					width = sc.nextInt();
					System.out.println("Enter height of Triangle");
					height = sc.nextInt();

				} catch (Exception e) {

					// if user enters a invalid string type value then it throws
					// number format
					// exception
					System.out.println(e);

					System.out.println("Please enter valid value");
					break;
				}

				// create triangle instance

				Triangle triangle = new Triangle(width, height);
				area = triangle.getArea();
				System.out.printf("\nArea of Triangle is: %.2f", area);
				break;

			case 2:

				try {

					// taking input from user

					System.out.println("Enter width of Rectangle");
					width = sc.nextInt();
					System.out.println("Enter height of Rectangle");
					height = sc.nextInt();

				} catch (Exception e) {

					// if user enters a invalid string type value then it throws
					// number format
					// exception
					System.out.println(e);
					System.out.println("Please enter valid value");
					break;

				}

				Rectangle rectangle = new Rectangle(width, height);
				area = rectangle.getArea();
				System.out.printf("\nArea of Rectangle is: %.2f", area);
				break;

			case 3:

				try {

					// taking input from user

					System.out.println("Enter radius of Circle");
					radius = sc.nextInt();

					if (radius < -0) {
						throw new Exception("Please Enter a positive value");
					}
				} catch (Exception e) {
					// if user enters a invalid string type value then it throws
					// number format
					// exception
					System.out.println(e);
					System.out.printf("Please enter valid value");
					break;

				}

				Circle circle = new Circle(radius);
				area = circle.getArea();
				System.out.printf("\nArea of Circle is: %.2f", area);
				break;

			case 4:

				try {

					// taking input from user

					System.out.println("\nEnter width of Square");
					width = sc.nextInt();

				} catch (Exception e) {

					// if user enters a invalid string type value then it throws
					// number format
					// exception
					System.out.println(e);
					System.out.println("Please enter valid value");
					break;

				}

				Square square = new Square(width);
				area = square.getArea();
				System.out.printf("\nArea of Square is: %.2f", area);
				break;

			case 5:
				System.out.println("Exit");
				break;
			}

		}

		sc.close();

	}

}
