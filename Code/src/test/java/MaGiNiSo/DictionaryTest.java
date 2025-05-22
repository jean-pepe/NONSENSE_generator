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
    @DisplayName("Aggiunta e recupero definizione")
    void testAddWords() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        dictionary.add(words);

        String word = dictionary.get();
        assertTrue(words.contains(word), "La parola ottenuta dovrebbe essere tra quelle aggiunte");
    }
	
	@Test
    void testGetRandomWord() {
        dictionary.add(Arrays.asList("hello", "world", "test"));
        String word = dictionary.get();
        assertNotNull(word, "La parola ottenuta non dovrebbe essere null");
    }

}
