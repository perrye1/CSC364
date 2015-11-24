public class DAG {
	private boolean[][] G; // the adjacency matrix itself
	private int[] inDegree; // an array which stores the in-degree for each vertex
	private boolean[] scheduled; // Boolean array indicating if the vertex has been scheduled or not.
	private int numvertices; // count of the number of vertices in the graph.

	// constructor for the DAG class
	public DAG(int N) {
		this.G = new boolean[N][N];
		this.inDegree = new int[N];
		this.scheduled = new boolean[N];
		this.numvertices = N;
	}

	// adds an edge to the adjacency matrix representation of the graph
	public void setXY(int X, int Y) {
		this.G[X][Y] = true;
	}

	// sets the in degree of each vertex
	public void setInDegree() {
		for (int i = 0; i < numvertices; i++) {
			int sum = 0;
			for (int j = 0; j < numvertices; j++) {
				if (this.G[j][i] == true) {
					sum++;
				}
			}
			this.inDegree[i] = sum;
		}
	}

	// performs the topological sort
	public void topologicalSort() {
		int numScheduled = 0;
		while (numScheduled < this.numvertices) {
			for (int i = 0; i < numvertices; i++) {
				if (scheduled[i] == false && inDegree[i] == 0) {
					scheduled[i] = true;
					numScheduled++;
					System.out.println(i);
					for (int j = 0; j < numvertices; j++) {
						if (this.G[i][j] == true) {
							inDegree[j] = inDegree[j] - 1;
						}
					}
				}
			}
		}
	}
}