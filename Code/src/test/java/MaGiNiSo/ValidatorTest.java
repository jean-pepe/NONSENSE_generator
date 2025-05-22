package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class ValidatorTest {
/*
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void testValidateSentenceWithValidContent() throws IOException {
        String sentence = "Hello, how are you?";
        String apiKey = "test_api_key";

        // Simuliamo una risposta JSON dell'API senza contenuti offensivi
        String jsonResponse = "{ \"moderationCategories\": [] }";

        String result = Validator.processResponse(jsonResponse);
        assertEquals("The phrase is valid and doesn't have offensive language.", result);
    }

    @Test
    void testValidateSentenceWithOffensiveContent() throws IOException {
        String sentence = "Some offensive words";
        String apiKey = "test_api_key";

        // Simuliamo una risposta JSON con contenuti offensivi
        String jsonResponse = "{ \"moderationCategories\": [{ \"name\": \"Hate Speech\", \"confidence\": 0.85 }] }";

        String result = Validator.processResponse(jsonResponse);
        assertTrue(result.contains("The frase has offensive content"), "Il messaggio dovrebbe segnalare contenuti offensivi.");
    }

    @Test
    void testValidateSentenceWithLowConfidenceOffensiveContent() throws IOException {
        String sentence = "Potentially offensive words";
        String apiKey = "test_api_key";

        // Simuliamo una risposta con bassa confidenza (<0.75)
        String jsonResponse = "{ \"moderationCategories\": [{ \"name\": \"Hate Speech\", \"confidence\": 0.50 }] }";

        String result = Validator.processResponse(jsonResponse);
        assertEquals("The phrase is valid and doesn't have offensive language.", result);
    }

    @Test
    void testProcessResponseWithNullCategories() {
        String jsonResponse = "{ \"moderationCategories\": null }";
        String result = Validator.processResponse(jsonResponse);
        assertEquals("The phrase is valid and doesn't have offensive language.", result);
    }*/
}
