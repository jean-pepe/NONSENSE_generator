package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

class AnalyzatorTest {

    private Analyzator analyzator;
    private DictionaryInitializer mockDictionaryInitializer;

    @BeforeEach
    void setUp() {
        mockDictionaryInitializer = Mockito.mock(DictionaryInitializer.class);
        analyzator = new Analyzator(mockDictionaryInitializer);
    }

    @Test
	@DisplayName("analyzeSyntax() con un input valido non manda eccezioni")
    void testAnalyzeSyntaxWithValidInput() {

        String sentence = "The sky is blue.";
        String time = "present";
        String apiKey = "test_api_key";

        // Start of syntax analysis
	// Check if with valid input does not throw exceptions
        assertDoesNotThrow(() -> analyzator.analyzeSyntax(sentence, time, apiKey));

        List<String> nouns = analyzator.getNouns();
        List<String> verbs = analyzator.getVerbs();
        List<String> adjectives = analyzator.getAdjectives();

	// Check if they are not null
        assertNotNull(nouns, "La lista dei sostantivi non dovrebbe essere nulla");
        assertNotNull(verbs, "La lista dei verbi non dovrebbe essere nulla");
        assertNotNull(adjectives, "La lista degli aggettivi non dovrebbe essere nulla");
    }

    @Test
	@DisplayName("analyzeSyntax() con un tempo invalido manda eccezioni")
    void testInvalidVerbalTense() {
        // Check if with invalid tense throws exception
	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            analyzator.analyzeSyntax("The sky is blue.", "invalid_tense", "test_api_key");
        });

        assertEquals("Invalid verbal tense. Accepted: present/past/future", exception.getMessage());
    }

    @Test
	@DisplayName("analyzeSyntax() genera un SyntacticTree non nullo")
    void testSyntacticTreeFormat() {
        String syntacticTree = analyzator.getSyntacticTree();

	// Check if syntactic tree is not null
        assertNotNull(syntacticTree, "L'albero sintattico è nullo");
	// Check if it contains noun and verb categories
        assertTrue(syntacticTree.contains("NOUN"), "Non contiene la categoria NOUN");
        assertTrue(syntacticTree.contains("VERB"), "Non contiene la categoria VERB");
    }
}
