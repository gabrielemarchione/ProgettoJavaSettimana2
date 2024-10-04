package gabrielemarchione;

public abstract class Gioco {
    private final String idGioco;
    private final String titolo;
    private final int annoPubblicazione;
    private final double prezzo;

    public Gioco(String idGioco, String titolo, int annoPubblicazione, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public String getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public abstract void schedaProdotto();
}
