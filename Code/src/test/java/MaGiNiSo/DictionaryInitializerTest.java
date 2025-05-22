package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DictionaryInitializerTest {

    @Autowired
    private DictionaryInitializer dictionaryInitializer;

    @Test
    void testDictionaryInitialization() {
        assertNotNull(dictionaryInitializer.getDictionary("nouns"), "Il dizionario dei sostantivi dovrebbe essere inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("verbsPresent"), "Il dizionario dei verbi presenti dovrebbe essere inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("verbsPast"), "Il dizionario dei verbi passati dovrebbe essere inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("verbsFuture"), "Il dizionario dei verbi futuri dovrebbe essere inizializzato");
        assertNotNull(dictionaryInitializer.getDictionary("adjectives"), "Il dizionario degli aggettivi dovrebbe essere inizializzato");
    }

    @Test
    void testInvalidDictionaryRequest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dictionaryInitializer.getDictionary("invalidType");
        });
        assertEquals("Unknown dictionary type: invalidType", exception.getMessage());
    }

    @Test
    void testSentenceStructuresInitialization() {
        assertNotNull(dictionaryInitializer.getSentenceStructures(), "Le strutture delle frasi dovrebbero essere inizializzate");
    }
}
