package studentenadmin;

/**
 * Een subklasse van Onderwijs. Opleiding is het onderwijs van de reguliere studenten.
 */
class Opleiding extends Onderwijs {

    //  Attributes
    private final double punten;

    //  Constructor
    Opleiding(String naam, double punten) {
        super(naam);
        this.punten = punten;
    }

    //  Methods
    double getTotaalPunten() {
        return punten;
    }
}
