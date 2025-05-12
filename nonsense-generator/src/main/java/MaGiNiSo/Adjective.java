package MaGiNiSo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Adjective {
	
	private static List<String> dictionaryAdj;
    private String word;

    //Method for creating the dictionary of Adjectives
    public static void setDictionaryAdj() {
    	try {
            dictionaryAdj = Files.readAllLines(Paths.get("src/main/java/MaGiNiSo/Adjectives.txt"));

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    //Method for adding adjectives from the input sentence to the dictionary
    public static void addAdjectives(List<String> adjectives){
	   for (String s : adjectives){
		   dictionaryAdj.add(s);
	 }
     }

    //Method for creating a new object Adjective, with a random word of the dictionary
    public Adjective() {
    	Random rand = new Random();
        word = dictionaryAdj.get(rand.nextInt(dictionaryAdj.size()));
    }

    //Method for getting the word saved in the object
    public String getAdjective() {
    	return word;
    }
}
