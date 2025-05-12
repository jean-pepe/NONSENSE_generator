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

    public Analyzator() {
        this.nouns = new ArrayList<>();
        this.verbs = new ArrayList<>();
        this.adjectives = new ArrayList<>();
    }

    public void analyzeSyntax(String sentence) throws IOException {
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
            }
        }
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
}
