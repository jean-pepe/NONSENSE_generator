package MaGiNiSo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;


class DictionaryTest {

    private Dictionary dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new Dictionary("src/test/resources/test.txt");
    }
	
    @Test
    @DisplayName("Aggiunta e recupero parola")
    void testAddWords() {
        // Add words and check if present
	List<String> words = Arrays.asList("sky", "moon", "earth");
        dictionary.add(words);
        String word = dictionary.get();
        assertTrue(words.contains(word), "La parola ottenuta non e' presente tra quelle aggiunte");
    }
	
	@Test
	@DisplayName("Conferma che il dizionario contenga parole una volta che vengono aggiunte")
    void testGetRandomWord() {
	// Check if dictionary is not null
        dictionary.add(Arrays.asList("sky", "moon", "earth"));
        String word = dictionary.get();
        assertNotNull(word, "La parola e' nulla");
    }
	
}
