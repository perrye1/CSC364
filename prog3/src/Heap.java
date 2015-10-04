public class Heap{
	
	//data members for the heap
	protected int[] elts;
	protected int count;
	
	//constructor for the heap (we are assuming that there will never be more than 100 elements)
	public Heap(){
		 elts = new int[100];
		 count = 0;
	}
	
	//inserts a new value into the heap
	public void insert(int val){
		int currentPos;
		if(this.isEmpty()){
			elts[0]=val;//if the heap is empty, we can just put the new value at the root
			count++;
		}else{
			elts[count]=val;//otherwise, we start by putting the node at the very bottom of the heap
			currentPos=count;
			//preserve the heap property by pushing the node up until its at the root, or its greater than its parent
			while(val<elts[(currentPos-1)/2] && currentPos!=0){
				elts[currentPos]=elts[(currentPos-1)/2];
				currentPos=(currentPos-1)/2;
				elts[currentPos]=val;
			}
			count++;//make sure we increment the count, to indicate we added a node
		}
	}
	
	//checks if the heap is empty
	public boolean isEmpty(){
		return count==0;
	}
	
	//checks if the heap is full
	public boolean isFull(){
		return count==100;
	}
	
	//removes and returns the root of the heap. Calls pushDown() to preserve the heap property.
	public int deleteMin() {
		int temp = elts[0];
		elts[0] = elts[count-1];
		count--;
		if (!this.isEmpty()) {
			this.pushDown(0);
		}
		return temp;
	}
	
	//recursive helper function for deleteMin
	private void pushDown(int index){
		int leftChild=(2*index)+1;
		int rightChild=(2*index)+2;
		int smallestChild;
		int temp;
		//making sure the children exist before doing the swap
		if(rightChild >= count){
			if(leftChild >=count){
				return; //if both children are past count, they don't exist, and we are done
			}else{
				smallestChild=leftChild; //if the right child doesn't exist, but the left child does, we know that the left is the smallest
			}
		}else{
			//if both children exist, we need to get the smaller one
			if(elts[leftChild]<=elts[rightChild]){
				smallestChild=leftChild;
			}else{
				smallestChild=rightChild;
			}
		}
		//once we have the smallest child, if its smaller than the index, we swap them
		if(elts[index]>elts[smallestChild]){
			temp=elts[smallestChild];
			elts[smallestChild]=elts[index];
			elts[index]=temp;
			pushDown(smallestChild); //keep pushing the node down the heap
		}
	}
}