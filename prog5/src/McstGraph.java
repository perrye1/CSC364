import java.util.HashSet;
import java.util.Set;

public class McstGraph {
	private EdgeNode[] edgeList; // the array for storing the adjacency list of each vertex
	private int numVertices; // the number of vertices in the graph

	// constructor for the McstGraph class
	public McstGraph(int n) {
		this.numVertices = n;
		this.edgeList = new EdgeNode[n];
		for (int x = 0; x < n; x++) {
			// we populate the array with dummy edges so we have something to attach to when doing the insert
			EdgeNode dummyEdge = new EdgeNode(-1, -1, 0);
			edgeList[x] = dummyEdge;
		}
	}

	// insert two edges, one in each direction between the given vertices, because this is an undirected graph
	public void insert(int x, int y, int w) {
		EdgeNode edge1 = new EdgeNode(x, y, w);
		EdgeNode edge2 = new EdgeNode(y, x, w);
		edge1.setNext(this.edgeList[x].getNext());
		this.edgeList[x].setNext(edge1);
		edge2.setNext(this.edgeList[y].getNext());
		this.edgeList[y].setNext(edge2);
	}

	// return the number of vertices in the graph
	public int getNumVertices() {
		return this.numVertices;
	}

	// print out the graph for debugging
	public void printGraph() {
		for (int x = 0; x < this.numVertices; x++) {
			EdgeNode a = this.edgeList[x].getNext();
			System.out.print(x);
			while (a != null) {
				System.out.print(" --> " + a.getAdjacentVertex());
				a = a.getNext();
			}
			System.out.println("");
		}
	}

	// implementation of Prim's Algorithm
	public int primsAlg() {
		int totalCost = 0;

		// create the unvisited set, and add all the vertices to it (except 0, because we start the traversal at 0 )
		Set<Integer> unvisited = new HashSet<Integer>(this.numVertices);
		for (int x = 1; x < this.numVertices; x++) {
			unvisited.add(x);
		}

		// create the visited set and add the vertex 0 to it
		Set<Integer> visited = new HashSet<Integer>(this.numVertices);
		visited.add(0);

		// create a set of EdgeNodes to hold the possible least cost edges for each iteration of the traversal
		Set<EdgeNode> currentEdges = new HashSet<EdgeNode>(this.numVertices * this.numVertices);

		// while the unvisited list still has vertices in it, we look at the edges connected to each visited vertex, and find the least cost edge
		while (!unvisited.isEmpty()) {
			for (int v : visited) {
				EdgeNode a = this.edgeList[v];
				// walking through the adjacency linked-list
				while (a != null) {
					if (unvisited.contains(a.getAdjacentVertex())) {
						currentEdges.add(a);
					}
					a = a.getNext();
				}
			}

			int lowestEdgeCost = Integer.MAX_VALUE;
			EdgeNode lowestEdge = null;

			// find the least cost edge in the list of all edges from visited vertices to unvisited vertices
			for (EdgeNode e : currentEdges) {
				if (e.getWeight() < lowestEdgeCost) {
					lowestEdge = e;
					lowestEdgeCost = e.getWeight();
				}
			}

			// print out the edge when it is found
			System.out.println(lowestEdge.getStartVertex() + " --- "
					+ lowestEdge.getAdjacentVertex() + " == "
					+ lowestEdge.getWeight());
			// add the edge's weight to the total weight of the MCST
			totalCost = totalCost + lowestEdge.getWeight();
			currentEdges.clear();
			visited.add(lowestEdge.getAdjacentVertex());
			unvisited.remove(lowestEdge.getAdjacentVertex());
		}
		return totalCost;
	}
}