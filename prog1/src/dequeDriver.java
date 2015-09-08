import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class dequeDriver{
	
	public static void main() throws IOException{
		
		deque myDeque = new deque();
		
		String inPath = "E:\\SchoolWork\\CSC364\\prog1\\IO\\inf1.txt";
		String outPath = "E:\\SchoolWork\\CSC364\\prog1\\IO\\outf1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(inPath));

		String line = null;
		while ((line = br.readLine()) != null) {
			String[] lineParts = line.split(" ");
			switch (lineParts[0]){
				case "PR":
					myDeque.printDeque(outPath);
				case "IF":
					myDeque.insertFront(Integer.parseInt(lineParts[1]));
				case "IR":
					myDeque.insertRear(Integer.parseInt(lineParts[1]));
				case "DF":
					myDeque.deleteFront();
				case "DR":
					myDeque.deleteRear();
			}
		}
	 
		br.close();
		
	}
	
}