// item class store the item information

public class Item {

	private int itemID = 0;
	private String itemName = "";
	private int itemPrice = 0;
	private int itemQuantity = 0;
	private String itemDetail = "";

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

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemAvailablityCount) {
		if (itemPrice < 0) {
			throw new ArithmeticException("itemAvailablityCount must be positive");
		}
		this.itemQuantity = itemAvailablityCount;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

}
