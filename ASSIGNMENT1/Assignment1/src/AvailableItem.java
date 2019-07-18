import java.util.HashMap;
import java.util.Set;

public class AvailableItem {

	// this is itemsList where all the available items are stored.
	HashMap<Integer, Item> availableItemList = new HashMap<>();
	
	public void addItemToItemList(int itemID, String itemName,
			int itemPrice, int itemAvailableQuantity, String itemDetail) {

		// check if item is already in our availableItemList if it exists then
		// simply increase the itemAvailableQuantity

		if (availableItemList.containsKey(itemID)) {
			Item item = availableItemList.get(itemID);
			item.setItemQuantity(item.getItemQuantity()
					+ itemAvailableQuantity);
		}
		// if item already doesn't exists in our availableItemList then create a
		// new Item and then set the itemAvailableQuantity
		else {
			Item item = new Item();
			item.setItemID(itemID);
			item.setItemName(itemName);
			item.setItemPrice(itemPrice);
			item.setItemQuantity(itemAvailableQuantity);
			item.setItemDetail(itemDetail);

			availableItemList.put(itemID, item);
		}
	}
	
	public void showAvailableItems() {

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
						+ "\t\t " + item.getItemQuantity() + "\t\t "
						+ item.getItemDetail());
			}
		}

	}
	
	public  HashMap<Integer, Item> getAvailableItemList() {
		return availableItemList;
	}

	public  void setAvailableItemList(HashMap<Integer, Item> availableItemList) {
		this.availableItemList = availableItemList;
	}

}
