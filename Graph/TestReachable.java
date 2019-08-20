import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class TestReachable {

	@Test
	public void reachable_connectedGraph_LinkListContainingReachableNodes()
	{
		Graph graph = new Graph(5);
       	
    	graph.addEdge(0, 1, 1);
    	graph.addEdge(1,  3, 2);
    	graph.addEdge(0, 2, 4);
    	graph.addEdge(2, 3, 5);
    	graph.addEdge(1, 2, 1);
    	graph.showGraph();
    	

		Set <Integer>expected = new <Integer>HashSet();
		expected.add(1);
		expected.add(2);
		
    	Set<Integer> computed = graph.reachable(0);
    	
    	assertEquals(true, expected.equals(computed));
	}
}
