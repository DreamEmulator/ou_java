package studentenadmin.onderwijs;

public class Opleiding extends Onderwijs {

    //  Attributes
    private final double punten;

    //  Constructor
    public Opleiding(String naam, double punten) {
        super(naam);
        this.punten = punten;
    }

    //  Getters
    public double getPunten() {
        return punten;
    }
}
