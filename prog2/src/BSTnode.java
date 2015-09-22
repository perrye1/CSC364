import java.io.BufferedWriter;
import java.io.IOException;

public class BSTnode {
	
	// data members for the BSTnode
	protected int val;
	BSTnode left;
	BSTnode right;
	int level;
	
	// constructor that sets the value and level. Also sets the right and left nodes to null
	public BSTnode(int v, int lev){
		val=v;
		level=lev;
		right=null;
		left=null;
	}
	
	// getter for the value
	public int getVal(){
		return val;
	}
	
	// getter for the level
	public int getLevel(){
		return level;
	}
	
	// getter for the left node
	public BSTnode getLeft(){
		return left;
	}
	
	// getter for the right node
	public BSTnode getRight(){
		return right;
	}
	
	// setter for the left node
	public void setLeft(BSTnode l){
		left=l;
	}
	
	// setter for the right node
	public void setRight(BSTnode r){
		right=r;
	}
	
	// recursive method to add a value to the BST
	public void add(int val, int lev){
		
		// if the value is less than the current node, we go left
		if (this.getVal() > val) {
			if (this.getLeft() == null) {
				// if there is no left child, we create one and set it
				BSTnode temp = new BSTnode(val, lev);
				this.setLeft(temp);
			} else {
				//otherwise, we recursively call add on the left child, passing in the value and next level
				this.getLeft().add(val, lev+1);
			}
		//otherwise, the value must be greater than the current node, so we go right
		} else {
			if (this.getRight() == null) {
				//if there is no right child, we create one and set it
				BSTnode temp = new BSTnode(val, lev);
				this.setRight(temp);
			} else {
				//otherwise, we recursively call add on the right child, passing in the value and next level
				this.getRight().add(val, lev+1);
			}
		}
	}
	
	// recursive method to print out an in order traversal of the BST
	public void inOrder(BufferedWriter writer) throws IOException{
		// we go as far left as we can 
		if(this.getLeft() != null){
			this.getLeft().inOrder(writer);
		}
		// then we print out the value
		writer.write(Integer.toString(this.getVal()));
		writer.write("\r\n");
		// then go back and right as far as we need to, until we can go left again
		if(this.getRight() != null){
			this.getRight().inOrder(writer);
		}
	}
}