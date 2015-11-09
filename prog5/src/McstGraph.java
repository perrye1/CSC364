import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class McstGraph {
	private EdgeNode[] edgeList;
	private int numVertices;
	
	public McstGraph(int n){
		this.numVertices = n;
		this.edgeList = new EdgeNode[n];
		Arrays.fill(this.edgeList, new EdgeNode(-1,-1,0));
	}
	
	public void insert(int x, int y, int w){
		EdgeNode edge = new EdgeNode(x, y, w);
		edge.setNext(this.edgeList[x].getNext());
		this.edgeList[x].setNext(edge);
	}
	
	public int getNumVertices(){
		return this.numVertices;
	}
	
	public int primsAlg() {
		int totalCost = 0;

		Set<Integer> unvisited = new HashSet<Integer>(this.numVertices);
		for (int x = 1; x < this.numVertices; x++) {
			unvisited.add(x);
		}

		Set<Integer> visited = new HashSet<Integer>(this.numVertices);
		visited.add(0);

		Set<EdgeNode> currentEdges = new HashSet<EdgeNode>(this.numVertices * this.numVertices);

		while (!unvisited.isEmpty()) {
			for (int v : visited) {
				EdgeNode a = this.edgeList[v];
				while (a.getNext() != null) {
					if (unvisited.contains(a.getAdjacentVertex())) {
						currentEdges.add(a);
					}
					a = a.getNext();
				}
			}

			int lowestEdgeCost = Integer.MAX_VALUE;
			EdgeNode lowestEdge = null;

			for (EdgeNode e : currentEdges) {
				if (e.getWeight() < lowestEdgeCost) {
					lowestEdge = e;
					lowestEdgeCost = e.getWeight();
				}
			}

			System.out.println(lowestEdge.getStartVertex() + " --- "
					+ lowestEdge.getAdjacentVertex() + " == "
					+ lowestEdge.getWeight());
			totalCost = totalCost + lowestEdge.getWeight();
			currentEdges.clear();
			visited.add(lowestEdge.getAdjacentVertex());
			unvisited.remove(lowestEdge.getAdjacentVertex());
		}
		return totalCost;
	}
}