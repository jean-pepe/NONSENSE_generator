package MaGiNiSo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Dictionary {

	private List<String> dictionary;
    
    //Create the dictionary based on the file 
	public Dictionary(String source) {
    	try {
            dictionary = Files.readAllLines(Paths.get(source));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

   //This is the method for adding words/structures into the dictionary, that we have selected from the input sentence
   public void add(List<String> words){
	   for (String s : words){
		   dictionary.add(s);
	 }
   }

    //This method is for obtaining a new word, selecting it randomly from the dictionary
    public String get() {
    	Random rand = new Random();
        return dictionary.get(rand.nextInt(dictionary.size()));
    }
	
}
