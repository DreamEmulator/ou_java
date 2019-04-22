package studentenadmin.onderwijs;

public class CPP {

    //  Attrubutes
    private final int modules;
    private final String naam;

    //  Constructor
    public CPP(String naam, int modules) {
        this.naam = naam;
        this.modules = modules;
    }

    //  Getters
    public int getModules() {
        return modules;
    }

    public String getNaam() {
        return naam;
    }
}
