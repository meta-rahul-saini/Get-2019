// item class store the item information

public class Item {

	int itemID = 0;
	String itemName = "";
	int itemPrice = 0;
	int itemAvailableQuantity = 0;
	String itemDetail = "";

	// we use getters and setters to update and access item information

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		if (itemPrice < 0) {
			throw new ArithmeticException("price must be positive");
		}
		this.itemPrice = itemPrice;
	}

	public int getItemAvailableQuantity() {
		return itemAvailableQuantity;
	}

	public void setItemAvailableQuantity(int itemAvailablityCount) {
		if (itemPrice < 0) {
			throw new ArithmeticException("itemAvailablityCount must be positive");
		}
		this.itemAvailableQuantity = itemAvailablityCount;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

}
