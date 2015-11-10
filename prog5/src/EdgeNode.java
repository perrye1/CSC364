public class EdgeNode {
	private int startVertex; // the vertex this edge starts at
	private int adjacentVertex; // the vertex this edge ends at
	private int weight; // the weight of this edge
	private EdgeNode next; // pointer to the next edge in the adjacency list
	
	// constructor for the EdgeNode class
	public EdgeNode(int x, int y, int w) {
		this.startVertex = x;
		this.adjacentVertex = y;
		this.weight = w;
		this.next = null;
	}
	
	// getter for startVertex
	public int getStartVertex(){
		return this.startVertex;
	}
	
	// setter for startVertex
	public void setStartVertex(int x){
		this.startVertex = x;	
	}
	
	// getter for adjacentVertex
	public int getAdjacentVertex(){
		return this.adjacentVertex;
	}
	
	// setter for adjacentVertex
	public void setAdjacentVertex(int x) {
		this.adjacentVertex = x;
	}
	
	// getter for weight
	public int getWeight() {
		return weight;
	}
	// setter for weight
	public void setWeight(int weight) {
		this.weight = weight;
	}

	// getter for next pointer
	public EdgeNode getNext() {
		return next;
	}

	// setter for next pointer
	public void setNext(EdgeNode next) {
		this.next = next;
	}
}