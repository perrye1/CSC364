import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BST{
	
	protected BSTnode root;
	
	public BST(){
		root=null;
	}
	
	public void insert(int val){
		if(root == null){
			BSTnode temp = new BSTnode(val, 1);
			root=temp;
		}else{
			root.add(val, 2);
		}
	}
	
	public void levelOrder(BufferedWriter writer) throws IOException{
		Queue<BSTnode> Q = new LinkedList<BSTnode>();
		Q.add(root);
		while(!Q.isEmpty()){
			BSTnode temp = Q.remove();
			if(temp.getLeft() != null){
				Q.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				Q.add(temp.getRight());
			}
			writer.write(temp.getVal());
		}
	}
	
	public void inOrder(BufferedWriter writer) throws IOException{
		
		if ( root == null ){
			   writer.write("EMPTY BST");
		}else{
			root.inOrder(writer);
		}

	}
}