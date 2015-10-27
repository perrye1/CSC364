import java.util.Arrays;

public class HashTable{
	
	private int tableSize;   // the size of the table
	private String [] table;  // the actual array of Strings

	// constructor for the HashTable. initializes the table to empty strings
	public HashTable(int size){
		tableSize = size;
		table = new String [size];
		Arrays.fill(table, "");
	}

	// hashes a word by adding up the ascii values of its characters
	public int hashFunc(String word){
		int hashAddress = 0;
		for(char c : word.toCharArray()){
			hashAddress= (hashAddress + (int)c) % 143;
		}
		return hashAddress;
	}
	
	// looks up a word in the hash table using quadratic probing
	public int lookup(String word){
		int hashAddress = hashFunc(word);
		int i = 1;
		while (!table[hashAddress].equals(word)) {
			hashAddress = ((hashAddress + (i * i)) % tableSize);
			if(table[hashAddress].equals("")){
				return -1;
			}
			i++;
		}
		return hashAddress;
	}

	// marks the given position with a special character to indicate that there was once a value there
	public void markNowEmpty(int position){
		table[position] = "####";
	}

	// inserts a word into the hash table using quadratic probing
	public void insert(String word) {
		int hashAddress = hashFunc(word);
		int i = 1;
		while (!table[hashAddress].equals("")) {
			hashAddress = ((hashAddress + (i * i)) % tableSize);
			i++;
		}
		table[hashAddress] = word;
	}

}