package opdracht_03;

public class Maaltijd {

    private String naam;
    private int tafelNr;

    public Maaltijd(String naam, int tafelNr) {
        this.naam = naam;
        this.tafelNr = tafelNr;
    }

    @Override
    public String toString() {
        return "Maaltijd{" +
                "naam='" + naam + '\'' +
                ", tafelNr=" + tafelNr +
                '}';
    }
}
