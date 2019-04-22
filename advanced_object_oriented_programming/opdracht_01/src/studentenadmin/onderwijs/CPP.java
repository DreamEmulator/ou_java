package studentenadmin.onderwijs;

public class CPP extends Onderwijs {

    //  Attrubutes
    private final int modules;

    //  Constructor
    public CPP(String naam, int modules) {
        super(naam);
        this.modules = modules;
    }

    //  Getters
    public int getModules() {
        return modules;
    }
}
