import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class deque{
	private dequeNode front;
	private dequeNode rear;
	
	public deque(){
		front=null;
		rear=null;
	}
	
	public void insertFront(int item){
		dequeNode temp = new dequeNode(item);
		if(front==null){
			temp.setNext(temp);
			temp.setPrev(temp);
			front=temp;
			rear=temp;
		}else{
			temp.setPrev(rear);
			rear.setNext(temp);
			temp.setNext(front);
			front.setPrev(temp);
			front=temp;
		}
	}
	
	public void insertRear(int item){
		dequeNode temp = new dequeNode(item);
		if(front==null){
			temp.setNext(temp);
			temp.setPrev(temp);
			front=temp;
			rear=temp;
		}else{
			temp.setPrev(rear);
			rear.setNext(temp);
			temp.setNext(front);
			front.setPrev(temp);
			rear=temp;
		}
	}
	
	public int deleteFront(){
		int val=front.getVal();
		dequeNode prev = front.getPrev();
		dequeNode next = front.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		front=next;
		return val;
	}
	
	public int deleteRear(){
		int val=rear.getVal();
		dequeNode prev = rear.getPrev();
		dequeNode next = rear.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		rear=prev;
		return val;
	}
	
	public boolean isEmpty(){
		return (front==null);
	}
	
	public void printDeque(String path) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
		dequeNode temp=front;
		if(isEmpty()){
			writer.write("EMPTY DEQUE\r\n");
		}else{
			writer.write("----Front----\r\n");
			while (temp.getNext() != front){
				writer.write(Integer.toString(temp.getVal()));
				writer.write("\r\n");
				temp=temp.getNext();
			}
			writer.write(Integer.toString(temp.getVal()));
			writer.write("\r\n");
			writer.write("----Rear----\r\n");
		}
		
		writer.close();
	}
	
}