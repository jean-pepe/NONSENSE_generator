package MaGiNiSo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SentenceStructure {
	
	private static List<String> dictionaryStruc;
    private String randomStructure;
    
    public static void setDictionaryAdj() {
    	try {
            dictionaryStruc = Files.readAllLines(Paths.get("SentenceStructures.txt"));
            
            if (dictionaryStruc.isEmpty()) {
                throw new IllegalArgumentException("Empty file");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public SentenceStructure() {
    	Random rand = new Random();
        randomStructure = dictionaryStruc.get(rand.nextInt(dictionaryStruc.size()));
    }
    
    public String getStructure() {
    	return randomStructure;
    }
	
}


