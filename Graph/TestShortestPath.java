import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestShortestPath {
	@Test
	public void reachable_connectedGraph_shortestPath1()
	{
		Graph graph = new Graph(5);
       	
    	graph.addEdge(0, 1, 1);
    	graph.addEdge(1,  3, 2);
    	graph.addEdge(0, 3, 2);
    	graph.addEdge(0, 2, 4);
    	graph.addEdge(2, 3, 5);
    	graph.addEdge(1, 2, 1);
    	graph.showGraph();
		String expected = "0-1-2";
		
    	String computed = graph.shortestPath(0, 2);
    	assertEquals(true, expected.equals(computed));
    }
	
	@Test
	public void reachable_connectedGraph_shortestPath2()
	{
		Graph graph = new Graph(5);
       	
    	graph.addEdge(0, 1, 1);
    	graph.addEdge(1,  3, 2);
    	graph.addEdge(0, 3, 2);
    	graph.addEdge(0, 2, 4);
    	graph.addEdge(2, 3, 5);
    	graph.addEdge(1, 2, 1);
    	graph.showGraph();
    	

		String expected = "1-3";
		
    	String computed = graph.shortestPath(1, 3);
    	assertEquals(true, expected.equals(computed));
    }
	
}
