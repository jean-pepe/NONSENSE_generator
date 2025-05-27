package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GeneratorTest {

    private Generator generator;
    private DictionaryInitializer mockDictionaryInitializer;
    private Dictionary mockDictionary;

    @BeforeEach
    void setUp() {
        mockDictionaryInitializer = Mockito.mock(DictionaryInitializer.class);
        mockDictionary = Mockito.mock(Dictionary.class);

        // Simuliamo il comportamento dei dizionari
        Mockito.when(mockDictionaryInitializer.getDictionary("nouns")).thenReturn(mockDictionary);
        Mockito.when(mockDictionaryInitializer.getDictionary("verbsPresent")).thenReturn(mockDictionary);
        Mockito.when(mockDictionaryInitializer.getDictionary("verbsPast")).thenReturn(mockDictionary);
        Mockito.when(mockDictionaryInitializer.getDictionary("verbsFuture")).thenReturn(mockDictionary);
        Mockito.when(mockDictionaryInitializer.getDictionary("adjectives")).thenReturn(mockDictionary);
        Mockito.when(mockDictionary.get()).thenReturn("test_word");

        // Simuliamo le strutture di frase
        SentenceStructures mockSentenceStructures = Mockito.mock(SentenceStructures.class);
        Mockito.when(mockSentenceStructures.getRandom()).thenReturn("[noun] [verb] [adjective].");
        Mockito.when(mockSentenceStructures.get(0)).thenReturn("[noun] [verb] [adjective].");
        Mockito.when(mockDictionaryInitializer.getSentenceStructures()).thenReturn(mockSentenceStructures);

        generator = new Generator(mockDictionaryInitializer);
    }

    @Test
	@DisplayName("La sentence generata non e' nulla e le sue parole appartengono ai dizionari")
    void testGenerateSentenceWithValidTense() {
        String sentence = generator.generateSentence("present", 0);
        assertNotNull(sentence, "La frase generata è nulla");
        assertTrue(sentence.contains("test_word"), "La frase generata non contiene la parola del test");
    }

    @Test
	@DisplayName("Generate manda un eccezione se il tempo verbale non valido.")
    void testGenerateSentenceWithInvalidTense() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            generator.generateSentence("invalid_tense", 0);
        });

        assertEquals("Invalid verbal tense, accepted tenses: present/past/future", exception.getMessage());
    }

    @Test
	@DisplayName("Sentence generata con la giusta struttura")
    void testGenerateSentenceWithSpecificStructure() {
        String sentence = generator.generateSentence("past", 0);
        assertNotNull(sentence, "La frase generata è nulla");
        assertTrue(sentence.contains("test_word"), "La frase non contiene la parola del test");
    }
}
