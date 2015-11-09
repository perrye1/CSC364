public class EdgeNode {
	private int startVertex;
	private int adjacentVertex;
	private int weight;
	private EdgeNode next;
	
	public EdgeNode(int x, int y, int w) {
		this.startVertex = x;
		this.adjacentVertex = y;
		this.weight = w;
		this.next = null;
	}

	public int getStartVertex(){
		return this.startVertex;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public EdgeNode getNext() {
		return next;
	}

	public void setNext(EdgeNode next) {
		this.next = next;
	}

	public void setStartVertex(int x){
		this.startVertex = x;
		
	}
	
	public int getAdjacentVertex(){
		return this.adjacentVertex;
	}
	
	public void setAdjacentVertex(int x) {
		this.adjacentVertex = x;
	}
}