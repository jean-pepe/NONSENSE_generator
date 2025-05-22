# Manuale Nonsense Generator
Il progetto consiste in un generatore di frasi randomiche grammaticalmente corrette realizzato in Java con ulteriori funzionalità.  
  
Le funzionalità principali sono:  
* L'utente può selezionare il tempo verbale dei verbi presenti nella frase generata.
* Le parole della frase inserita dall'utente vengono classificate in categorie grammaticali tipo nomi, verbi, aggettivi, congiunzioni, avverbi, pronomi, punteggiatura, numeri e preposizioni.
* I nomi, verbi e aggettivi riconosciuti nella frase dell'utente vengono aggiunti ai dizionari così da essere utilizzati nelle generazioni successive.
* L'utente può scegliere la morfologia della frase generata oppure lasciare che venga scelta randomicamente.
* Se richiesta, viene prodotta una rappresentazione testuale dell'albero sintattico della frase inserita dall'utente.
* Se richiesto, il sistema verifica la tossicità e il contenuto offensivo della frase generata.
* Tutte le frasi generate, assieme alla loro struttura, vengono salvate in un file di testo.

## Istruzioni per l'installazione
1. Installare Java
2. Installare Maven
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
### JDK  
Per compilare ed eseguire il codice è necessario aver installato JDK.
### Maven
Per avviare il progetto è necessario aver installato e configurato Maven.
### API KEY
Per usufruire di Google Cloud Language API, è necessario inserire la propria API key in una casella della pagina frontend.
### Internet
Il computer deve avere accesso ad internet.
### Sistema operativo
Il progetto è stato sviluppato in Java perciò può essere eseguito su qualsiasi sistema operativo che supporta una Java Virtual Machine compatibile, come Windows, macOS e Linux.
## Vincoli su versioni 
(versione minima richiesta Java 17)
 (3.9.9)
## API esterne
* Google Natural Language Analyzing Syntax
   > https://cloud.google.com/natural-language/docs/analyzing-syntax
* Google Natural Language Moderate Text
   > https://cloud.google.com/natural-language/docs/moderating-text
* Spring Boot
## Metodi usati da librerie utilizzate 
* java.io.*;

* java.net.HttpURLConnection;
* java.net.URL;
* java.nio.charset.StandardCharsets;
* java.nio.file.Files;
* java.nio.file.Path;
* java.nio.file.StandardOpenOption;

* jakarta.annotation.PostConstruct;

* org.json.JSONArray;
* org.json.JSONObject;

* org.springframework.stereotype.Component;
* org.springframework.stereotype.Service;

## Informazioni aggiuntive
*
