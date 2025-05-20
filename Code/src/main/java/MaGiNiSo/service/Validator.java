package MaGiNiSo.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Validator {
	
	// We construct both API and JSON request and receive the answer of how offensive the generated sentence is.
	public String validateSentence(String sentence, String apiKey) {
    	try {
	        String urlString = "https://language.googleapis.com/v1/documents:moderateText?key=" + apiKey;
	
	        String jsonInputString = "{" + "\"document\": {" + "\"type\": \"PLAIN_TEXT\"," + "\"content\": \"" + sentence + "\"" + "}" + "}";
	
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
	        return processResponse(response.toString());
    	}
    	catch (IOException e) {
    		System.err.println("Error connecting to the API server " + e.getMessage());
    		return null;
    	}
    }
    
    // Function to verify if a sentence valid and has no (few) offensive language.  
    private static String processResponse(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray categories = jsonObject.optJSONArray("moderationCategories");

        if (categories == null || categories.isEmpty()) {
            return "The phrase is valid and doesn't have offensive language.";
        }

        // To verify if there is offensive language in any category.
        for (int i = 0; i < categories.length(); i++) {
            JSONObject category = categories.getJSONObject(i);
            double confidence = category.optDouble("confidence", 0.0);
            String name = category.optString("name", "Unknown");

            if (confidence > 0.75) {
                return "The frase has offensive content: " + name + " (confidence: " + confidence + ")";
            }
        }
        return "The phrase is valid and doesn't have offensive language.";
    }
}
