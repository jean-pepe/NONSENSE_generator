package MaGiNiSo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class SentenceStructures {
	
private List<String> structures;
    
    //Create the dictionary based on the file 
	public SentenceStructures(String source) {
    	try {
            structures = Files.readAllLines(Paths.get(source));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    //This method is for obtaining a new word, selecting it randomly from the dictionary
    public String getRandom() {
    	Random rand = new Random();
        return structures.get(rand.nextInt(structures.size()));
    }
    
    //Method for printing all the structures in the list
    public void printStructures() {
    	for (int i = 1; i <= structures.size(); i++) {
    		System.out.println(i + structures.get(i-1));
    	}
    }
    
    //Method for getting the selected structure
    public String get(int i) {
    	if (i <= 0 || i > structures.size())
    		throw new IllegalArgumentException("Structure number not admitted. Admitted range: [0," + structures.size());
    	return structures.get(i-1);
    }
	
}
