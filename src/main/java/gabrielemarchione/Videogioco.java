package gabrielemarchione;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogioco(String idGioco, String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public void schedaProdotto() {
        System.out.println("Videogioco: " + getTitolo() + " (" + getAnnoPubblicazione() + ")");
        System.out.println("Piattaforma: " + piattaforma + ", Durata: " + durataGioco + " ore, Genere: " + genere);
        System.out.println("Prezzo: " + getPrezzo() + "€");
    }
}

