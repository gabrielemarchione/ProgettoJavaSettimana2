package gabrielemarchione;

public abstract class Gioco {
    private String idGioco;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

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

    // Metodo astratto che verrà implementato nelle classi derivate
    public abstract void schedaProdotto();
}
