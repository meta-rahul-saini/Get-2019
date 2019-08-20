import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;

/**
 *class to test the getOrdersInShippedState function in JDBC class
 */
public class TestGetOrdersInShippedState 
{

	@Test
	public void getOrdersInShippedState_void_ordersInShippedState()
	{
		List<OrdersInShippedState> computedOrders = JDBC.getOrdersInShippedState(603);
		int computedOutput[] = new int [computedOrders.size()];
		int expectedOutput[] = {406, 405};
		int i = 0;
		for(OrdersInShippedState order : computedOrders)
		{
			computedOutput[i] = order.getOrder_id();
			i++;
		}
		assertArrayEquals(expectedOutput, computedOutput);
	}
	
}
