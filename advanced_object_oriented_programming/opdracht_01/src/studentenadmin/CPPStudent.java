package studentenadmin;

public class CPPStudent extends Student {

    //  Attributes
    private final CPP cpp;
    private int modules = 0;

    //  Constructur
    public CPPStudent(String naam, CPP cpp) {
        super(naam);
        this.cpp = cpp;
    }

    //  Getters
    public int getBehaaldeModules() {
        return modules;
    }
    public CPP getCpp() {
        return cpp;
    }

    //  Setters
    public void moduleBehaald() {
        modules++;
    }
}
