import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class dequeDriver{
	
	public static void main(String[] args) throws IOException{
		
		deque myDeque = new deque();
		
		String inPath = "E:\\SchoolWork\\CSC364\\prog1\\IO\\inf5.txt";
		String outPath = "E:\\SchoolWork\\CSC364\\prog1\\IO\\outf5.txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(inPath));

		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] lineParts = line.split(" ");
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
	 
		reader.close();
		
	}
	
}