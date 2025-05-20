package MaGiNiSo.service;

import org.springframework.stereotype.Service;

@Service
public class NonSenseService {

    private final Analyzator analyzator;
    private final Generator generator;
    private final Validator validator;

    public NonSenseService(Analyzator analyzator, Generator generator, Validator validator) {
        this.analyzator = analyzator;
        this.generator = generator;
        this.validator = validator;
    }

    public void analyzeSyntax(String sentence, String tense, String apiKey) {
        analyzator.analyzeSyntax(sentence, tense, apiKey);
    }

    public String generateSentence(String tense, int numStructure) {
        return generator.generateSentence(tense, numStructure);
    }

    public String printSyntacticTree() {
        return analyzator.getSyntacticTree();
    }

    public String validateSentence(String sentence, String apiKey) {
        return validator.validateSentence(sentence, apiKey);
    }
}
