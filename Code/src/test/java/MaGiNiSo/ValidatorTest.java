package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ValidatorTest {

    @Mock
    private Validator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Validator da un risultato non nullo e offensivo")
    public void testValidateSentenceOffensive() {
        String sentence = "This is an offensive sentence";
        String apiKey = "fake_api_key";

        // Mock answer to an offensive sentence
        Mockito.when(validator.validateSentence(sentence, apiKey))
               .thenReturn("The phrase has offensive content: Profanity (confidence: 0.90)");

        String result = validator.validateSentence(sentence, apiKey);

        // Check if result is not null
        assertNotNull(result);
        // Check if result is offensive
        assertTrue(result.contains("offensive"));
    }

    @Test
    @DisplayName("Validator da un risultato non nullo e non offensivo")
    public void testValidateSentenceValid() {
        String sentence = "This is a valid sentence";
        String apiKey = "fake_api_key";

        // Mock answer to a valid sentence
        Mockito.when(validator.validateSentence(sentence, apiKey))
               .thenReturn("The phrase is valid and doesn't have offensive language.");

        String result = validator.validateSentence(sentence, apiKey);

        // Check if result is not null
        assertNotNull(result);
        // Check if result is valid
        assertTrue(result.contains("valid"));
    }
}
