package opdracht_03;

/**
 * Maaltijd klasse is een een simpele klasse met twee getters en een toString
 */
class Maaltijd {

    private final String naam;
    private final int tafelNr;

    Maaltijd(String naam, int tafelNr) {
        this.naam = naam;
        this.tafelNr = tafelNr;
    }

    int getTafelNr() {
        return tafelNr;
    }

    /**
     * toString methode maakt zichtbaar wat de inhoud van een maaltijd
     * @return
     */
    @Override
    public String toString() {
        return "Maaltijd{" +
                "naam='" + naam + '\'' +
                ", tafelNr=" + tafelNr +
                '}';
    }
}
