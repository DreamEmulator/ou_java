package studentenadmin;

class CPP extends Onderwijs {

    //  Attrubutes
    private final int modules;

    //  Constructor
    CPP(String naam, int modules) {
        super(naam);
        this.modules = modules;
    }

    //  Getters
    int getTotaalModules() {
        return modules;
    }
}
