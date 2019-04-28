package studentenadmin;

abstract class Onderwijs {
    //  Attrubutes
    private final String naam;

    //  Constructor
    Onderwijs(String naam) {
        this.naam = naam;
    }

    String getNaam() {
        return naam;
    }
}
