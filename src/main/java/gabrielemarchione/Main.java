package gabrielemarchione;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CatalogoGiochi collezione = new CatalogoGiochi();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Aggiungi gioco");
            System.out.println("2. Cerca gioco per ID");
            System.out.println("3. Cerca giochi per Prezzo");
            System.out.println("4. Cerca giochi da Tavolo per Numero di Giocatori");
            System.out.println("5. Rimuovi gioco per ID");
            System.out.println("6. Aggiorna gioco per ID");
            System.out.println("7. Stampa collezione");
            System.out.println("0. Esci");
            System.out.print("Scegli un opzione: ");
            if (scanner.hasNextInt()) {
                int scelta = scanner.nextInt();
                scanner.nextLine();

            switch (scelta) {
                case 1: // Aggiungi gioco
                    System.out.println("Aggiungi videogioco (V) o gioco da tavolo (T)?");
                    String tipo = scanner.nextLine().toUpperCase();
                    System.out.print("Inserisci ID: (VGXX OPPURE GTXX)");
                    String id = scanner.nextLine();
                    System.out.print("Inserisci titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Inserisci anno pubblicazione: ");
                    int anno = scanner.nextInt();
                    System.out.print("Inserisci prezzo: ");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();

                    if (tipo.equals("V")) {
                        System.out.print("Inserisci piattaforma: ");
                        String piattaforma = scanner.nextLine();
                        System.out.print("Inserisci durata di gioco (in ore): ");
                        int durata = scanner.nextInt();
                        System.out.print("Inserisci genere (AZIONE, AVVENTURA, GDR, SPARATUTTO, SPORTIVO, STRATEGIA): ");
                        String genereStr = scanner.next().toUpperCase();
                        Genere genere = Genere.valueOf(genereStr);
                        Videogioco videogioco = new Videogioco(id, titolo, anno, prezzo, piattaforma, durata, genere);
                        collezione.aggiungiGioco(videogioco);
                    } else if (tipo.equals("T")) {
                        System.out.print("Inserisci numero di giocatori: ");
                        int numeroGiocatori = scanner.nextInt();
                        System.out.print("Inserisci durata media di una partita (in minuti): ");
                        int durataPartita = scanner.nextInt();
                        GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo(id, titolo, anno, prezzo, numeroGiocatori, durataPartita);
                        collezione.aggiungiGioco(giocoDaTavolo);
                    } else {
                        System.out.println("Input non valido. Puoi inserire solo V per Videogioco o T per Gioco da Tavolo.");
                    }
                    break;

                case 2:
                    System.out.print("Inserisci ID del Gioco da Cercare:(VGXX OPPURE GTXX ");
                    String idCerca = scanner.nextLine();
                    collezione.cercaPerId(idCerca).ifPresentOrElse(
                            Gioco::schedaProdotto,
                            () -> System.out.println("Gioco non presente.")
                    );
                    break;

                case 3:
                    System.out.print("Inserisci il prezzo massimo: ");
                    double prezzoCerca = scanner.nextDouble();
                    collezione.cercaPerPrezzo(prezzoCerca).forEach(Gioco::schedaProdotto);
                    break;

                case 4: // Cerca giochi da tavolo per numero massimo di giocatori
                    System.out.print("Inserisci il numero massimo di giocatori: ");
                    int numeroGiocatori = scanner.nextInt();
                    collezione.cercaPerNumeroGiocatori(numeroGiocatori)
                            .forEach(GiocoDaTavolo::schedaProdotto);
                    break;


                case 5: // Rimuovi gioco per id
                    System.out.print("Inserisci ID del gioco da rimuovere:(VGXX OPPURE GTXX ");
                    String idRimuovi = scanner.nextLine();
                    if (collezione.rimuoviGioco(idRimuovi)) {
                        System.out.println("Gioco rimosso con successo.");
                    } else {
                        System.out.println("Gioco non trovato.");
                    }
                    break;

                case 6: // Aggiorna gioco per id
                    System.out.print("Inserisci ID del gioco da aggiornare:(VGXX OPPURE GTXX(VGXX OPPURE GTXX ");
                    String idAggiorna = scanner.nextLine();
                    System.out.println("Aggiungi videogioco (V) o gioco da tavolo (T)?");
                    String tipoAgg = scanner.nextLine().toUpperCase();
                    System.out.print("Inserisci Titolo: ");
                    String titoloAgg = scanner.nextLine();
                    System.out.print("Inserisci anno pubblicazione: ");
                    int annoAgg = scanner.nextInt();
                    System.out.print("Inserisci prezzo: ");
                    double prezzoAgg = scanner.nextDouble();
                    scanner.nextLine();

                    if (tipoAgg.equals("V")) {
                        System.out.print("Inserisci piattaforma: ");
                        String piattaformaAgg = scanner.nextLine();
                        System.out.print("Inserisci durata di gioco (in ore): ");
                        int durataAgg = scanner.nextInt();
                        System.out.print("Inserisci genere (AZIONE, AVVENTURA, GDR, SPARATUTTO, SPORTIVO, STRATEGIA): ");
                        String genereStrAgg = scanner.next().toUpperCase();
                        Genere genereAgg = Genere.valueOf(genereStrAgg);
                        Videogioco videogiocoAgg = new Videogioco(idAggiorna, titoloAgg, annoAgg, prezzoAgg, piattaformaAgg, durataAgg, genereAgg);
                        if (collezione.aggiornaGioco(idAggiorna, videogiocoAgg)) {
                            System.out.println("Gioco aggiornato con successo.");
                        } else {
                            System.out.println("Errore: Gioco non trovato.");
                        }
                    } else if (tipoAgg.equals("T")) {
                        System.out.print("Inserisci numero di giocatori: ");
                        int numeroGiocatoriAgg = scanner.nextInt();
                        System.out.print("Inserisci durata media di una partita (in minuti): ");
                        int durataPartitaAgg = scanner.nextInt();
                        GiocoDaTavolo giocoDaTavoloAgg = new GiocoDaTavolo(idAggiorna, titoloAgg, annoAgg, prezzoAgg, numeroGiocatoriAgg, durataPartitaAgg);
                        if (collezione.aggiornaGioco(idAggiorna, giocoDaTavoloAgg)) {
                            System.out.println("Gioco aggiornato con successo.");
                        } else {
                            System.out.println("Errore: Gioco non trovato.");
                        }
                    }
                    break;

                case 7:
                    collezione.stampaCollezione();
                    break;

                case 0:
                    System.out.println("Uscita...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opzione non valida, riprova.");
                    break;
            }
        } else {
            System.out.println("Input non valido. Inserisci un numero compreso tra 0 e 7.");
            scanner.next();
        }
    }
}
}
