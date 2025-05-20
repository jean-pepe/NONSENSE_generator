package MaGiNiSo.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Generator {
	
	private final DictionaryInitializer dictionaryInitializer;

    public Generator(DictionaryInitializer dictionaryInitializer) {
        this.dictionaryInitializer = dictionaryInitializer;
    }
			
	public String generateSentence(String time, int numStructure) {
		
		//We select the dictionary of verbs that we are going to use for the rest of the function, and copy the reference
		Dictionary dicVerbs;
		if (time.equals("present")) {
            dicVerbs = dictionaryInitializer.getDictionary("verbsPresent");
        } else if (time.equals("past")) {
            dicVerbs = dictionaryInitializer.getDictionary("verbsPast");
        } else if (time.equals("future")) {
            dicVerbs = dictionaryInitializer.getDictionary("verbsFuture");
        } else {
            throw new IllegalArgumentException("Invalid verbal tense, accepted tenses: present/past/future");
        }
		
		//generate a random sentence structure
		String sentence = "";
		String structure;
	    if (numStructure == 0) {
	        structure = dictionaryInitializer.getSentenceStructures().getRandom();
	    } else {
	        structure = dictionaryInitializer.getSentenceStructures().get(numStructure);
	    }
		
		//split the sentence structure and fill [noun] [verb] and [adjective] with random words
		String[] parts = structure.split("\\s+"); // split the structure by spaces
		for (String s : parts) {
			if (s.equals("[noun]")) {
                sentence += dictionaryInitializer.getDictionary("nouns").get();
            } else if (s.equals("[verb]")) {
                sentence += dicVerbs.get();
            } else if (s.equals("[adjective]")) {
                sentence += dictionaryInitializer.getDictionary("adjectives").get();
            } else if (s.equals("[noun].")) {
                sentence += dictionaryInitializer.getDictionary("nouns").get() + ".";
            } else if (s.equals("[verb].")) {
                sentence += dicVerbs.get() + ".";
            } else if (s.equals("[adjective].")) {
                sentence += dictionaryInitializer.getDictionary("adjectives").get() + ".";
            } else {
                sentence += s;
            }
            sentence += " ";
        }
		
		//Save the new sentence and it's morphology (structure) in a txt file (bucket)
		Path outputPath = Paths.get("src/main/java/MaGiNiSo/Output.txt");
		List<String> output = List.of("Structure: " + structure, "Sentence: " + sentence);
		try {
			//We write our new sentence in the file if the file exists, we create it if it does not exist
			//This way we can save in the same file all the new sentences
			Files.write(outputPath, output, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch(IOException e) {
			System.err.println("Error writing file: " + e.getMessage());
		}
		
		return sentence;
		
	}

}
