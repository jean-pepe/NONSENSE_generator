package MaGiNiSo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Analyzator {

    private static final String API_KEY = "AIzaSyC7YZO32MGS-jqo103fDBK-yDZJXPPOFe8"; 

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

    public Analyzator() {
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
    }

    public void analyzeSyntax(String sentence, String time) {
    	
    	//We select the dictionary of verbs that we are going to use, and copy the reference
		Dictionary dicVerbs;
    	if (time.equals("present")) {
           	dicVerbs = Program.verbsPresent;
        } else if (time.equals("past")) {
           	dicVerbs = Program.verbsPast;
        } else if (time.equals("future")) {
           	dicVerbs = Program.verbsFuture;
        } else {
           	throw new IllegalArgumentException("Invalid verbal tense, tenses admitted: present/past/future");
        }
    	
    	try {
	        String urlString = "https://language.googleapis.com/v1/documents:analyzeSyntax?key=" + API_KEY;
	
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
	        
	        Program.nouns.add(nouns);
	        Program.adjectives.add(adjectives);
	        dicVerbs.add(verbs);
	        
    	} catch (IOException e) {
    		System.err.println("Error connecting to the API " + e.getMessage());
    	}
    }

    private void processResponse(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray tokens = jsonObject.getJSONArray("tokens");

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
    
    public void printSyntacticTree() {
    	System.out.println("The syntactic tree is:");
        System.out.println("NOUN: " + getNouns());
        System.out.println("VERB: " + getVerbs());
        System.out.println("ADJECTIVE: " + getAdjectives());
        System.out.println("ADV: " + getAdverbs());
        System.out.println("CONJ: " + getConjunction());
        System.out.println("PRON: " + getPronouns());
        System.out.println("PUNCT: " + getPunctuation());
        System.out.println("NUM: " + getNumber());
        System.out.println("PREPOSITION: " + getPreposition());
        System.out.println("PRT: " + getParticle());
        System.out.println("X: " + getOther());
        System.out.println("UNKNOWN: " + getUnknown());
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
