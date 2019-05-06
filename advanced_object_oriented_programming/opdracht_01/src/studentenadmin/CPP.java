package studentenadmin;
/**
 * Een subklasse van Onderwijs. Een CPP is het onderwijs van de scholers.
 */
class CPP extends Onderwijs {

    //  Attributes
    private final int modules;

    //  Constructor
    CPP(String naam, int modules) {
        super(naam);
        this.modules = modules;
    }

    //  Methods
    int getTotaalModules() {
        return modules;
    }
}
