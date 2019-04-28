package studentenadmin;

class Opleiding extends Onderwijs {

    //  Attributes
    private final double punten;

    //  Constructor
    Opleiding(String naam, double punten) {
        super(naam);
        this.punten = punten;
    }

    //  Getters
    double getTotaalPunten() {
        return punten;
    }
}
