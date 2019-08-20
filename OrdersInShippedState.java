import java.sql.Date;


/**
 *class used to hold the order data which are in shipped state
 */
public class OrdersInShippedState {

	private int order_id;
	private Date order_date;
	private float order_amount;
	
	public OrdersInShippedState(int order_id, Date order_date,
			float order_amount) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.order_amount = order_amount;
	}

	// getters and setters
	public int getOrder_id() {
		return order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public float getOrder_amount() {
		return order_amount;
	}
	
}
