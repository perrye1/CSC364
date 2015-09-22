import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BSTmain{
	
	public static void main(String[] args) throws IOException{
		
		//create a new BST
		BST myBST = new BST();
		
		//file paths for the input and output files
		String inPath = "E:\\SchoolWork\\CSC364\\prog2\\IO\\inf1.txt";
		String outPath = "E:\\SchoolWork\\CSC364\\prog2\\IO\\outf1.txt";
		
		//create a new file reader and writer
		BufferedReader reader = new BufferedReader(new FileReader(inPath));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outPath, true));

		String line = null;
		
		//read in each line in the input file
		while ((line = reader.readLine()) != null) {
			
			//insert each value from the input file into the BST
			myBST.insert(Integer.parseInt(line));
			
		}
	
		//print out the level order traversal
		myBST.levelOrder(writer);
		
		//print out the in order traversal
		myBST.inOrder(writer);
		
		//close the file reader and writer
		reader.close();
		writer.close();
		
	}
	
}