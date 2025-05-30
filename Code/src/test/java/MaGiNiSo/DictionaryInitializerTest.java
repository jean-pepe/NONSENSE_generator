package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DictionaryInitializerTest {

    @Autowired
    private DictionaryInitializer dictionaryInitializer;

    @Test
	@DisplayName("Dizionari inizializzati non nulli")
    void testDictionaryInitialization() {
	// Check if dictionaries are initialized
        assertNotNull(dictionaryInitializer.getDictionary("nouns"), "Il dizionario dei sostantivi non inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("verbsPresent"), "Il dizionario dei verbi presenti non inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("verbsPast"), "Il dizionario dei verbi passati non inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("verbsFuture"), "Il dizionario dei verbi futuri non inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("adjectives"), "Il dizionario degli aggettivi non inizializzato");
    }

    @Test
	@DisplayName("La richieste di dizionari non esistenti genera IllegalArgumentException")
    void testInvalidDictionaryRequest() {
	//Check if with invalid type throws an exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dictionaryInitializer.getDictionary("invalidType");
        });
        assertEquals("Unknown dictionary type: invalidType", exception.getMessage());
    }

    @Test
	@DisplayName("Le strutture delle frasi inizializzate non sono nulle")
    void testSentenceStructuresInitialization() {
	//Check if sentence structures are not null
        assertNotNull(dictionaryInitializer.getSentenceStructures(), "Le strutture delle frasi non inizializzate");
    }
}
