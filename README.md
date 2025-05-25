# NONSENSE_generator
 Software Engineering project for the final course exam A.A. 2024-25
---------
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
      * Altrimenti scaricare la repository come zip e estrarre i file
4. Aprire il terminale
5. Andare nella directory contenente il progetto
6. Digitare
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

* **setRequestMethod(String method)** da java.net.HttpURLConnection :<br><br>
Imposta il tipo di richiesta HTTP che verrà inviata al server.

* **setRequestProperty(String key, String value)** da java.net.HttpURLConnection :<br><br>Aggiunge o sovrascrive una proprietà della richiesta HTTP prima dell'invio.

*  **setDoOutput(boolean dooutput)** da java.net.HttpURLConnection :<br><br>Se impostato a true, abilita lo stream di output.

* **getOutputStream()** da java.net.URLConnection :<br><br>Permette di inviare dati al server come parte del corpo della richiesta HTTP.

* **readAllLines(Path path)** da java.nio.file.Files :<br><br>Legge il contenuto del file specificato dal Path, restituisce una lista dove ogni elemento è una riga del file.

* **write(Path path, Iterable<? extends CharSequence> lines, OpenOption... options)** da java.nio.file.Files :<br><br>Scrive le righe fornite nel file indicato da path.

* **get(String first, String... more)** da java.nio.file.Paths :<br><br>Costruisce un oggetto Path combinando i segmenti forniti.

* **optJSONArray(String key)** da org.json.JSONObject :<br><br>Cerca il valore associato alla chiave specificata, se esiste lo restituisce.

* **getJSONObject(int index)** da org.json.JSONArray :<br><br>Accede all'elemento alla posizione index in un JSONArray, se è un JSONObject, lo restituisce.

## API esterne
### Google Natural Language  
* **AnalyzeSyntax**  
    Analizza la struttura sintattica di un testo, restituisce le parti del discorso, l'albero sintattico e la lingua rilevata.
   > https://cloud.google.com/natural-language/docs/analyzing-syntax
* **ModerateText**  
    Analizza un testo e valuta i possibili contenuti inappropriati, restituisce il livello di confidenza. Se questo è maggiore di 0.75 allora il contenuto è probabilmente offensivo, se è maggiore di 0.9 allora è certamente inappropriato.
   > https://cloud.google.com/natural-language/docs/moderating-text

