import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCartMain {

	// this is itemsList where all the available items are stored.

	static HashMap<Integer, Item> availableItemList = new HashMap<>();

	// we use this function to add item to our availableItemList

	public static void addItemToItemList(int itemID, String itemName,
			int itemPrice, int itemAvailableQuantity, String itemDetail) {

		// check if item is already in our availableItemList if it exists then
		// simply increase the itemAvailableQuantity

		if (availableItemList.containsKey(itemID)) {
			Item item = availableItemList.get(itemID);
			item.setItemAvailableQuantity(item.getItemAvailableQuantity()
					+ itemAvailableQuantity);
		}
		// if item already doesn't exists in our availableItemList then create a
		// new Item and then set the itemAvailableQuantity
		else {
			Item item = new Item();
			item.setItemID(itemID);
			item.setItemName(itemName);
			item.setItemPrice(itemPrice);
			item.setItemAvailableQuantity(itemAvailableQuantity);
			item.setItemDetail(itemDetail);

			availableItemList.put(itemID, item);
		}
	}

	// it shows the available items in itemList

	static void availableItems() {

		Set<Integer> keySet = availableItemList.keySet();
		// if user Cart is empty then show a message

		if (keySet.isEmpty()) {
			System.out.println("Your Cart is empty!");
		}
		// if user Cart has item then shows the item
		else {
			System.out
					.println("====================================================");
			System.out.println("\n\nAvailable Items:\n");
			System.out
					.println("ItemID\t\t ItemName\t\t ItemPrice\t\t ItemCount\t\t ItemDetail\n\n");
			for (int i : availableItemList.keySet()) {
				Item item = availableItemList.get(i);
				System.out.println(item.getItemID() + "\t\t "
						+ item.getItemName() + "\t\t " + item.getItemPrice()
						+ "\t\t " + item.getItemAvailableQuantity() + "\t\t "
						+ item.getItemDetail());
			}
		}

	}

	public static void main(String[] args) {

		// create a cart

		Cart cart = new Cart();

		// here we add the items to the availableItemList

		addItemToItemList(201, "Laptop", 70000, 1, "Lenovo p400 Laptop i7");

		addItemToItemList(201, "Laptop", 70000, 1, "Lenovo p400 Laptop i7");

		addItemToItemList(202, "Watch", 2000, 1000, "Sonata Primium Watch");

		addItemToItemList(203, "Shoe", 3000, 1000, "Puma shoe");

		addItemToItemList(204, "Mobile", 7000, 1000, "Samsung J2 mobile");

		addItemToItemList(204, "Bag", 1000, 1000, "Sky Bags");

		boolean flag = true;
		while (flag) {
			// shows available items in itemList

			availableItems();
			System.out.println("\n\n1. add items to cart");
			System.out.println("2. update items in cart");
			System.out.println("3. show items in cart");
			System.out.println("4. generate Bill");
			System.out.println("5. Exit");

			System.out.println("Enter your choise: \n");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {

				// here we add items from itemList to our cartList

				System.out.println("ItemID");

				Scanner sc1 = new Scanner(System.in);

				int itemID = sc1.nextInt();

				// check if the user entered itemID does exists in our
				// AvailableItemList if not then generate message

				if (availableItemList.get(itemID) == null) {
					System.out.println("Please Enter proper itemID");
					break;

				}
				System.out.println("ItemQuantity");

				Scanner sc2 = new Scanner(System.in);

				int itemAvailableQuantity = sc2.nextInt();

				// check weather the user inputs the -ve number

				if (itemAvailableQuantity < 0) {
					System.out.println("Please Enter +ve Quantity");
					break;
				}

				// add item to cart
				cart.addItemToCart(availableItemList, itemID,
						itemAvailableQuantity);
				break;
			}
			case 2: {

				System.out.println("ItemID");

				Scanner sc1 = new Scanner(System.in);

				int itemID = sc1.nextInt();

				// check if the user entered itemID does exists in our AvailableItemList if not then generate message

				if (availableItemList.get(itemID) == null) {
					System.out.println("Please Enter proper itemID");
					break;

				}
				System.out.println("ItemQuantity");

				Scanner sc2 = new Scanner(System.in);

				int itemAvailableQuantity = sc2.nextInt();
				
				// check weather the user inputs the -ve number
				if (itemAvailableQuantity < 0) {
					System.out.println("Please Enter +ve Quantity");
					break;
				}
				cart.updateItem(availableItemList, itemID,
						itemAvailableQuantity);
				break;

			}

			case 3: {
				System.out
						.println("\n\n===================================================="
								+ "\n\tyour Cart: \n");

				// it shows our cart items and bills

				cart.showCart();
				break;

			}

			case 4: {
				System.out
						.println("\n\n===================================================="
								+ "\n\ttotal Bill: \n");

				// it generates total bill
				cart.generateBill();
				break;
			}
			case 5: {
				flag = false;
				break;
			}
			}

		}

	}

}
