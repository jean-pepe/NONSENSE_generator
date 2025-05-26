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
        String sentence = "This is an offensive sentence!";
        String apiKey = "fake_api_key";

        // Simuliamo la risposta prevista per una frase offensiva
        Mockito.when(validator.validateSentence(sentence, apiKey))
               .thenReturn("The phrase has offensive content: Profanity (confidence: 0.90)");

        String result = validator.validateSentence(sentence, apiKey);

        assertNotNull(result);
        assertTrue(result.contains("offensive"));
    }

    @Test
    @DisplayName("Validator da un risultato non nullo e non offensivo")
    public void testValidateSentenceValid() {
        String sentence = "Hello, how are you?";
        String apiKey = "fake_api_key";

        // Simuliamo la risposta prevista per una frase valida
        Mockito.when(validator.validateSentence(sentence, apiKey))
               .thenReturn("The phrase is valid and doesn't have offensive language.");

        String result = validator.validateSentence(sentence, apiKey);

        assertNotNull(result);
        assertTrue(result.contains("valid"));
    }
}
