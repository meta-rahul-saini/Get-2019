
public class GraphNode {
	
		private int vertex;
		private int weight;

		GraphNode next = null;

		public GraphNode(int vertex, int weight) 
		{
			this.vertex = vertex;
			this.weight = weight;
		}

		// getters and setters
		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
}


