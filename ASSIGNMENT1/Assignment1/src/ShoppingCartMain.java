import java.util.Scanner;

public class ShoppingCartMain {

	// we use this function to input proper itemID
	public static int inputItemID(AvailableItem availableItem) {
		boolean error = true;
		int itemID = 0;
		Scanner sc;
		do {
			System.out.println("Enter item ID");
			try {
				sc = new Scanner(System.in);
				itemID = sc.nextInt();
				if (availableItem.availableItemList.get(itemID) == null) {
					System.out.println("Please Enter proper itemID");
				}

				else {
					error = false;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (error == true);
		return itemID;
	}

	// we use this function to input itemQuantityToAddToCart

	public static int inputQuantityOfItemToAddToCart(
			AvailableItem availableItme) {
		boolean error = true;
		int QuantityOfItemToAddToCart = 0;
		Scanner sc;
		do {
			System.out.println("Enter Item Quantity to add to cart");
			try {
				sc = new Scanner(System.in);
				QuantityOfItemToAddToCart = sc.nextInt();
				if (QuantityOfItemToAddToCart< 0)
				{
					System.out.println("Please Enter a positive Quantity of item");
				}
				else {
					error = false;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (error == true);

		return QuantityOfItemToAddToCart;
	}

	public static void main(String[] args) {

		// create a cart

		Cart cart = new Cart();
		Scanner sc;
		int itemQuantityToAddToCart = 0;
		int itemID=0;
		
		// create AvailableItem instance 
		AvailableItem availableItem = new AvailableItem();
		
		// here we add the items to the availableItemList

		availableItem.addItemToItemList(201, "Laptop", 70000, 1,
				"Lenovo p400 Laptop i7");

		availableItem.addItemToItemList(201, "Laptop", 70000, 1,
				"Lenovo p400 Laptop i7");

		availableItem.addItemToItemList(202, "Watch", 2000, 1000,
				"Sonata Primium Watch");

		availableItem.addItemToItemList(203, "Shoe", 3000, 1000, "Puma shoe");

		availableItem.addItemToItemList(204, "Mobile", 7000, 1000,
				"Samsung J2 mobile");

		availableItem.addItemToItemList(204, "Bag", 1000, 1000, "Sky Bags");

		boolean flag = true;
		boolean error = true;
		int choice = 0;
		while (flag) {
			// shows available items in itemList

			availableItem.showAvailableItems();

			System.out.println("\n\n1. add items to cart");
			System.out.println("2. update items in cart");
			System.out.println("3. show items in cart");
			System.out.println("4. generate Bill");
			System.out.println("5. Exit");

			// get choice from user
			error=true;
			do {
				System.out.println("Enter your choice:");
				try {
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					if (choice < 0 | choice > 5) {
						System.out.println("Please input a valid choice");
					} else {
						error = false;
					}
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Please input a valid choice");

				}
			} while (error == true);

			switch (choice) {
			case 1:
				// here we add items from itemList to our cartList
				itemID = inputItemID(availableItem);
				itemQuantityToAddToCart = inputQuantityOfItemToAddToCart(availableItem);
				cart.addItemToCart(availableItem.availableItemList, itemID,
						itemQuantityToAddToCart);
				break;
			case 2:
				itemID = inputItemID(availableItem);
				itemQuantityToAddToCart = inputQuantityOfItemToAddToCart(availableItem);
				// it updates our cart item
				cart.updateItem(availableItem.availableItemList, itemID,
						itemQuantityToAddToCart);
				break;
			case 3:
				System.out
						.println("\n\n===================================================="
								+ "\n\tyour Cart: \n");
				// it shows our cart items and bills
				cart.showCart();
				break;
			case 4:
				System.out
						.println("\n\n===================================================="
								+ "\n\ttotal Bill: \n");
				// it generates total bill
				cart.generateBill();
				break;
			case 5: 
				flag = false;
				break;
	
			}
		}
	}
}
