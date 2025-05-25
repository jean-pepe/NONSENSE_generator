package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
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
    void testAnalyzeSyntaxWithValidInput() {
        // Simuliamo una frase e chiamiamo il metodo
        String sentence = "The cat sleeps on the mat.";
        String time = "present";
        String apiKey = "test_api_key";

        // Eseguiamo l'analisi sintattica (senza chiamare l'API reale)
        assertDoesNotThrow(() -> analyzator.analyzeSyntax(sentence, time, apiKey));

        List<String> nouns = analyzator.getNouns();
        List<String> verbs = analyzator.getVerbs();
        List<String> adjectives = analyzator.getAdjectives();

        assertNotNull(nouns, "La lista dei sostantivi non dovrebbe essere nulla");
        assertNotNull(verbs, "La lista dei verbi non dovrebbe essere nulla");
        assertNotNull(adjectives, "La lista degli aggettivi non dovrebbe essere nulla");
    }

    @Test
    void testInvalidVerbalTense() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            analyzator.analyzeSyntax("Test sentence", "invalid_tense", "test_api_key");
        });

        assertEquals("Invalid verbal tense. Accepted: present/past/future", exception.getMessage());
    }

    @Test
    void testSyntacticTreeFormat() {
        String syntacticTree = analyzator.getSyntacticTree();

        assertNotNull(syntacticTree, "L'albero sintattico non dovrebbe essere nullo");
        assertTrue(syntacticTree.contains("NOUN"), "Dovrebbe contenere la categoria NOUN");
        assertTrue(syntacticTree.contains("VERB"), "Dovrebbe contenere la categoria VERB");
    }
}
