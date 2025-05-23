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

* **JDK**  
Per compilare ed eseguire il codice è necessario aver installato JDK.

* **Maven**  
Per avviare il progetto è necessario aver installato e configurato Maven.

* **IDE**  
Opzionale

* **Internet**  
Il computer deve avere accesso ad internet.

* **API KEY**  
Per usufruire di Google Cloud Language API, è necessario inserire la propria API key in un campo di input nella pagina frontend.

* **Sistema operativo**  
Il progetto è stato sviluppato in Java perciò può essere eseguito su qualsiasi sistema operativo che supporta una Java Virtual Machine compatibile, come Windows, macOS e Linux.

## Vincoli su versioni 
* **Java** <br>
Versione minima richiesta: Java 17
* **Maven** <br>
Testato su Maven 3.9.9 ma si consiglia una versione superiore a 3.6.0

## Funzioni principali riusate da librerie esistenti

* **setRequestMethod(String method)** da java.net.HttpURLConnection :<br>Imposta il metodo per la richiesta URL, uno tra: GET/POST/HEAD/OPTIONS/PUT/DELETE/TRACE sono legali, soggetti alle restrizioni del protocollo.

* **setRequestProperty(String key, String value)** da java.net.HttpURLConnection :<br>Sets the general request property. If a property with the key already exists, overwrite its value with the new value.

*  **setDoOutput(boolean dooutput)** da java.net.HttpURLConnection :<br>Sets the value of the doOutput field for this URLConnection to the specified value.

* **getOutputStream()** da java.net.URLConnection :<br>Returns an output stream that writes to this connection.

* **readAllLines(Path path)** da java.nio.file.Files :<br>Bytes from the file are decoded into characters using the UTF-8 charset.

* **write(Path path, Iterable<? extends CharSequence> lines, OpenOption... options)** da java.nio.file.Files :<br>Write lines of text to a file. Characters are encoded into bytes using the UTF-8 charset.

* **get(String first, String... more)** da java.nio.file.Paths :<br>Converts a path string, or a sequence of strings that when joined form a path string, to a Path.

* **optJSONArray(String key)** da org.json.JSONObject :<br>Get an optional JSONArray associated with a key.

* **getJSONObject(int index)** da org.json.JSONArray :<br>Get the JSONObject associated with an index.

<!--* org.springframework.stereotype.Component;
* org.springframework.stereotype.Service;
* * java.nio.charset.StandardCharsets;
* jakarta.annotation.PostConstruct; -->
## API esterne
### Google Natural Language  
* **AnalyzeSyntax**  
    Analizza la struttura sintattica di un testo, restituisce le parti del discorso, l'albero sintattico e la lingua rilevata.
   > https://cloud.google.com/natural-language/docs/analyzing-syntax
* **ModerateText**  
    Analizza un testo e valuta i possibili contenuti inappropriati, restituisce il livello di confidenza. Se questo è maggiore di 0.75 allora il contenuto è probabilmente offensivo, se è maggiore di 0.9 allora è certamente inappropriato.
   > https://cloud.google.com/natural-language/docs/moderating-text

## Informazioni aggiuntive
* La presenza di sole 20 parole per dizionario permette di favorire la selezione delle parole recentemente aggiunte nei dizionari per le frasi successive.
