package studentenadmin;

/**
 * Onderwijs is de superklasse van zowel Opleiding als CPP.
 */
abstract class Onderwijs {

    //  Attributes
    private final String naam;

    //  Constructor
    Onderwijs(String naam) {
        this.naam = naam;
    }

    //  Methods
    String getNaam() {
        return naam;
    }
}
