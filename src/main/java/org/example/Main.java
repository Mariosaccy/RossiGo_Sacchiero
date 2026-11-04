/*
* Scenario
Una startup locale di sharing di monopattini e bici elettriche ti ha assunto come sviluppatore backend. Prima di costruire app e server, vuole un nucleo Java testabile da terminale che gestisca sblocco, noleggio e ricarica dei mezzi. Il vero problema sono i casi limite: batteria scarica, utente con credito esaurito, mezzo già in uso, utente con codice fiscale non valido. Ogni errore deve essere modellato in modo chiaro, perché il team dell'app mobile userà le tue eccezioni per decidere cosa mostrare al cliente. Flotta, utenti e crediti devono inoltre sopravvivere al riavvio del programma, quindi i dati vanno salvati in un database.
Obiettivi
Creare un progetto Maven da zero e gestirne le dipendenze nel pom.xml
Scegliere, scaricare e usare librerie esterne tramite Maven
Applicare ereditarietà e polimorfismo
Progettare una gerarchia di eccezioni personalizzate
Rendere persistenti i dati con un database SQLite tramite JDBC
Organizzare il codice in package con responsabilità chiare
Consegnare il lavoro tramite un repository GitHub
* 3. Modello ed ereditarietà
Crea una gerarchia di veicoli:
Veicolo (classe astratta): codice, livello batteria in %, stato (LIBERO, IN_USO, IN_RICARICA), con i metodi astratti:
double calcolaCosto(int minuti)
double consumoBatteriaPerMinuto() (in % al minuto)
Bici estende Veicolo: ha un numero di marce e una tariffa più bassa (es. 0,15 €/min) e consuma poca batteria, perché la pedalata assistita aiuta.
Monopattino estende Veicolo: ha una velocità massima e una tariffa più alta (es. 0,25 €/min), con consumo più alto.
Ogni sottoclasse deve sovrascrivere i metodi astratti. Inoltre, dai a una delle due una caratteristica propria (es. Monopattino.isLimitatoInZonaPedonale() oppure Bici.getNumeroMarce()).
Poi crea:
Utente (id, nome, email, codice fiscale, credito in euro)
Noleggio (utente, veicolo, orario di inizio, orario di fine)
FlottaService (gestisce veicoli, utenti e noleggi attivi). Deve lavorare con il tipo Veicolo, mai con Bici o Monopattino direttamente: è questo il polimorfismo.

4. Eccezioni custom
Crea RossiGoException (che estende Exception) e almeno sei eccezioni figlie:
Eccezione
Quando scatta
VeicoloNonDisponibileException
il veicolo è già in uso o in ricarica
BatteriaScaricaException
batteria sotto il 15%
CreditoInsufficienteException
credito sotto la soglia di sblocco (es. 1 €)
UtenteNonTrovatoException
l'id utente non esiste
CodiceFiscaleNonValidoException
il codice fiscale fornito in registrazione non è valido
ErroreDatabaseException
qualsiasi SQLException incontrata durante la lettura o la scrittura dei dati

Ogni eccezione deve avere un costruttore con messaggio e uno con messaggio e causa. Come extra, aggiungi un campo utile al chiamante: ad esempio BatteriaScaricaException può esporre getLivelloAttuale(), così l'app può mostrare "Batteria al 9%, scegli un altro mezzo".
5. Operazioni
In FlottaService:
registraVeicolo(Veicolo v) e registraUtente(Utente u) (quest'ultimo valida il codice fiscale)
sbloccaVeicolo(String codice, String idUtente), che lancia le eccezioni sopra
terminaNoleggio(String codice, int minutiUsati): addebita 1 € di sblocco + calcolaCosto(minuti) e scala la batteria usando consumoBatteriaPerMinuto(). Il costo cambia in base al tipo di veicolo senza nessun if/instanceof.
mettiInRicarica(String codice)
Ogni operazione che modifica lo stato (registrazioni, sblocco, termine del noleggio, ricarica) deve aggiornare anche il database.
6. Persistenza con SQLite (obbligatoria)
Usa Xerial (org.xerial:sqlite-jdbc) per salvare i dati:
database rossigo.db con tabelle veicoli, utenti, noleggi (aggiungi una colonna tipo per distinguere bici e monopattini); le tabelle vengono create automaticamente al primo avvio se non esistono
alla seconda esecuzione, flotta, utenti e crediti devono essere ancora lì
l'accesso al database sta in classi dedicate con il design pattern singleton nel package persistenza, separate da FlottaService
incapsula ogni SQLException in ErroreDatabaseException, senza mostrare dettagli tecnici all'utente
usa PreparedStatement e try-with-resources
7. Simulazione nel Main
All'avvio stampa il titolo del programma in ASCII art. Poi simula una giornata in città con almeno 6 scenari, di cui almeno 4 che generano un'eccezione. Usa sia bici sia monopattini. Gestisci tutto con try/catch e stampa messaggi pensati per l'utente finale, non stack trace.
Esempi di scenario:
l'utente prova a sbloccare un monopattino mentre il suo credito è a 0,50 €
si registra un utente con un codice fiscale sbagliato
si tenta di sbloccare una bici già in uso
Uno degli scenari deve dimostrare la persistenza: chiudi il programma e riavvialo, poi mostra che i dati (per esempio il credito residuo di un utente) sono ancora presenti.

*/

package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }
    }
}
