**Software per la gestione ed ottimizzazione delle prenotazioni delle lezioni: il caso di un'associazione per DSA**

1.1 Descrizione del problema proposto

Lavorando in un’associazione che fornisce tra i vari servizi quello di tutoraggio e ripetizioni per gli studenti, dalle scuole Elementari all’Università, ho riscontrato come la gestione delle prenotazioni possa essere problematica, soprattutto se non gestita correttamente. È presente una richiesta altamente variabile da parte degli studenti che dipende dal periodo scolastico in cui ci si trova. I tutor, a loro volta, garantiscono delle disponibilità che possono variare da settimana a settimana e non garantiscono di poter seguire tutte le materie scolastiche. Ad oggi le prenotazioni sono gestite dal solo utilizzo di un foglio di calcolo di Excel, questo metodo presenta alcune problematiche date dalla difficoltà nel reperire informazioni su studenti, tutor e sulle lezioni svolte in passato. La mancanza di programmazione dovuta dalla compilazione del calendario, che viene fatta giornalmente, comporta un aumento del rischio di imprevisti e del tempo richiesto. 


 1.2 Descrizione della rilevanza gestionale del problema

Per questo problema è fondamentale la componente gestionale perché per poter migliorare l’efficienza delle prenotazioni è importante l’organizzazione nella fase iniziale dell’assegnazione della lezione al tutor. Il ‘collo di bottiglia’ del processo sono, appunto, i tutor per via della loro disponibilità variabile e l’impossibilità di seguire tutte le materie scolastiche quindi, la loro gestione diventa fondamentale per poter aumentare il numero di lezioni annue. Un altro problema che può essere risolto è la tempestività nel risolvere eventuali problemi di accoppiamento tutor-studente. Lo scopo del progetto è quello di confrontare in 5/6 mesi i tre metodi di prenotazione: quello utilizzato fino ad oggi dall’associazione, quello con l’utilizzo di questo programma in modalità ‘manuale’ sfruttando la tab 'GESTISCI LEZIONI' e in modalità ‘automatica’ con ‘CALCOLA LEZIONI GIORNO’ con lo scopo di capire le reali funzionalità e limiti del metodo automatico.






1.3 Descrizione dei Data-Set per la valutazione

I Data-Set utilizzati saranno creati da zero grazie ai dati reali che mi verranno forniti dall’associazione. Il campione preso in esame comprenderà gli anni scolastici 2022/23 e 2023/24 nei quali saranno presi per il campione circa 200/250 studenti e 15/20 tutor ogni anno e tutte le lezioni prenotate durante l’anno solare. Il Data-Set sarà strutturato in modo da avere cinque tabelle: una in cui saranno memorizzati gli studenti registrati per l’anno accademico, una in cui saranno memorizzati i tutor reperibili, una per le lezioni prenotate, una per le disponibilità dei tutor ed infine una con l’elenco di tutte le materie che possono essere selezionate per prenotare una lezione. 


1.4 Descrizione preliminare degli algoritmi coinvolti

Nell’applicazione saranno presenti quattro schede: Gestisci lezioni, Gestisci studenti, Gestisci tutor e Resoconto. La sezione più rilevante a livello di algoritmi è quella ‘Gestisci lezione’ nella quale ci saranno tre sezioni: ‘Lezioni singole’, ‘Lezioni multiple’ e ‘Lezioni giornaliere’. Nella sezione ‘Lezioni multiple’ sarà possibile prenotare e gestire più lezioni contemporaneamente grazie a due algoritmi:

•	CALCOLA LEZIONI: Se uno studente dovrà prenotare più di una lezione, sarà possibile svolgerlo in maniera automatica tramite questo pulsante. In un primo momento verranno aggiunte tutte le lezioni richieste, senza selezionare il tutor a cui affidare la lezione. In un secondo momento il programma calcolerà i migliori accoppiamenti possibili con i tutor grazie ad una tabella di punteggi in cui il peso è determinato grazie ad una tabella dei punteggi precedentemente stabilita in collaborazione con l’associazione. Lo scopo dell’algoritmo sarà quello di massimizzare quindi il punteggio di ogni assegnazione per poter garantire il miglior servizio possibile. La preparazione del tutor non è il solo criterio che verrà analizzato perché, a parità di punteggio finale, sarà preferita la soluzione che permetta di impiegare il maggior numero di tutor già a contratto piuttosto che i liberi professionisti, che collaborano con l'associazione e che possono essere assunti ‘a chiamata’. L’algoritmo avrà lo scopo di trovare il percorso di assegnazione Studenti-Tutor che garantisca il maggior punteggio possibile tenendo però conto dei vincoli sulla preparazione dei tutor (nessun accoppiamento sarà accettato se il suo punteggio sarà inferiore a 1), sul numero di tutor già a contratto (massimizzare questo numero per aumentare i ricavi) e sulla presenza di un certificato come educatore.

•	CALCOLA LEZIONI GIORNO: Questo programma è pensato per essere utilizzato per calcolare il calendario delle lezioni per una data selezionata oppure nei casi di ‘emergenza’ nei quali uno studente o un tutor chiedono un cambiamento e c’è la necessità di riorganizzare tutte le lezioni della giornata. Il principio di funzionamento è il medesimo di ‘CALCOLA LEZIONE’, una funzione ricorsiva dove il peso è calcolato con lo stesso metodo visto in precedenza. In questo caso per gli n studenti che hanno prenotato la lezione al giorno selezionato cerco quale degli m tutor che ha dato disponibilità fornisca, nel complessivo, la soluzione migliore. I vincoli e i punteggi utilizzati all’interno dell’algoritmo rimangono invariati.


1.5	Descrizione preliminare delle funzionalità dell’applicazione Software

L’applicazione è pensata per essere utilizzata dalla persona preposta alle prenotazioni delle lezioni e dal tesoriere dell’associazione per compilare il resoconto mensile riguardante i dipendenti. Nella sezione ‘Gestisci Lezioni’ sarà possibile prenotare, modificare o cancellare lezioni singole o multiple. Per la prenotazione di lezioni multiple sarà possibile scegliere se effettuarla in modalità ‘Manuale’, nella quale sarà l’operatore a scegliere gli abbinamenti migliori o in modalità ‘Automatica’ dove sarà il Software a calcolare gli abbinamenti Tutor-Studenti che totalizzino il punteggio maggiore. Le sezioni ‘Gestisci studenti’ e ‘Gestisci Tutor’ sono dedicate all’inserimento e alla gestione dei dati degli studenti e tutor nel database. La sezione ‘Resoconto’ è dedicata alla stampa delle lezioni ed ore dei tutor (o studenti) nel mese selezionato.
