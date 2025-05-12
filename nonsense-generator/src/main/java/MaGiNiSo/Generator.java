package MaGiNiSo;

public class Generator {
			
	public static String generateSentence(String time) {
		
		//generate a random sentence structure
		String sentence = "";
		SentenceStructure struc = new SentenceStructure();
		String structure = struc.getStructure();
		
		//split the sentence structure and fill [noun] [verb] and [adjective] with random words
		String[] parts = structure.split("\\s+"); // split the structure by spaces
		Noun n;
		Verb v;
		Adjective a;
		for (String s : parts) {
			if (s.equals("[noun]")) {
				n = new Noun();
				sentence += n.getNoun();
			}
			else if (s.equals("[verb]")) {
				v = new Verb(time);
				sentence += v.getVerb();
			}
			else if (s.equals("[adjective]")) {
				a = new Adjective();
				sentence += a.getAdjective();
			}
			else sentence += s;
			sentence += " ";
		}
		
		return sentence;
		
	}

}
