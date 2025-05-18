package MaGiNiSo.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Analyzator {
    
    private final DictionaryInitializer dictionaryInitializer;
    
    private List<String> nouns;
    private List<String> verbs;
    private List<String> adjectives;
    private List<String> adverbs;
    private List<String> conjunction;
    private List<String> determinant;
    private List<String> pronouns;
    private List<String> punctuation;
    private List<String> number;
    private List<String> preposition;
    private List<String> particle;
    private List<String> other;
    private List<String> unknown;

    public Analyzator(DictionaryInitializer dictionaryInitializer) {
        this.nouns = new ArrayList<>();
        this.verbs = new ArrayList<>();
        this.adjectives = new ArrayList<>();
        this.adverbs = new ArrayList<>();
        this.conjunction = new ArrayList<>();
        this.determinant = new ArrayList<>();
        this.pronouns = new ArrayList<>();
        this.punctuation = new ArrayList<>();
        this.number = new ArrayList<>();
        this.preposition = new ArrayList<>();
        this.particle = new ArrayList<>();
        this.other = new ArrayList<>();
        this.unknown = new ArrayList<>();
        this.dictionaryInitializer = dictionaryInitializer;
    }

    public void analyzeSyntax(String sentence, String time, String apiKey) {
    	Dictionary dicVerbs;
    	
    	//We select the dictionary of verbs that we are going to use, and copy the reference
    	if (time.equals("present")) {
            dicVerbs = dictionaryInitializer.getDictionary("verbsPresent");
        } else if (time.equals("past")) {
            dicVerbs = dictionaryInitializer.getDictionary("verbsPast");
        } else if (time.equals("future")) {
            dicVerbs = dictionaryInitializer.getDictionary("verbsFuture");
        } else {
            throw new IllegalArgumentException("Invalid verbal tense. Accepted: present/past/future");
        }
    	
    	// We construct both API and JSON request and receive the answer of the analysis of the input sentence. Finally we add the words to our dictionaries.
    	try {
	        String urlString = "https://language.googleapis.com/v1/documents:analyzeSyntax?key=" + apiKey;
	
	        String jsonInputString = "{" + "\"document\": {" + "\"type\": \"PLAIN_TEXT\"," + "\"content\": \"" + sentence + "\"" + "}," + "\"encodingType\": \"UTF8\"" + "}";
	
	        URL url = new URL(urlString);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	
	        try (OutputStream os = conn.getOutputStream()) {
	            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
	            os.write(input, 0, input.length);
	        }
	
	        StringBuilder response = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
	            String responseLine;
	            while ((responseLine = br.readLine()) != null) {
	                response.append(responseLine.trim());
	            }
	        }
	
	        processResponse(response.toString());
	        
	        dictionaryInitializer.getDictionary("nouns").add(nouns);
	        dictionaryInitializer.getDictionary("adjectives").add(adjectives);
	        dicVerbs.add(verbs);
	        
    	} catch (IOException e) {
    		System.err.println("Error connecting to the API " + e.getMessage());
    	}
    }

    private void processResponse(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray tokens = jsonObject.getJSONArray("tokens");

        // We iterate for each token and we add it to its category
        for (int i = 0; i < tokens.length(); i++) {
            JSONObject token = tokens.getJSONObject(i);
            String word = token.getJSONObject("text").getString("content");
            String category = token.getJSONObject("partOfSpeech").getString("tag");
            switch (category) {
                case "NOUN":
                    nouns.add(word);
                    break;
                case "VERB":
                    verbs.add(word);
                    break;
                case "ADJ":
                    adjectives.add(word);
                    break;
                case "ADV":
                    adverbs.add(word);
                    break;
                case "CONJ":
                    conjunction.add(word);
                    break;
                case "DET":
                    determinant.add(word);
                    break;
                case "PRON":
                    pronouns.add(word);
                    break;
                case "PUNCT":
                    punctuation.add(word);
                    break;
                case "NUM":
                    number.add(word);
                    break;
                case "ADP":
                    preposition.add(word);
                    break;
                case "PRT":
                    particle.add(word);
                    break;
                case "X":
                    other.add(word);
                    break;
                case "UNKNOWN":
                    unknown.add(word);
                    break;
            }
        }
    }
    
    public String getSyntacticTree() {
    	StringBuilder tree = new StringBuilder();
        tree.append("NOUN: ").append(getNouns()).append("\n");
        tree.append("VERB: ").append(getVerbs()).append("\n");
        tree.append("ADJECTIVE: ").append(getAdjectives()).append("\n");
        tree.append("ADV: ").append(getAdverbs()).append("\n");
        tree.append("CONJ: ").append(getConjunction()).append("\n");
        tree.append("PRON: ").append(getPronouns()).append("\n");
        tree.append("PUNCT: ").append(getPunctuation()).append("\n");
        tree.append("NUM: ").append(getNumber()).append("\n");
        tree.append("PREPOSITION: ").append(getPreposition()).append("\n");
        tree.append("PRT: ").append(getParticle()).append("\n");
        tree.append("X: ").append(getOther()).append("\n");
        tree.append("UNKNOWN: ").append(getUnknown()).append("\n");
        
        return tree.toString();
    }
    
    public List<String> getNouns() {
        return Collections.unmodifiableList(nouns);
    }

    public List<String> getVerbs() {
        return Collections.unmodifiableList(verbs);
    }

    public List<String> getAdjectives() {
        return Collections.unmodifiableList(adjectives);
    }
    
    public List<String> getAdverbs() {
        return Collections.unmodifiableList(adverbs);
    }

    public List<String> getConjunction() {
        return Collections.unmodifiableList(conjunction);
    }

    public List<String> getDeterminant() {
        return Collections.unmodifiableList(determinant);
    }
    
    public List<String> getPronouns() {
        return Collections.unmodifiableList(pronouns);
    }

    public List<String> getPunctuation() {
        return Collections.unmodifiableList(punctuation);
    }

    public List<String> getNumber() {
        return Collections.unmodifiableList(number);
    }
    public List<String> getPreposition() {
        return Collections.unmodifiableList(preposition);
    }
    
    public List<String> getParticle() {
        return Collections.unmodifiableList(particle);
    }

    public List<String> getOther() {
        return Collections.unmodifiableList(other);
    }

    public List<String> getUnknown() {
        return Collections.unmodifiableList(unknown);
    }
	
}
