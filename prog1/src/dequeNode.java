public class dequeNode{
	
	//data members for the next and previous pointers, and value
	protected dequeNode next;
	protected dequeNode prev;
	protected int val;
	
	//constructor for the node
	public dequeNode(int v){
		val=v;
		next=null;
		prev=null;
	}
	
	//returns the nodes next pointer
	public dequeNode getNext(){
		return next;
	}
	
	//returns the nodes previous pointer
	public dequeNode getPrev(){
		return prev;
	}
	
	//sets the nodes next pointer
	public void setNext(dequeNode n){
		next=n;
	}
	
	//set the nodes previous pointer
	public void setPrev(dequeNode p){
		prev=p;
	}
	
	//returns the nodes value
	public int getVal(){
		return val;
	}
}