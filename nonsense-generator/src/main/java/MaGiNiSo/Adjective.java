package MaGiNiSo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Adjective {
	
	private static List<String> dictionaryAdj;
    private String word;
	
    public static void setDictionaryAdj() {
    	try {
            dictionaryAdj = Files.readAllLines(Paths.get("Adjectives.txt"));
            
            if (dictionaryAdj.isEmpty()) {
                throw new IllegalArgumentException("Empty file");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public Adjective() {
    	Random rand = new Random();
        word = dictionaryAdj.get(rand.nextInt(dictionaryAdj.size()));
    }
    
    public String getAdjective() {
    	return word;
    }
}
