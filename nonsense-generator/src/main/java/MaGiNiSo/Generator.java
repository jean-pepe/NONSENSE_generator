package MaGiNiSo;

public class Generator {
			
	public static String generateSentence(String time) {
		
		//We select the dictionary of verbs that we are going to use for the rest of the function, and copy the reference
		Dictionary dicVerbs;
		if (time.equals("present")) {
        	dicVerbs = Program.VerbsPresent;
        } else if (time.equals("past")) {
        	dicVerbs = Program.VerbsPast;
        } else if (time.equals("future")) {
        	dicVerbs = Program.VerbsFuture;
        } else {
        	throw new IllegalArgumentException("Invalid verbal tense, tenses admitted: present/past/future");
        }
		
		//generate a random sentence structure
		String sentence = "";
		String structure = Program.SentenceStructures.get();
		
		//split the sentence structure and fill [noun] [verb] and [adjective] with random words
		String[] parts = structure.split("\\s+"); // split the structure by spaces
		for (String s : parts) {
			if (s.equals("[noun]")) {
				sentence += Program.Nouns.get();
			}
			else if (s.equals("[verb]")) {
				sentence += dicVerbs.get();
			}
			else if (s.equals("[adjective]")) {
				sentence += Program.Adjectives.get();
			}
			
			else if (s.equals("[noun].")) {
				sentence += Program.Nouns.get() + ".";
			}
			else if (s.equals("[verb].")) {
				sentence += dicVerbs.get() + ".";
			}
			else if (s.equals("[adjective].")) {
				sentence += Program.Adjectives.get() + ".";
			}
			
			else sentence += s;
			sentence += " ";
		}
		
		return sentence;
		
	}

}
