public class Heap{
	
	protected int[] elts;
	protected int count;
	protected int currentPos;
	
	public Heap(){
		 elts = new int[100];
		 count = 0;
	}
	
	public void insert(int val){
		if(this.isEmpty()){
			elts[0]=val;
			count++;
		}else{
			elts[count]=val;
			currentPos=count;
			while(val<elts[(currentPos-1)/2] && currentPos!=0){
				elts[currentPos]=elts[(currentPos-1)/2];
				currentPos=(currentPos-1)/2;
				elts[currentPos]=val;
			}
			count++;
		}
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public boolean isFull(){
		return count==100;
	}
	
	public int deleteMin() {
		int temp = elts[0];
		int smallestChild;
		int rightChild;
		int leftChild;
		count--;
		if (this.isEmpty()) {
			return temp;
		} else {
			currentPos=0;
			elts[0] = elts[count];
			rightChild=elts[(2*currentPos)+2];
			leftChild=elts[(2*currentPos)+1];
			if((2*currentPos)+2 < count){
				if(rightChild<=leftChild){
					smallestChild=rightChild;
				}else{
					smallestChild=leftChild;
				}
			}else if((2*currentPos)+1 < count){
				smallestChild=leftChild;
			}else{
				return temp
			}
			while(currentPos<(count/2) && smallestChild < elts[0]){
				
			}
		}

	}
}