
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class TestConnected {

	@Test
	public void isConnected_connectedGraph_connected(){
		
    	Graph graph = new Graph(4);
       	
    	graph.addEdge(0, 1, 1);
    	graph.addEdge(1,  3, 2);
    	graph.addEdge(0, 3, 3);
    	graph.addEdge(0, 2, 4);
    	graph.addEdge(2, 3, 5);
    	graph.addEdge(1, 2, 1);
    	graph.showGraph();
    	
    	boolean expected = true;
    	assertEquals(expected, graph.isConnected(0));
	}
	
	@Test
	public void isConnected_connectedGraph_Notconnected(){
		
    	Graph graph = new Graph(5);
       	
    	graph.addEdge(0, 1, 1);
    	graph.addEdge(1,  3, 2);
    	graph.addEdge(0, 3, 3);
    	graph.addEdge(0, 2, 4);
    	graph.addEdge(2, 3, 5);
    	graph.addEdge(1, 2, 1);
    	graph.showGraph();
    	
    	boolean expected = false;
    	assertEquals(expected, graph.isConnected(0));
	}
	
}