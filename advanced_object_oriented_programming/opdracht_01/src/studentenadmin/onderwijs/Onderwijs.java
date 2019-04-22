package studentenadmin.onderwijs;

abstract class Onderwijs {
    //  Attrubutes
    private final String naam;

    //  Constructor
    Onderwijs(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
