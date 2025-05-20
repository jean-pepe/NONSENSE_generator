package MaGiNiSo.controller;

import MaGiNiSo.service.NonSenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NonSenseController {

    private final NonSenseService nonsenseService;

    public NonSenseController(NonSenseService nonsenseService) {
        this.nonsenseService = nonsenseService;
    }

    @GetMapping("/process")
    public String redirectToForm() {
        return "redirect:/";
    }
    
    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/process")
    public String processSentence(
            @RequestParam String sentence,
            @RequestParam String tense,
            @RequestParam(required = false) String syntacticTree,
            @RequestParam(required = false) String validate,
            @RequestParam(defaultValue = "0") int numStructure,
            @RequestParam String apiKey,
            Model model) {
    	
    	nonsenseService.analyzeSyntax(sentence, tense, apiKey);
    	model.addAttribute("originalSentence", sentence);
        String generatedSentence = nonsenseService.generateSentence(tense, numStructure);
        model.addAttribute("generatedSentence", generatedSentence);
        if ("YES".equals(syntacticTree)) {
        	model.addAttribute("syntacticTree", nonsenseService.printSyntacticTree());  
        }
        if ("YES".equals(validate)) {
            model.addAttribute("validation", nonsenseService.validateSentence(generatedSentence, apiKey));
        }

        return "result";
    }
}