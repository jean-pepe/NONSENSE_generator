package MaGiNiSo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DictionaryInitializer {

    private Dictionary nouns;
    private Dictionary verbsPresent;
    private Dictionary verbsPast;
    private Dictionary verbsFuture;
    private Dictionary adjectives;
    private SentenceStructures sentenceStructures;

    @PostConstruct
    public void init() {
        nouns = new Dictionary("src/main/resources/Nouns.txt");
        verbsPresent = new Dictionary("src/main/resources/VerbsPresent.txt");
        verbsPast = new Dictionary("src/main/resources/VerbsPast.txt");
        verbsFuture = new Dictionary("src/main/resources/VerbsFuture.txt");
        adjectives = new Dictionary("src/main/resources/Adjectives.txt");
        sentenceStructures = new SentenceStructures("src/main/resources/SentenceStructures.txt");
    }

    public Dictionary getDictionary(String type) {
        return switch (type) {
            case "nouns" -> nouns;
            case "verbsPresent" -> verbsPresent;
            case "verbsPast" -> verbsPast;
            case "verbsFuture" -> verbsFuture;
            case "adjectives" -> adjectives;
            default -> throw new IllegalArgumentException("Unknown dictionary type: " + type);
        };
    }
    
    public SentenceStructures getSentenceStructures() {
        return sentenceStructures;
    }
}
