package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NonSenseServiceTest {

    private NonSenseService nonSenseService;
    private Analyzator mockAnalyzator;
    private Generator mockGenerator;
    private Validator mockValidator;

    @BeforeEach
    void setUp() {
        mockAnalyzator = Mockito.mock(Analyzator.class);
        mockGenerator = Mockito.mock(Generator.class);
        mockValidator = Mockito.mock(Validator.class);

        nonSenseService = new NonSenseService(mockAnalyzator, mockGenerator, mockValidator);
    }

    @Test
	@DisplayName("Verifica corretezza chiamata e parametri di Analyzator da parte di nonSenseService")
    void testAnalyzeSyntax() {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        String tense = "present";
        String apiKey = "test_api_key";

        // Verifica che il metodo venga chiamato correttamente
        nonSenseService.analyzeSyntax(sentence, tense, apiKey);
        Mockito.verify(mockAnalyzator).analyzeSyntax(sentence, tense, apiKey);
    }

    @Test
	@DisplayName("Verifichiamo che la frase generata sia uguale a quella attesa")
    void testGenerateSentence() {
        String expectedSentence = "The cat sleeps peacefully.";
        Mockito.when(mockGenerator.generateSentence("present", 0)).thenReturn(expectedSentence);

        String sentence = nonSenseService.generateSentence("present", 0);
        assertEquals(expectedSentence, sentence, "La frase generata non corrisponde a quella attesa.");
    }

    @Test
	@DisplayName("Verifichiamo che printSyntacticTree() restituisca il syntacticTree atteso.")
    void testPrintSyntacticTree() {
        String expectedTree = "The [noun] [verb] the [adjective] [noun] in a [adjective] [noun] and [noun].";
        Mockito.when(mockAnalyzator.getSyntacticTree()).thenReturn(expectedTree);

        String syntacticTree = nonSenseService.printSyntacticTree();
        assertEquals(expectedTree, syntacticTree, "L'albero sintattico generato non corrisponde a quello atteso.");
    }

    @Test
	@DisplayName("Verifica corretezza chiamata e parametri di Validator da parte di nonSenseService")
    void testValidateSentence() {
        String expectedValidation = "The phrase is valid and doesn't have offensive language.";
        Mockito.when(mockValidator.validateSentence("Hello world", "test_api_key")).thenReturn(expectedValidation);

        String validationResult = nonSenseService.validateSentence("Hello world", "test_api_key");
        assertEquals(expectedValidation, validationResult, "Il risultato della validazione della frase non corrisponde a quello atteso.");
    }
}
