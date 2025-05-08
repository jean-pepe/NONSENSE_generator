package MaGiNiSo;

import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Token;

import java.io.IOException;
import java.util.*;

public class Analyzator {
		
	private LanguageServiceClient language;
	private Document doc;
	private AnalyzeSyntaxResponse sintax;
	private String sentence;
	private Map<String, List<String>> words;
	
	public Analyzator(String sentence) throws IOException {
		language = LanguageServiceClient.create();
        doc = Document.newBuilder().setContent(sentence).setType(Document.Type.PLAIN_TEXT).build();
        sintax = language.analyzeSyntax(doc);
        
        words = new HashMap<>();
        words.put("NOUN", new ArrayList<>());
        words.put("VERB", new ArrayList<>());
        words.put("ADJ", new ArrayList<>());
        
        for (Token token : sintax.getTokensList()) {
            String part = token.getPartOfSpeech().getTag().name();
            String word = token.getText().getContent();
            if (words.containsKey(part)) {
                words.get(part).add(word);
            }
        }
	}
	
	public void validateStructure(){
		//show in screen the Document doc
	}
	
	public List<String> getVerbs() {
		List<String> result = words.get("VERB");
		return Collections.unmodifiableList(result);
	}
	
	public List<String> getNouns() {
		List<String> result = words.get("NOUN");
		return Collections.unmodifiableList(result);
	}
	
	public List<String> getAdjectives() {
		List<String> result = words.get("ADJ");
		return Collections.unmodifiableList(result);
	}

	
}
