package gabrielemarchione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogoGiochi {
    private final List<Gioco> giochi;

    // Costruttore lista con i giochi del catalogo precaricati
    public CatalogoGiochi() {
        this.giochi = new ArrayList<>();
        this.giochi.addAll(Arrays.asList(getVideogioco()));
        this.giochi.addAll(Arrays.asList(getGiochiDaTavolo()));
    }

    // Catalogo precaricati
    public static Videogioco[] getVideogioco() {
        return new Videogioco[]{
                new Videogioco("VG01", "The Legend of Zelda, Link's Awakening", 1993, 40.0, "Nintendo", 15, Genere.GDR),
                new Videogioco("VG02", "Final Fantasy VII", 1997, 50.0, "PlayStation", 40, Genere.GDR),
                new Videogioco("VG03", "Elden Ring", 2022, 60.0, "Multi-platform", 100, Genere.SOULSLIKE)
        };
    }

    public static GiocoDaTavolo[] getGiochiDaTavolo() {
        return new GiocoDaTavolo[]{
                new GiocoDaTavolo("GT01", "Risiko", 1968, 35.0, 8, 120),
                new GiocoDaTavolo("GT02", "Monopoly", 1935, 25.0, 6, 120),
                new GiocoDaTavolo("GT03", "Ticket to Ride", 2004, 40.0, 5, 60)
        };
    }

    public boolean aggiungiGioco(Gioco gioco) {
        if (giochi.stream().anyMatch(g -> g.getIdGioco().equals(gioco.getIdGioco()))) {
            System.out.println("Errore: Un gioco con lo stesso ID esiste già.");
            return false;
        }
        giochi.add(gioco);
        return true;
    }

    // Ricerca per ID
    public Optional<Gioco> cercaPerId(String id) {
        return giochi.stream().filter(g -> g.getIdGioco().equals(id)).findFirst();
    }

    // Ricerca per prezzo (uguale o inferiore al valore messo)
    public List<Gioco> cercaPerPrezzo(double prezzo) {
        return giochi.stream().filter(g -> g.getPrezzo() <= prezzo).collect(Collectors.toList());
    }

    // Ricerca per numero di giocatori (solo giochi da tavolo)
    public List<GiocoDaTavolo> cercaPerNumeroGiocatori(int numeroGiocatori) {
        System.out.println("Numero massimo di giocatori inserito: " + numeroGiocatori);  // Debug
        return Arrays.stream(getGiochiDaTavolo())
                .filter(g -> g.getNumeroGiocatori() >= numeroGiocatori)  // Modifica il filtro per includere giochi con numero giocatori >= numero inserito
                .collect(Collectors.toList());
    }


    // Rimozione di un elemento dato un codice ID
    public boolean rimuoviGioco(String id) {
        Optional<Gioco> giocoDaRimuovere = cercaPerId(id);
        if (giocoDaRimuovere.isPresent()) {
            giochi.remove(giocoDaRimuovere.get());
            return true;
        }
        System.out.println("Errore: Gioco non trovato.");
        return false;
    }

    // Aggiornamento di un elemento esistente dato il codice ID
    public boolean aggiornaGioco(String id, Gioco nuovoGioco) {
        Optional<Gioco> giocoEsistente = cercaPerId(id);
        if (giocoEsistente.isPresent()) {
            giochi.remove(giocoEsistente.get());
            giochi.add(nuovoGioco);
            return true;
        }
        System.out.println("Errore: Gioco non trovato.");
        return false;
    }

    // Metodo per stampare la collezione
    public void stampaCollezione() {
        giochi.forEach(Gioco::schedaProdotto);
    }
}
