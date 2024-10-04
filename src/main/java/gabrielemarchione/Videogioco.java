package gabrielemarchione;

public class Videogioco extends Gioco {
    private final String piattaforma;
    private final int durataGioco;
    private final Genere genere;

    public Videogioco(String idGioco, String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataGioco, Genere genere) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.genere = genere;
    }


    @Override
    public void schedaProdotto() {
        System.out.println("Videogioco: " + getTitolo() + " (" + getAnnoPubblicazione() + ")");
        System.out.println("Piattaforma: " + piattaforma + ", Durata: " + durataGioco + " ore, Genere: " + genere);
        System.out.println("Prezzo: " + getPrezzo() + "€");
    }
}

