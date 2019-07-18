package Shape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeMainControllerClass {

	public static void main(String[] args) {

		boolean flag1 = true;
		boolean flag2 = true;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		double width = 0;
		double height = 0;
		double area = 0;
		double radius = 0;
		boolean error = true;

		while (flag1) {

			// show options
			System.out.println("1. Area of Triangle");
			System.out.println("2. Area of Rectangle");
			System.out.println("3. Area of Circle");
			System.out.println("4. Area of Square");
			System.out.println("5. Exit");

			// get choice
			error = true;
			do {
				try {
					System.out.println("Enter your choice:\n");
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					if (choice < 1 | choice > 5) {
						System.out
								.println("Please Enter a valid positive integer");
						error = true;
					} else {
						error = false;
						if (choice == 5) {
							System.out.println("Exiting System");
							System.exit(0);
						}
					}
				} catch (InputMismatchException e) {
					System.out
							.println("Input Mismatch Exception occured. Please Enter a valid Positive Integer");
				}
			} while (error == true);

			switch (choice) {
			// area of triangle
			case 1:
				flag2 = true;
				do {
					sc = new Scanner(System.in);
					try {
						System.out.println("Enter width of Triangle");
						width = sc.nextDouble();
						System.out.println("Enter height of Triangle");
						height = sc.nextDouble();
						flag2 = false;
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("Please enter valid value");
					}
				} while (flag2 == true);

				// create triangle instance

				Triangle triangle = new Triangle(width, height);
				area = triangle.getArea();
				System.out.printf("\nArea of Triangle is: %.2f\n", area);
				break;

			case 2:
				flag2 = true;
				do {
					sc = new Scanner(System.in);
					try {
						System.out.println("Enter width of Rectangle");
						width = sc.nextDouble();
						System.out.println("Enter height of Rectangle");
						height = sc.nextDouble();
						flag2 = false;
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("Please enter valid value");
					}
				} while (flag2 == true);

				Rectangle rectangle = new Rectangle(width, height);
				area = rectangle.getArea();
				System.out.printf("\nArea of Rectangle is: %.2f\n", area);
				break;

			case 3:
				flag2 = true;
				do {
					sc = new Scanner(System.in);
					try {
						System.out.println("Enter radius of Circle");
						radius = sc.nextDouble();
						flag2 = false;
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("Please enter valid value");
					}
				} while (flag2 == true);

				Circle circle = new Circle(radius);
				area = circle.getArea();
				System.out.printf("\nArea of Circle is: %.2f\n", area);
				break;

			case 4:
				flag2 = true;
				do {
					sc = new Scanner(System.in);
					try {
						System.out.println("Enter width of Square");
						radius = sc.nextDouble();
						flag2 = false;
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("Please enter valid value");
					}
				} while (flag2 == true);

				Square square = new Square(width);
				area = square.getArea();
				System.out.printf("\nArea of Square is: %.2f\n", area);
				break;

			case 5:
				System.out.println("Exit");
				break;
			}

		}
		sc.close();
	}

}
