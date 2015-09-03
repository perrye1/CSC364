public class deque{
	private dequeNode elts;
	
	public deque(){
		elts=null;
	}
	
	public void insertFront(int item){
		dequeNode temp = new dequeNode(item);
		if(elts==null){
			elts=temp;
		}else{
			temp.setNext(elts);
			elts=temp;
		}
	}
	
	public void insertRear(int item){
		dequeNode temp = new dequeNode(item);
		if(elts==null){
			elts=temp;
		}
	}
	
	public int deleteFront(){
		
	}
	
	public int deleteRear(){
		
	}
	
	public boolean isEmpty(){
		
	}
	
	public void printDeque(){
		
	}
	
}