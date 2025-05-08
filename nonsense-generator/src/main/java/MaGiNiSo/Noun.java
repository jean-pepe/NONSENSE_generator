package MaGiNiSo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Noun {
	
	private static List<String> dictionaryNoun;
    private String word;
	
    public static void setDictionaryAdj() {
    	try {
            dictionaryNoun = Files.readAllLines(Paths.get("Nouns.txt"));
            
            if (dictionaryNoun.isEmpty()) {
                throw new IllegalArgumentException("Empty file");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public Noun() {
    	Random rand = new Random();
        word = dictionaryNoun.get(rand.nextInt(dictionaryNoun.size()));
    }
    
    public String getNoun() {
    	return word;
    }
}
