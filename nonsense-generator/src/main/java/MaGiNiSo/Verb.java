package MaGiNiSo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Verb {
	
    private static Map<String, List<String>> dictionaryVerb = new HashMap<>();
    private String word;

    //Method for setting the diccionary
    public static void setDictionaryVerb() {
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader("Verbs.txt"))) {
    	    String line;
	    //reading each line of the file. Structure: "category verb"
    	    while ((line = reader.readLine()) != null) {
    	        line = line.trim();
    	        if (line.isEmpty()) continue;

    	        String[] parts = line.split("\\s+", 2); // category and word
    	        if (parts.length == 2) {
    	            String category = parts[0].toLowerCase();
    	            String word = parts[1];
		    //adding the verbs to the dictionary
		    //if the category of the verbal tense does not exist, we inizialice it (create a new ArrayList, or add to the existing ArrayList)
    	            dictionaryVerb.computeIfAbsent(category, k -> new ArrayList<>()).add(word);
    	        }
    	    }
    	} catch (IOException e) {
    	    System.err.println("Error reading file: " + e.getMessage());
    	}
    }

    //Method for adding the verbs form the input sentence to the Dictionary. 
    //It clasifies them depending on the verbal tense.
    public static addVerbs(List<String> verbs, String time){
    	If (time != "past" && time != "future" && time != "present") 
	    throw new IllegalArgumentException("Verbal tense non admitted. Admitted tenses: past, present, future");
	    
         for (String s : verbs){
		   dictionaryVerb.put(tempo, s);
	 }
      }

    //Constructor of an object Verb (=selecting a random verb basically, in the tense selected)
    public Verb(String time) {
	//Here, as we are the ones asking it sould be a correct tense... But is never too much to check it :)
	If (time != "past" && time != "future" && time != "present") 
	    throw new IllegalArgumentException("Verbal tense non admitted. Admitted tenses: past, present, future");
	    
    	Random rand = new Random();
    	List<String> lista = dictionaryVerb.get(time.toLowerCase());
        word = lista.get(rand.nextInt(lista.size()));
    }

    //show the verb
    public String getVerb() {
    	return word;
    }
}
