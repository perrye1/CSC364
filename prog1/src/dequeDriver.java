import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class dequeDriver{
	
	public static void main(String[] args) throws IOException{
		
		//create a new deque
		deque myDeque = new deque();
		
		//file paths for the input and output files
		String inPath = "E:\\SchoolWork\\CSC364\\prog1\\IO\\inf5.txt";
		String outPath = "E:\\SchoolWork\\CSC364\\prog1\\IO\\outf5.txt";
		
		//create a new file reader
		BufferedReader reader = new BufferedReader(new FileReader(inPath));

		String line = null;
		
		//read in each line in the input file
		while ((line = reader.readLine()) != null) {
			
			//split the line into the command and the data sections
			String[] lineParts = line.split(" ");
			
			//switch on the command section of the line
			switch (lineParts[0]){
				case "PR":	myDeque.printDeque(outPath);
					break;
				case "IF":	myDeque.insertFront(Integer.parseInt(lineParts[1]));
					break;
				case "IR":	myDeque.insertRear(Integer.parseInt(lineParts[1]));
					break;
				case "DF":	myDeque.deleteFront();
					break;
				case "DR":	myDeque.deleteRear();
					break;
			}
		}
		
		//close the file reader
		reader.close();
		
	}
	
}