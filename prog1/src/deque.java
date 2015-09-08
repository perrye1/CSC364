import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class deque{
	
	//data members for the front and rear of the deque
	private dequeNode front;
	private dequeNode rear;
	
	//default constructor sets the front and rear to null
	public deque(){
		front=null;
		rear=null;
	}
	
	//inserts a value at the front of the deque
	public void insertFront(int item){
		
		//create the new node that will be inserted
		dequeNode temp = new dequeNode(item);
		
		if(front==null){
			
			//if the front is null, the list is empty, and we can set 
			//temp's pointers to itself, and set front and rear to temp
			temp.setNext(temp);
			temp.setPrev(temp);
			front=temp;
			rear=temp;
		}else{
			
			//otherwise, we need to splice in the new node before the current front
			//and re-link the rear to the new front (circular)
			temp.setPrev(rear);
			rear.setNext(temp);
			temp.setNext(front);
			front.setPrev(temp);
			front=temp;
		}
	}
	
	//inserts a value at the front of the deque
	public void insertRear(int item){
		
		//create the new node that will be inserted
		dequeNode temp = new dequeNode(item);
		
		if(front==null){
			
			//if the front is null, the list is empty, and we can set 
			//temp's pointers to itself, and set front and rear to temp
			temp.setNext(temp);
			temp.setPrev(temp);
			front=temp;
			rear=temp;
		}else{
			
			//otherwise, we need to splice in the new node after the current rear
			//and re-link the new rear to the front (circular)
			temp.setPrev(rear);
			rear.setNext(temp);
			temp.setNext(front);
			front.setPrev(temp);
			rear=temp;
		}
	}
	
	//deletes a node from the front of the deque
	public int deleteFront(){
		
		//pull the value of the front before we change it
		int val=front.getVal();
		
		//get the next and previous nodes from the front
		dequeNode prev = front.getPrev();
		dequeNode next = front.getNext();
		
		//link those nodes together, thus cutting out the front
		prev.setNext(next);
		next.setPrev(prev);
		
		//the new front becomes the next node after the front we removed
		front=next;
		
		//return the value
		return val;
	}
	
	//remove a node from the rear of the deque
	public int deleteRear(){
		
		//pull the value of the rear before we change it
		int val=rear.getVal();
		
		//get the next and previous nodes from the rear
		dequeNode prev = rear.getPrev();
		dequeNode next = rear.getNext();
		
		//link those nodes together, thus cutting out the rear
		prev.setNext(next);
		next.setPrev(prev);
		
		//the new rear becomes the previous node before the rear we removed
		rear=prev;
		
		//return the value
		return val;
	}
	
	//tests if the deque is empty
	public boolean isEmpty(){
		return (front==null);
	}
	
	//prints the current state of the deque out to a file
	public void printDeque(String path) throws IOException{
		
		//create a new file writer, set to append
		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
		
		//create a temp node that is the front
		dequeNode temp=front;
		
		if(isEmpty()){
			
			//if the deque is empty, we can just write out out EMPTY DEQUE
			writer.write("EMPTY DEQUE\r\n");
		}else{
			
			writer.write("----Front----\r\n");
			
			//while we haven't looped all the way back around the deque,
			//write out the value at that node
			while (temp.getNext() != front){
				writer.write(Integer.toString(temp.getVal()));
				writer.write("\r\n");
				temp=temp.getNext();
			}
			
			//the last value will not be written out in the loop, so we need to write it
			writer.write(Integer.toString(temp.getVal()));
			writer.write("\r\n");
			writer.write("----Rear----\r\n");
		}
		
		//close the writer
		writer.close();
	}
	
}