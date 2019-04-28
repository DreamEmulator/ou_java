package studentenadmin;

class CPPStudent extends Student {

    //  Attributes
    private final CPP cpp;
    private int behaaldeModules = 0;

    //  Constructor
    CPPStudent(String naam, CPP cpp) {
        super(naam);
        this.cpp = cpp;
    }

    //  Getters
    private boolean isGeslaagd(){ return behaaldeModules >= cpp.getTotaalModules(); }
    String toonInfo (){
        String geslaagd = isGeslaagd() ? "Wel" : "Niet";
        return "Naam: " + naam + ", CPP: " + cpp.getNaam() + ", Behaalde modules: " + behaaldeModules + ", "+ geslaagd + " geslaagd";
    }

    //  Setters
    void verhoogBehaaldeModules() {
        behaaldeModules++;
    }
}
