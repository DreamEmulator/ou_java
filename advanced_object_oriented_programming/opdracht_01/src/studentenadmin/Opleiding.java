package studentenadmin;

public class Opleiding {

    //  Attributes
    private final String naam;
    private final double punten;

    //  Constructor
    public Opleiding(String naam, double punten) {
        this.naam = naam;
        this.punten = punten;
    }

    //  Getters
    public String getNaam() {
        return naam;
    }
    public double getPunten() {
        return punten;
    }
}
