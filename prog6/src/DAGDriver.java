import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAGDriver {
	public static void main(String[] args) throws IOException {

		String inPath = "E:\\SchoolWork\\CSC364\\prog6\\IO\\DAG.txt";

		// create new file reader and writers
		BufferedReader reader = new BufferedReader(new FileReader(inPath));

		// read in the number of vertices and number of edges
		int nv = Integer.parseInt(reader.readLine());
		int ne = Integer.parseInt(reader.readLine());
		String line = "";
		
		// create a new DAG object
		DAG myDAG = new DAG(nv); 

		// read in the edges and insert them into the graph
		while ((line = reader.readLine()) != null) {
			String[] values = line.split(" ");
			myDAG.setXY(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}
		
		// set the in degree, and run the topological sort algorithm on the graph, 
		//to find a sequence that satisfies the dependency relationships
		myDAG.setInDegree();
		myDAG.topologicalSort();
		
		// close the file reader
		reader.close();
	}
}