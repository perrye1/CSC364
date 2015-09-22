import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BST{
	
	// data member for the root of the BST
	protected BSTnode root;
	
	// default constructor sets the root to null
	public BST(){
		root=null;
	}
	
	// inserts a value into BST
	public void insert(int val){
		if(root == null){
			// if the root is null, create a new node and set it as the root
			BSTnode temp = new BSTnode(val, 1);
			root=temp;
		}else{
			// otherwise, call the add method on the root, passing it the value to add 
			root.add(val, 2);
		}
	}
	
	// prints out a level order traversal of the BST
	public void levelOrder(BufferedWriter writer) throws IOException{
		writer.write("LEVEL ORDER TRAVERSAL:\r\n");
		if ( root == null ){
			   writer.write("EMPTY BST\r\n");
		}else{
			// if the root is not null, proceed with the traversal
			// we need a variable to keep track of what level we are on
			int prevLevel = 1;
			// a queue to hold the values in the correct order for printing
			Queue<BSTnode> Q = new LinkedList<BSTnode>();
			Q.add(root);
			// we put basically put a level into the queue, print out all the values in that 
			// level, then move to the next level by getting the children of the nodes in the queue
			while(!Q.isEmpty()){
				BSTnode temp = Q.remove();
				if(temp.getLeft() != null){
					Q.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					Q.add(temp.getRight());
				}
				// we check to make we are on the same level as the last node, otherwise we move 
				// to a new line to indicate we are on the next level. 
				if(temp.getLevel() == prevLevel){
					writer.write(Integer.toString(temp.getVal()));
					writer.write("  ");
				}else{
					writer.write("\r\n");
					writer.write(Integer.toString(temp.getVal()));
					writer.write("  ");
					prevLevel ++;
				}
			}
			writer.write("\r\n");
		}
	}
	
	// prints out an in order traversal of the BST. This is a dummy method that
	// calls the real inorder method on the root node itself
	public void inOrder(BufferedWriter writer) throws IOException{
		writer.write("IN ORDER TRAVERSAL:\r\n");
		if ( root == null ){
			   writer.write("EMPTY BST\r\n");
		}else{
			root.inOrder(writer);
		}

	}
}