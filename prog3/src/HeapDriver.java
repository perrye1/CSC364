import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class HeapDriver{
	
	public static void main(String[] args) throws IOException{
		
		//create a new BST
		Heap myHeap = new Heap();
		
		//file paths for the input and output files
		String inPath = "E:\\SchoolWork\\CSC364\\prog3\\IO\\inf1.txt";
		String outPath = "E:\\SchoolWork\\CSC364\\prog3\\IO\\outf1.txt";
		
		//create a new file reader and writer
		BufferedReader reader = new BufferedReader(new FileReader(inPath));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outPath, true));

		String line = null;
		
		//read in each line in the input file
		while ((line = reader.readLine()) != null) {
			
			//insert each value from the input file into the BST
			myHeap.insert(Integer.parseInt(line));
			
		}
	
		//print out the level order traversal
		if(myHeap.isEmpty()){
			writer.write("EMPTY HEAP");
		}else{
			while(!myHeap.isEmpty()){
				writer.write(Integer.toString(myHeap.deleteMin()));
			}
		}
		
		//close the file reader and writer
		reader.close();
		writer.close();
		
	}
	
}