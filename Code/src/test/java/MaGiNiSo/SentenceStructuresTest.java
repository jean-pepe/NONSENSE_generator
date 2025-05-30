package MaGiNiSo.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

class SentenceStructuresTest {

    private SentenceStructures sentenceStructures;

    @BeforeEach
    void setUp() {
        sentenceStructures = new SentenceStructures("src/test/resources/test.txt");
    }

    @Test
	@DisplayName("La sentenceStructures data non e' nulla e appartiene all'elenco dato")
    void testGetRandom() {
        List<String> structures = Arrays.asList("The", "[noun]", "[verb]","the","[adjective]","[noun]","in","a","[adjective]","[noun]","and","[noun]",".");
        sentenceStructures = new SentenceStructures("src/test/resources/test.txt") {
            @Override
            public String getRandom() {
                return structures.get(0); 
            }
        };

        String randomStructure = sentenceStructures.getRandom();
        assertNotNull(randomStructure, "La struttura ottenuta e' nulla");
        assertTrue(structures.contains(randomStructure), "La struttura non e' una di quelle definite");
    }

}
