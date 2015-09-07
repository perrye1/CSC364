public class dequeNode{
	
	protected dequeNode next;
	protected dequeNode prev;
	protected int val;
	
	public dequeNode(int v){
		val=v;
		next=null;
		prev=null;
	}
	
	public dequeNode getNext(){
		return next;
	}
	
	public dequeNode getPrev(){
		return prev;
	}
	
	public void setNext(dequeNode n){
		next=n;
	}
	
	public void setPrev(dequeNode p){
		prev=p;
	}
	
	public int getVal(){
		return val;
	}
}