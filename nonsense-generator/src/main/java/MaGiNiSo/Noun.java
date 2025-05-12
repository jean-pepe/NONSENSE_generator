package MaGiNiSo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Noun {
	
	private static List<String> dictionaryNoun;
    private String word;

    //Create the dictionary based on the file 
    public static void setDictionaryNoun() {
    	try {
            dictionaryNoun = Files.readAllLines(Paths.get("src/main/java/MaGiNiSo/Nouns.txt"));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

   //This is the method for adding nouns into the dictionary, that we have selected from the input sentence
   public static void addNouns(List<String> nouns){
	   for (String s : nouns){
		   dictionaryNoun.add(s);
	 }
   }

    //This method is for creating a new object Noun (basically a word), selecting it randomly from the dictionary
    public Noun() {
    	Random rand = new Random();
        word = dictionaryNoun.get(rand.nextInt(dictionaryNoun.size()));
    }

   //Method for obtaining the noun of the Object
    public String getNoun() {
    	return word;
    }
}
