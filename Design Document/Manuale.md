# Manuale Nonsense Generator
Il programma consiste in un generatore di frasi randomiche che può restituire l'albero sintattico della frase inserita dall'utente e la tossicità della frase generata.  
L'utente può scegliere il tempo verbale dei verbi della frase generata.  
Se selezionato, l'utente riceve l'albero sintattico della frase che ha inserito.  
Inoltre, se desiderato, riceve la validazione della frase generata dal programma, con annesso grado di confidenza.  
Le frasi generate e le rispettive morfologie vengono salvate in un file di testo.  

## Istruzioni per l'installazione
1. Installare Java (versione minima richiesta Java 17)
2. Installare Maven (3.9.9)
3. Scaricare la repository
      * > git clone https://github.com/jean-pepe/NONSENSE_generator.git
      * Altrimenti scarica la repository come zip e estrai i file
4. Aprire il terminale
5. Digitare
   > mvn clean package
7. Digitare
   > mvn spring-boot:run
9. Aprire il browser e digitare nella barra degli indirizzi
    > http://localhost:8080/
   
## Ambienti di esecuzione
## API esterne
* Google Natural Language Analyzing Syntax
   > https://cloud.google.com/natural-language/docs/analyzing-syntax
* Google Natural Language Moderate Text
   > https://cloud.google.com/natural-language/docs/moderating-text
* Spring Boot
## Informazioni aggiuntive
*
