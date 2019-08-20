import java.util.Set;


/**
 *interface for an  undirected weighted graph with the following methods:
 */
public interface GraphInterface {

    /** function to check weather the graph is connected or not
     * @param vertex, vertex no.
     * @return true, if connected o/w false is returned
     */	
	public boolean isConnected(int vertex);
	
	/** function to get all the reachable nodes from given node
     * @param vertice
     * @return, returns linkedList of all the reachable nodes
     */
	public Set reachable(int vertex);

    /** function to return minimum spanning tree 
     * @param edgeList
     * @return graph representing representing MST
     */
    public Graph getMST( int [][] edgeList);
    
    
    /**it will return the shortest path from node a to node b using Dijkstra’s algorithm. 	
     * @param a, source node
     * @param b, dest node
     * @return LinkedList holding the path from source to dest
     */
    public String shortestPath(int a, int b) ;

}
