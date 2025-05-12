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

    //Mehtod for creating the dictionary of Sentence Structures
    public static void setDictionaryStruc() {
    	try {
            dictionaryStruc = Files.readAllLines(Paths.get("SentenceStructures.txt"));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

   //Method for creating an object Sentence Structre, selecting a random structure from the dictionary
    public SentenceStructure() {
    	Random rand = new Random();
        randomStructure = dictionaryStruc.get(rand.nextInt(dictionaryStruc.size()));
    }

    //Method for getting the structure in the object
    public String getStructure() {
    	return randomStructure;
    }
	
}


