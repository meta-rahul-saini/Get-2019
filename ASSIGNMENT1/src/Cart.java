import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Cart {

	// this is our cart in which we store our Item

	HashMap<Integer, Item> cartItemList = new HashMap<>();

	// we use this function to add items to our cartList from availableItemList

	public void addItemToCart(HashMap<Integer, Item> availableItemList,
			int itemID, int itemAvailableQuantity) {

		Item choosedItem = availableItemList.get(itemID);

		if (choosedItem.getItemAvailableQuantity() < itemAvailableQuantity) {
			System.out
					.println("Sorry, Requested no. of Items are not available");
		} else {
			Item item = new Item();
			item.setItemID(choosedItem.getItemID());
			item.setItemName(choosedItem.getItemName());
			item.setItemPrice(choosedItem.getItemPrice());
			item.setItemAvailableQuantity(itemAvailableQuantity);
			item.setItemDetail(choosedItem.getItemDetail());

			// updating the count of items in itemList

			choosedItem.setItemAvailableQuantity(choosedItem
					.getItemAvailableQuantity() - itemAvailableQuantity);

			// adding the items in cart
			cartItemList.put(itemID, item);

		}

	}

	// update the item in cart

	public void updateItem(HashMap<Integer, Item> availableItemList,
			int itemID, int itemAvailableQuantity) {

		if (cartItemList.containsKey(itemID)) {

			// getting the item from cartList

			Item item = cartItemList.get(itemID);

			// getting the item from availableItemList

			Item availableItemListItem = availableItemList.get(itemID);

			if (itemAvailableQuantity == 0) {

				// removing the item from cartList

				cartItemList.remove(itemID);

				// updating the availableQuantity of item in availableItemList

				availableItemListItem
						.setItemAvailableQuantity(availableItemListItem
								.getItemAvailableQuantity()
								+ item.getItemAvailableQuantity());
			} else {

				if (itemAvailableQuantity < availableItemListItem
						.getItemAvailableQuantity()
						+ item.getItemAvailableQuantity()) {

					// updating the available itemAvailableQuantity in the item
					// in itemList

					availableItemListItem
							.setItemAvailableQuantity(availableItemListItem
									.getItemAvailableQuantity()
									+ item.getItemAvailableQuantity()
									- itemAvailableQuantity);

					// updating the requested itemAvailableQuantity in the item
					// in CartList

					item.setItemAvailableQuantity(itemAvailableQuantity);

				}

				else {

					System.out
							.println("Sorry, Requested no. of Items are not available");
				}

			}

		} else {
			System.out
					.println("Sorry you don't have item in your cart that you want to update");

		}

	}

	// display the cart items

	public void showCart() {

		Set<Integer> keySet = cartItemList.keySet();

		// check weather the cart is empty

		if (keySet.isEmpty()) {
			System.out.println("Your Cart is empty!");
		}

		// if cart is not empty show the items in cart

		else {
			for (Integer itemID : cartItemList.keySet()) {
				Item item = cartItemList.get(itemID);
				System.out.println("item ID:" + item.getItemID());
				System.out.println("item Name:" + item.getItemName());
				System.out.println("item Price:" + item.getItemPrice());
				System.out.println("item Count:"
						+ item.getItemAvailableQuantity());
				System.out.println("item Detail:" + item.getItemDetail());
				System.out.println("---------------------------------");
			}
		}
	}

	// generate the total bill for the item selected in the cart

	public void generateBill() {
		int totalAmount = 0;

		Set<Integer> s = cartItemList.keySet();

		// check weather the cart is empty

		if (s.isEmpty()) {
			System.out.println("Your Cart is empty!");
		}

		// if cart is not empty show the items in cart

		else {
			for (Integer itemID : cartItemList.keySet()) {

				Item item = cartItemList.get(itemID);
				totalAmount += item.getItemPrice()
						* item.getItemAvailableQuantity();
				System.out.println("item ID: " + item.getItemID()
						+ "\t item Name: " + item.getItemName()
						+ "\t item Price" + item.getItemPrice() + "\t #item added to Cart" + item.getItemAvailableQuantity());

			}
			System.out.println("\ntotalAmount:" + totalAmount + "\n\n");
		}

		

	}

}
