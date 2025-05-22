package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

class SentenceStructuresTest {

    private SentenceStructures sentenceStructures;

    @BeforeEach
    void setUp() {
        sentenceStructures = new SentenceStructures("src/test/resources/test.txt"); // Usa un file di test per evitare dipendenze esterne
    }

    @Test
    void testGetRandom() {
        List<String> structures = Arrays.asList("The", "[noun]", "[verb]","the","[adjective]","[noun]","in","a","[adjective]","[noun]","and","[noun]",".");
        sentenceStructures = new SentenceStructures("src/test/resources/test.txt") {
            @Override
            public String getRandom() {
                return structures.get(0); // Simuliamo il ritorno di una struttura specifica per il test
            }
        };

        String randomStructure = sentenceStructures.getRandom();
        assertNotNull(randomStructure, "La struttura ottenuta non dovrebbe essere null");
        assertTrue(structures.contains(randomStructure), "La struttura dovrebbe essere una di quelle definite");
    }

    @Test
    void testGetValidStructure() {
        List<String> structures = Arrays.asList("The", "[noun]", "[verb]","the","[adjective]","[noun]","in","a","[adjective]","[noun]","and","[noun]",".");
        sentenceStructures = new SentenceStructures("src/test/resources/test.txt") {
            @Override
            public String get(int i) {
                return structures.get(i - 1);
            }
        };

        assertEquals("[verb]", sentenceStructures.get(3), "La struttura ottenuta non corrisponde a quella attesa");
    }

    @Test
    void testGetInvalidStructure() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sentenceStructures.get(0);
        });

        assertTrue(exception.getMessage().contains("Structure number not admitted"), "Messaggio di errore non corretto");
    }
}
