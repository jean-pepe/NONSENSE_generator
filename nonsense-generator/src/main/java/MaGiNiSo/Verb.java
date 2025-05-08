package MaGiNiSo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Verb {
	
	private static Map<String, List<String>> dictionaryVerb = new HashMap<>();
    private String word;
	
    public static void setDictionaryAdj() {
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader("Verbs.txt"))) {
    	    String line;
    	    while ((line = reader.readLine()) != null) {
    	        line = line.trim();
    	        if (line.isEmpty()) continue;

    	        String[] parts = line.split("\\s+", 2); // category and word
    	        if (parts.length == 2) {
    	            String category = parts[0].toLowerCase();
    	            String word = parts[1];

    	            dictionaryVerb.computeIfAbsent(category, k -> new ArrayList<>()).add(word);
    	        }
    	    }

    	    if (dictionaryVerb.isEmpty()) {
    	        throw new IllegalStateException("Empty file");
    	    }

    	} catch (IOException e) {
    	    System.err.println("Error reading file: " + e.getMessage());
    	}
    }
    
    public Verb(String time) {
    	Random rand = new Random();
    	List<String> lista = dictionaryVerb.get(time.toLowerCase());
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("Non valid time category: " + time);
        }
        word = lista.get(rand.nextInt(lista.size()));
    }
    
    public String getVerb() {
    	return word;
    }
}
