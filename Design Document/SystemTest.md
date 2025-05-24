# Acceptance criteria
1. Given I'm a system user,  
 When I choose a sentence template,  
 Then it should be visibly marked as active.
2. Given I'm a system user,  
   When I want to choose a sentence structure,  
   Then a list of pre-defined sentence templates is shown.
3. Given I'm a system user,  
   When I chose a sentence structure,  
   Then the structure of the generated sentence should be the same.
4. Given I'm an administrator,  
   When the user marks the option,  
   Then the system should display the toxicity score.
5. Given I'm an administrator,
   When the system generates an offensive sentence
   and the nouns aren't in English and 

# System test report
- [x] the system should recognize the toxicity score in English language 

- [x]  the system should recognize the toxicity score in Italian language 

- [x]  the system should recognize the toxicity score in Spanish language 

- [x] Given a user inputs sentence the system add any words in the existing dictionary.

- [x] Given the dictionary is updated with new words the system should be able to use the newly added words in sentence generation.

- [x] The system shows the three available time choices: Past, Present, and Future.

- [x] When the user sees the time options, the selected option should be clearly highlighted.

- [x] The sentence should use the verbs tenses appropriate to the selected time

- [x] When the sentence and morphology are saved, the system should save them in a .txt file format.

- [x] The saved file should include : the generated sentence and the morphological analysis (e.g., parts of speech, verb forms)
 
- [x] When the file is generated the system saves the file in the local device.

- [x]  The system should allow saving of multiple generated sentences without overwriting previously saved files.
