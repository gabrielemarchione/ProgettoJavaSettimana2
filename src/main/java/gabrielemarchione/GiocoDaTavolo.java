package gabrielemarchione;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String idGioco, String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, int durataMediaPartita) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    @Override
    public void schedaProdotto() {
        System.out.println("Gioco da tavolo: " + getTitolo() + " (" + getAnnoPubblicazione() + ")");
        System.out.println("Giocatori: " + numeroGiocatori + ", Durata: " + durataMediaPartita + " minuti");
        System.out.println("Prezzo: " + getPrezzo() + "€");
    }
}
