package MaGiNiSo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public abstract class Word {

	private static List<String> dictionary;
    private String word;
    
    //Create the dictionary based on the file 
	protected static void createDictionary(String source) {
    	try {
            dictionary = Files.readAllLines(Paths.get(source));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

   //This is the method for adding nouns into the dictionary, that we have selected from the input sentence
   protected static void add(List<String> words){
	   for (String s : words){
		   dictionary.add(s);
	 }
   }

    //This method is for creating a new object (basically a word), selecting it randomly from the dictionary
    protected Word() {
    	Random rand = new Random();
        word = dictionary.get(rand.nextInt(dictionary.size()));
    }

   //Method for obtaining the noun of the Object
    public String get() {
    	return word;
    }
	
}
