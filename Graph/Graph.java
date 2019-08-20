import java.util.HashSet;
import java.util.Set;


public class Graph implements GraphInterface{
	
	private LinkedList adjLists[];
	private boolean isVisitedVertices[];
	private Stack stack = null;
	private  int noOfVertices = 0;
	
	/** constructor to initialize the graph parameters
	 * @param noOfVertices 
	 */
	public Graph(int noOfVertices)
	{
		this.noOfVertices = noOfVertices;
		this.stack = new Stack ();
		adjLists = new LinkedList[noOfVertices];
		this.isVisitedVertices = new boolean [noOfVertices]; 
		
		// Initialize with adjacency list
		for (int i = 0; i < noOfVertices; i++) {
			adjLists[i] = new LinkedList();
		}
	}
	

    /**function to add edge in corresponding adjacency list
     * @param vertice1
     * @param vertice2
     * @param weight
     */
    void addEdge(int vertice1, int vertice2, int weight)
    {
    	adjLists[vertice1].addNode(vertice2, weight);
    	adjLists[vertice2].addNode(vertice1, weight);	
    }
    
    /** function to check weather the graph is connected or not
     * @param vertex, vertex no.
     * @return true, if connected o/w false is returned
     */
    @Override
    public boolean isConnected(int vertex)
    {
    	isVisitedVertices[vertex] = true;
        System.out.print(vertex + " ");
 
        GraphNode iterator = adjLists[vertex].getFront();

        stack.push(vertex);
        
        int currentVertices = 0;
        
        // DFS traversal using stack 
        while ( !stack.isEmpty() )
        {
        	// pop the first node on stack
        	currentVertices  = stack.pop();
        	
        	// mark as visited
        	isVisitedVertices[currentVertices]  =  true;
        	
        	// getting the iterator of the corresponding list
        	iterator = adjLists[currentVertices].getFront();
        	
        	// iterate the current list until null and push the nodes that are not yet visited
        	while(iterator != null)
        		{
        			if( isVisitedVertices[iterator.getVertex()]  == false)
                	{        
        				stack.push(iterator.getVertex());
                	}
        			iterator = iterator.next;
        		}
        }
       
        // iterate over the isVisitedArray and check weather the any of node is not visited or not 
        // if not return false o/w return true
        for (int currentIsVisitedVerticesIndex = 0; 
        		currentIsVisitedVerticesIndex < isVisitedVertices.length; 
        		currentIsVisitedVerticesIndex++)
        {
        	if( isVisitedVertices[currentIsVisitedVerticesIndex] == false)
        	{ 
        		return false;
        	}
		}
        return true;
    }
    
    /** function to get all the reachable nodes from given node
     * @param vertice
     * @return, returns linkedList of all the reachable nodes
     */
    @Override
    public Set reachable(int vertice)
    {
    	Set<Integer> reachableNodes =  new HashSet<Integer>(); 
    	GraphNode iterator = adjLists[vertice].getFront();
    	
    	while(iterator != null)
    	{
    		reachableNodes.add(iterator.getVertex());
    		iterator = iterator.next;
    	}
    	return reachableNodes;
    }
    
    
    /**a recursive function to detect the cycle in graph 
     * @param v, source vertex from where to start
     * @param visited
     * @param parent
     * @return true if graph is cyclic o/w return false
     */
    Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
    { 
        // Mark the current node as visited 
        visited[v] = true; 
      
        GraphNode iterator = adjLists[v].getFront();
        while(iterator != null)
        {
        	if(!visited[ iterator.getVertex()])
        	{     		
        		if(isCyclicUtil(iterator.getVertex(), visited, v))
        			{	
        				return true;
        			}
        	}
        	//  if an adjacent is visited and not parent of current vertex, then there is a cycle.
        	else if (iterator.getVertex() != parent)
        		{
        			return true;
            	}
        	iterator = iterator.next;
        }
        return false; 
    } 
  
    // Returns true if the graph contains a cycle, else false. 
   public boolean isCyclic() 
    { 
        // Mark all the vertices as not visited and not part of 
        // recursion stack 
        Boolean visited[] = new Boolean[this.noOfVertices]; 
        for (int currentIndex = 0; currentIndex < this.noOfVertices; currentIndex++) 
        {
        	visited[currentIndex] = false; 
        }
      // Call the recursive helper function to detect cycle
        for (int currentIndex = 0; currentIndex < this.noOfVertices; currentIndex++) 
        {
        	if (!visited[currentIndex]) // Don't recur for currentIndex if already visited 
        		{    
            		if (isCyclicUtil(currentIndex, visited, -1)) 
            		{
            			return true; 
        			}	
        		}
        }
        return false; 
    } 
    
    /**
     * function to show graph
     */
    public void showGraph()
    {
    	for (int i = 0; i < adjLists.length; i++) 
    	{
			adjLists[i].showList();
		}
    }
    
    /* (non-Javadoc)
     * @see GraphInterface#getMST(int[][])
     */
    @Override
    public Graph getMST( int [][] edgeList)
    {
    
	Graph graph1 = new Graph(4);
    	
	for (int currentIndex = 0; currentIndex < edgeList.length; currentIndex++) 
	{
			graph1.addEdge(edgeList[currentIndex][0], edgeList[currentIndex][1], edgeList[currentIndex][2]);
	    	if(graph1.isCyclic())
	    	{
	    		graph1.adjLists[ edgeList[currentIndex][0]].showList();
	    		graph1.adjLists[ edgeList[currentIndex][0]].discardRearEdge();
	    		graph1.adjLists[ edgeList[currentIndex][1]].discardRearEdge();
	    		graph1.adjLists[ edgeList[currentIndex][0]].showList();
	    	}
	 }		
	    for(int currentIndex = 0; currentIndex < edgeList.length - 1 ; currentIndex++)
	    {
	    	graph1.adjLists[currentIndex].showList();
	    	System.out.println();
	    }
    	return graph1;
    }

	/**we use this function to get  adjacency matrix representation of graph
	 * @return adjacency matrix 
	 */
	public int[][] adjMat()
	{
		int adMat[][] = new int[this.noOfVertices][this.noOfVertices];
		GraphNode iterator = null;
		
		for(int row = 0; row < this.noOfVertices; row++)
		{
			for(int column = 0; column < this.noOfVertices; column++)
			{
				adMat[row][column] = 0;
			}
		};
		for(int currentVertexIndex = 0; currentVertexIndex < this.noOfVertices; currentVertexIndex++)
		{
			iterator = adjLists[currentVertexIndex].getFront();
			while(iterator != null)
				{
				adMat[currentVertexIndex][iterator.getVertex()] = iterator.getWeight();
				adMat[iterator.getVertex()][currentVertexIndex] = iterator.getWeight();
				iterator = iterator.next;
				}
		}
		
		for (int i = 0; i < adMat.length; i++) {
			for (int j = 0; j < adMat.length; j++) {
				System.out.print(adMat[i][j]);
			}
			System.out.println();
		}
		return adMat;
	}
		
	/**function to return distance matrix
	 * @param src
	 * @return return distance matrix
	 */
	public int[][] dijkstra(int src) 
	{
		
		int[][] adMat = adjMat();
		int dist[][] = new int[this.noOfVertices][2];
		boolean visitedNodesStatus[] = new boolean[this.noOfVertices];

		for (int count = 0; count < this.noOfVertices; count++) 
		{
			dist[count][0] = Integer.MAX_VALUE;
			dist[count][1] = -1;
		}
		
		dist[src][0] = 0;
		for (int count = 0; count < this.noOfVertices - 1; count++) 
		{
			int u = minDistance(dist, visitedNodesStatus);
			visitedNodesStatus[u] = true; 
			
			for(int count1 = 0; count1 < this.noOfVertices; count1++)
			{
				if(!visitedNodesStatus[count1] && adMat[u][count1]!=0 && dist[u][0]+adMat[u][count1] < dist[count1][0])
				{
					dist[count1][0] = dist[u][0]+adMat[u][count1];
					dist[count1][1] = u; 
				}
			}
		}
		return dist;
	}
	
	/* (non-Javadoc)
	 * @see GraphInterface#shortestPath(int, int)
	 */
	public String shortestPath(int a, int b) 
	{
		int src = a, des = b;
		int[][] dist = dijkstra(src);
		String path = Integer.toString(des);
		int  currVertex = des;
		while(currVertex != -1 && currVertex != src){
			path = Integer.toString(dist[currVertex][1])+"-"+path;
			currVertex = dist[currVertex][1];
		}
		return path;
	}
	/**function to find the direct minimum distance from source to other nodes
	 * @param dist
	 * @param sptSet
	 * @return index of minimum distance
	 */
	public int minDistance(int[][] dist, boolean[] sptSet) 
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int count = 0; count < this.noOfVertices; count++)
			{
				if (sptSet[count] == false && dist[count][0] <= min) 
				{
					min = dist[count][0];
					min_index = count;
				}
			}
		return min_index;
	}
	
	public static void main(String[] args) 
    {
    	Graph graph = new Graph(4);
   	
    	graph.addEdge(0, 1, 1);
    	graph.addEdge(1,  3, 2);
    	graph.addEdge(0, 3, 3);
    	graph.addEdge(0, 2, 4);
    	graph.addEdge(2, 3, 5);
    	graph.addEdge(1, 2, 1);
    	graph.showGraph();

    	//    	graph.getMST(edgeList);
    	System.out.println(graph.shortestPath(0, 2));
        	
    	System.out.println(" is connected? " + graph.isConnected(0));
    	
    	System.out.println("is Cyclic: ?" + graph.isCyclic());
    	
	}

}
