import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class McstDriver {
	public static void main(String[] args) throws IOException {

		String inPath = "E:\\SchoolWork\\CSC364\\prog5\\IO\\graph.txt";

		// create new file reader and writers
		BufferedReader reader = new BufferedReader(new FileReader(inPath));

		int nv = Integer.parseInt(reader.readLine());
		int ne = Integer.parseInt(reader.readLine());
		String line = "";
		
		McstGraph myGraph = new McstGraph(nv); 

		while ((line = reader.readLine()) != null) {
			String[] values = line.split(" ");
			myGraph.insert(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
		}
		
		System.out.println("Number of vertices is " + myGraph.getNumVertices());
		int totalCost = myGraph.primsAlg();
		System.out.println("Total cost of MCST is " + totalCost );
		
		// close the file reader
		reader.close();
	}
}