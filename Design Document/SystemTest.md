# Acceptance criteria
1. Given I'm a user,  
   When I choose a sentence template,  
   Then it should be visibly marked as active.
2. Given I'm a user,  
   When I want to choose a sentence structure,  
   Then a list of pre-defined sentence templates is shown.
3. Given I'm a user,  
   When I chose a sentence structure,  
   Then the structure of the generated sentence should be the same.
4. Given I'm an administrator,  
   When the user marks the option,  
   Then the system should display the toxicity score.
5. Given I'm an administrator,  
   When the user types a sentence in a language different from English  
   and the words are used again in the next generated sentences,  
   Then the system should still validate the sentence toxicity.
6. Given I'm a developer,  
   When the system receives an input sentence,  
   Then the system analyzes each word and adds it to its dictionary.
7. Given I'm a developer,  
   When the dictionaries are updated with new words,  
   Then the system should be able to use them in the next sentence generation.
8. Given I'm a developer,  
   When the user wants to select the verb tense,  
   Then the system shows the three available tenses: Past, Present and Future.
9. Given I'm a user,  
   When I chose the verb tense,  
   Then the selected option should be clearly highlighted.
10. Given I'm a user,  
    When the system generates a sentence,  
    Then the verb tense should be appropriate to the selected time.
11. Given I'm a developer,  
    When the sentence and its morphology are saved,  
    Then the system should save them in a .txt file format.
12. Given I'm a user,  
    When the file is generated,  
    Then the system saves the file in the local device.
13. Given I'm a developer,  
    When the system saves the new generated sentence and its morphology,  
    Then it doesn't overwrite the previously saved ones.
# System test report 
| n° AC |  Result | Comments | 
|-------|---------|----------|
|   01  |   OK    |
|   02  |   OK    | A dropdown menu is shown |
|   03  |   OK    |
|   04  |   OK    |
|   05  |   OK    | It works with the natural languages specified in the documentation of analyzeSyntax |
|   06  |   OK    | It's added in its dictionary even if already present |
|   07  |   OK    |
|   08  |   OK    | A dropdown menu is shown |
|   09  |   OK    |
|   10  |   OK    |
|   11  |   OK    |
|   12  |   OK    | They are saved in the directory src\main\java\MaGiNiSo |
|   13  |   OK    | First the structure is saved, then the sentence |
