import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HashDriver {

	public static void main(String[] args) throws IOException {

		// create a new HashTable
		HashTable myTable = new HashTable(143);

		// file paths for the input and output files
		String inPath = "E:\\SchoolWork\\CSC364\\prog4\\IO\\inf1.txt";
		String inPath2 = "E:\\SchoolWork\\CSC364\\prog4\\IO\\inf2.txt";
		String outPath = "E:\\SchoolWork\\CSC364\\prog4\\IO\\outf1.txt";

		// create new file readers and writers
		BufferedReader reader = new BufferedReader(new FileReader(inPath));
		BufferedReader reader2 = new BufferedReader(new FileReader(inPath2));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outPath, true));

		String line = null;
		ArrayList<String> commonWords = new ArrayList<String>();
		ArrayList<String> uniqueWords = new ArrayList<String>();

		// read in each line in the input file, strip out punctuation and words shorter than
		// 3 characters, then add it to the hash table only if it is unique. 
		while ((line = reader.readLine()) != null) {
			String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for (String w : words) {
				if (w.length() >= 3 && !uniqueWords.contains(w)) {
					myTable.insert(w);
					uniqueWords.add(w);
				}
			}
		}
		
		// read in each line in the input file, strip out punctuation and words shorter than
		// 3 characters, then look it up in the hash table and mark the location where it was found
		// with a special character.
		while ((line = reader2.readLine()) != null) {
			String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for (String w : words) {
				if (w.length() >= 3) {
					int foundpos = myTable.lookup(w);
					if (foundpos >= 0) {
						commonWords.add(w);
						myTable.markNowEmpty(foundpos);
					}
				}
			}
		}

		// sort the array of common words alphabetically 
		Collections.sort(commonWords);
		
		// write out all the common words to the output file
		for(String w : commonWords){
			writer.write(w + "\r\n");
		}
		
		// close the file readers and writers
		reader.close();
		reader2.close();
		writer.close();

	}
}