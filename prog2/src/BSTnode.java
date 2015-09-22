import java.io.BufferedWriter;
import java.io.IOException;

public class BSTnode {
	
	protected int val;
	BSTnode left;
	BSTnode right;
	int level;
	
	public BSTnode(int v, int lev){
		val=v;
		level=lev;
		right=null;
		left=null;
	}
	
	public int getVal(){
		return val;
	}
	
	public BSTnode getLeft(){
		return left;
	}
	
	public BSTnode getRight(){
		return right;
	}
	
	public void setLeft(BSTnode l){
		left=l;
	}
	
	public void setRight(BSTnode r){
		right=r;
	}
	
	public void add(int val, int lev){
		
		if (this.getVal() > val) {
			if (this.getLeft() == null) {
				BSTnode temp = new BSTnode(val, lev);
				this.setLeft(temp);
			} else {
				this.getLeft().add(val, lev+1);
			}
		} else {
			if (this.getRight() == null) {
				BSTnode temp = new BSTnode(val, lev);
				this.setRight(temp);
			} else {
				this.getRight().add(val, lev+1);
			}
		}
	}
	
	public void inOrder(BufferedWriter writer) throws IOException{
		if(this.getLeft() != null){
			this.getLeft().inOrder(writer);
		}
		writer.write(this.getVal());
		if(this.getRight() != null){
			this.getRight().inOrder(writer);
		}
	}
}