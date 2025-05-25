# Acceptance criteria
1. Given I'm a user,  
   When I choose a sentence template,  
   Then it should be visibly marked as active.
2. Given I'm a user,  
   When I want to choose a sentence structure,  
   Then a list of pre-defined sentence templates should be displayed.
3. Given I'm a user,  
   When I choose a sentence structure,  
   Then the generated sentence should match that structure.
4. Given the frontend web page,  
   When the user enables the toxicity option and the system generates a random sentence,  
   Then the system should also display the toxicity score.
5. Given a sentence is typed in a non-English language,    
   When its words are reused in the future sentence generations,  
   Then the system should still compute a valid confidence level.
6. Given the system receives an input sentence,  
   When it processes the words,  
   Then it should analyze each word and store it in its dictionary.
7. Given new words are added to the dictionaries,   
   When a sentence is generated,   
   Then the new words should be available for the next generations.
8. Given the frontend web page,  
   When the user wants to select the verb tense,  
   Then the system should show the three available tenses: Past, Present and Future.
9. Given I'm a user,  
   When I choose the verb tense,  
   Then the selected option should be clearly highlighted.
10. Given a verb tense is selected,  
    When the system generates a sentence,  
    Then the verb tense should correspond to the selected time.
11. Given a sentence and its morphology are available,  
    When the system saves them,   
    Then they should be stored in a .txt file format.
12. Given the system generates a file,   
    When the process is completed,  
    Then the file should be saved locally on the user's device.
13. Given a new generation is available,  
    When the system saves the new generated sentence and its morphology,  
    Then it should not overwrite the previously saved ones.
14. Given the frontend web page,  
    When the user does not insert an API key,  
    Then the system should show an error message.
15. Given the frontend web page,  
    When the user does not input any sentence,  
    Then the system should show an error message.
16. Given the user does not select the syntactic tree option,  
    When a sentence is generated,   
    Then the system should not display the syntactic tree.
# System test report 
| AcCr ID |  Result | Comments | Date |
|-------|---------|------------|-------|
|   01  |   OK    | Visual indicator appears | 20/05/2025 |
|   02  |   OK    | A dropdown menu displayed | 20/05/2025 |
|   03  |   OK    | Structure respected | 19/05/2025 |
|   04  |   OK    | Score displayed | 19/05/2025 |
|   05  |   OK    | Validated with the natural languages specified in the documentation of analyzeSyntax | 24/05/2025 |
|   06  |   OK    | Word added to its dictionary even if already present | 21/05/2025 |
|   07  |   OK    | New words used | 19/05/2025 |
|   08  |   OK    | A dropdown menu displayed | 20/05/2025 |
|   09  |   OK    | Visual indicator appears | 20/05/2025 |
|   10  |   OK    | Tense correct | 19/05/2025 |
|   11  |   OK    | File format is .txt | 21/05/2025 |
|   12  |   OK    | They are saved in the directory src\main\java\MaGiNiSo | 21/05/2025 |
|   13  |   OK    | First the structure is saved, then the sentence | 20/05/2025 |
|   14  |   OK    | "Please fill out this field" shown | 23/05/2025 |
|   15  |   OK    | "Please fill out this field" shown | 23/05/2025 |
|   16  |   OK    | The syntactic tree is hidden | 19/05/2025 |
