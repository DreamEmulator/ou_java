package opdracht_03;

class Maaltijd {

    private final String naam;
    private final int tafelNr;

    public Maaltijd(String naam, int tafelNr) {
        this.naam = naam;
        this.tafelNr = tafelNr;
    }

    public int getTafelNr() {
        return tafelNr;
    }

    @Override
    public String toString() {
        return "Maaltijd{" +
                "naam='" + naam + '\'' +
                ", tafelNr=" + tafelNr +
                '}';
    }
}
